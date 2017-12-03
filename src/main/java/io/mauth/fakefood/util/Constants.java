package io.mauth.fakefood.util;

/**
 * Created by rahulb on 2/12/17.
 */
public class Constants {

    public static String text = "Hey, I want to verify the authenticity of the whey protein.\n" +
            "The details of the protein are:- \n "+
            "Name :-  %s\n" +
            "company :- %s\n"+
            "Size :- %s\n"+
            "Flavour :- %s\n"+
            "PlaceOfPurchase :- %s\n"+
            "LotNumber :- %s\n"+
            "ExpirationCode :- %s\n"+
            "BarCode :- %s\n"+
            "I am attaching the image of the box.\n" +
            "Please confirm the authenticity !!\n" +
            "Thanks\n";

    public static String SUBJECT_PATH="audit_request_template_en_subject.vm";
    public static String BODY_PATH="audit_request_template_en_body.vm";
}
