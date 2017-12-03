package io.mauth.fakefood.core.annotation;

import java.lang.annotation.*;

/**
 * @author anupk
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Inherited
public @interface Loggable {

}
