package io.mauth.fakefood.util;



import io.mauth.fakefood.core.annotation.DoNotAudit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Unwrap Composite Objects belonging to pw into logical String representation.
 * Gives preference to overridden toString method i.e if the pw object override the toString method then the toString method
 * is used to evaluate the String representation of the object avoiding unwrapping through reflection.
 * Further to prevent a Field or Class from being included for Auditing mark it with @DoNotAudit
 */
public class ObjectStringifier {
    private static final String SKIPPED_DO_NOT_AUDIT = ":Skipped;@DoNotAudit";
    private static final String CLOSING_SQUARE_BRACE = "]";
    private static final String OPENING_SQUARE_BRACE = "[";
    private static final String EQUAL_TO = "=";
    private static final String CLOSING_CURLY_BRACE = "}";
    private static final String COLON = ":";
    private static final String SEMICOLON = ";";
    private static final String OPENING_CURLY_BRACE = "{";
    private List<Object> unwrappedObjects = new ArrayList<Object>();

    public String toString(Object object, String objname, Annotation[] annotations) {
        if (object == null) {
            return objname + ":{null}";
        }

        if (!objectShouldBeAudited(annotations)) {
            return objname + SKIPPED_DO_NOT_AUDIT;
        }

        if (objectAlreadyUnwrapped(object)) {
            return objname + ":{self reference; skipped}";
        }

        cacheUnwrappedObject(object);
        StringBuilder unwrapedObject = new StringBuilder();
        if (!"".equals(objname)) {
            unwrapedObject.append(objname + COLON);
        }
        if (isSimpleType(object)) {
            unwrapedObject.append(object.toString());
        } else if (isCollection(object)) {
            unwrapedObject.append(unwrapCollection((Collection<?>) object));
        } else if (isArray(object)) {
            unwrapedObject.append(unwrapArray(object));
        } else if (isMap(object)) {
            unwrapedObject.append(unwrapMap((Map<?, ?>) object));
        } else {
            unwrapedObject.append(unwrapCompositeObject(object));
        }
        return unwrapedObject.toString();

    }

    private boolean objectShouldBeAudited(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(DoNotAudit.class)) {
                return false;
            }
        }
        return true;
    }

    private boolean overrideToString(Object object) {
        try {
            object.getClass().getDeclaredMethod("toString");
        } catch (NoSuchMethodException exception) {
            return false;
        }
        return true;
    }

    private boolean objectAlreadyUnwrapped(Object object) {
        return unwrappedObjects.contains(object);
    }

    private void cacheUnwrappedObject(Object object) {
        if (!isSimpleType(object)) {
            unwrappedObjects.add(object);
        }
    }

    private Object unwrapMap(Map<?, ?> map) {
        StringBuilder unwrapedMap = new StringBuilder();
        if (isMapOfSimpleTypes(map)) {
            return map.toString();
        }
        unwrapedMap.append(OPENING_CURLY_BRACE);
        for (int i = 0; i < map.keySet().size(); i++) {
            Object key = map.keySet().toArray()[i];
            appendCommaIfNotFirstField(unwrapedMap, i);
            unwrapedMap.append(key.toString());
            unwrapedMap.append(EQUAL_TO);
            unwrapedMap.append(toString(map.get(key), "", new Annotation[0]));
        }
        unwrapedMap.append(CLOSING_CURLY_BRACE);
        return unwrapedMap.toString();
    }

    private void appendCommaIfNotFirstField(StringBuilder unwrapedMap, int i) {
        if (i > 0) {
            unwrapedMap.append(", ");
        }
    }

    private boolean isMapOfSimpleTypes(Map<?, ?> map) {
        if (map.size() == 0) {
            return true;
        }
        return isSimpleType(map.values().toArray()[0]);
    }

    private String unwrapArray(Object array) {
        StringBuilder unwrapedArray = new StringBuilder();
        unwrapedArray.append(OPENING_SQUARE_BRACE);
        Class<?> componentType = array.getClass().getComponentType();
        if (!isPrimitive(componentType)) {
            Object[] objectArray = (Object[]) array;
            for (int i = 0; i < objectArray.length; i++) {
                appendCommaIfNotFirstField(unwrapedArray, i);
                unwrapedArray.append(toString(objectArray[i], "", new Annotation[0]));
            }
        } else {
            unwrapedArray.append("unable unwrap array of primitives!");
        }
        unwrapedArray.append(CLOSING_SQUARE_BRACE);

        return unwrapedArray.toString();
    }

    private boolean isPrimitive(Class<?> clazz) {
        return clazz.equals(int.class) || clazz.equals(long.class) || clazz.equals(boolean.class)
                || clazz.equals(char.class) || clazz.equals(byte.class) || clazz.equals(short.class)
                || clazz.equals(float.class) || clazz.equals(double.class) || clazz.equals(void.class);
    }

    private boolean isArray(Object object) {
        return object.getClass().isArray();
    }

    private boolean isCollectionOfSimpleTypes(Collection<?> collection) {
        if (collection.isEmpty()) {
            return true;
        }

        return isSimpleType(collection.toArray()[0]);
    }

    private boolean isCollection(Object object) {
        return object instanceof Collection;
    }

    private String unwrapCollection(Collection<?> collection) {
        StringBuilder unwrapedCollection = new StringBuilder();
        if (isCollectionOfSimpleTypes(collection)) {
            return collection.toString();
        }
        unwrapedCollection.append(OPENING_SQUARE_BRACE);
        Object[] collectionAsArray = collection.toArray();
        for (int i = 0; i < collectionAsArray.length; i++) {
            appendCommaIfNotFirstField(unwrapedCollection, i);
            unwrapedCollection.append(toString(collectionAsArray[i], "", new Annotation[0]));
        }
        unwrapedCollection.append(CLOSING_SQUARE_BRACE);
        return unwrapedCollection.toString();
    }

    private void appendSemiColonIfNotFirstField(StringBuilder result, int i) {
        if (i > 0) {
            result.append(SEMICOLON);
        }
    }

    private Object fieldValueInObject(Field field, Object object) {
        return org.fest.reflect.core.Reflection.field(field.getName()).ofType(field.getType()).in(object).get();
    }



    private boolean isMap(Object object) {
        return object instanceof Map;
    }

    private String unwrapCompositeObject(Object object) {
        StringBuilder unwrapedObject = new StringBuilder();
        unwrapedObject.append(OPENING_CURLY_BRACE);

        if (isSiteObject(object) && !overrideToString(object)) {
            Field[] fields = object.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                appendSemiColonIfNotFirstField(unwrapedObject, i);
                if (isSkippedFromAuditing(field)) {
                    unwrapedObject.append(field.getName() + SKIPPED_DO_NOT_AUDIT);
                } else {
                    unwrapedObject.append(toString(fieldValueInObject(field, object), field.getName(),
                            new Annotation[0]));
                }
            }
        } else {
            unwrapedObject.append(object.toString());
        }

        unwrapedObject.append(CLOSING_CURLY_BRACE);
        return unwrapedObject.toString();
    }

    private boolean isSkippedFromAuditing(Field field) {
        return (field.getAnnotation(DoNotAudit.class) != null)
                || (field.getType().getAnnotation(DoNotAudit.class) != null);
    }

    private boolean isSiteObject(Object object) {
        try {
            String packageName = object.getClass().getPackage().getName();
            return (packageName != null) && packageName.startsWith("com.endurance.calico.site");
        } catch (NullPointerException exception) {
            return false;
        }
    }

    private boolean isSimpleType(Object object) {
        return isPrimitiveWrapper(object.getClass()) || object.getClass().isEnum() || (object instanceof String);
    }

    private boolean isPrimitiveWrapper(Class<? extends Object> clazz) {
        return clazz.equals(Integer.class) || clazz.equals(Long.class) || clazz.equals(Boolean.class)
                || clazz.equals(Character.class) || clazz.equals(Byte.class) || clazz.equals(Short.class)
                || clazz.equals(Float.class) || clazz.equals(Double.class) || clazz.equals(Void.class);
    }

}