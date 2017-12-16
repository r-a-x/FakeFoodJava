package io.mauth.fakefood.util;

/**
 * A handy SMTP test driver using JavaMail. Uses version 1.5.2 of JavaMail.
 * @see <a href="https://java.net/projects/javamail/pages/Home">JavaMail</a>
 * <p>
 * This class works with a property file that is expected in the test subfolder, 
 * e.g. test/test.properties. It should be of the form:
 * <p>
 * # SSL/TLS port: 465
 * # Otherwise: 587
 * smtp.host=smtp.mail.yahoo.com
 * smtp.port=465
 * smtp.useSsl=true
 *
 * # Change these...
 * smtp.user=user@yahoo.com
 * smtp.from=legit_user@yahoo.com
 * smtp.to=user@gmail.com,user2@gmail.com
 * smtp.subject=Java Mail Test Subject
 * smtp.text=This is a test message sent from a Java test driver. Please enjoy!
 * <p>
 * The following code sample is taken from the Gmail example from the JavaMail FAQ.
 * @see <a href="http://www.oracle.com/technetwork/java/javamail/faq/index.html#gmail">Gmail Example</a>
 * <p>
 * {@code
 * String host = "smtp.gmail.com";
 * Properties prop = loadProperties();
 *
 * final String user = prop.getProperty("smtp.user");
 * final String password = prop.getProperty("smtp.pass");
 * Properties smtpProps = new Properties();
 * Session session = Session.getInstance(smtpProps);
 * Transport t = session.getTransport("smtps");
 *
 * try {
 *     t.connect(host, user, password);
 *     t.sendMessage(msg, msg.getAllRecipients());
 * } finally {
 *     t.close();
 * }
 * }
 *
 * @author gkhays
 */
public class MailTest {

//    public enum SmtpTransport {
//        SMTP,
//        SMTPS
//    }
//
//    public static Properties getSmtpProperties(String host, String port,
//                                               boolean useSmtpAuth, boolean useSsl) {
//        Properties props = new Properties();
//        props.put("mail.smtp.port", port);
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.debug", "true");
//        if (useSmtpAuth) {
//            props.put("mail.smtp.auth", "true");
//        }
//        if (useSsl) {
//            props.put("mail.smtp.ssl.enable", "true");
//            props.put("mail.smtp.starttls.enable", "true");
//        }
//        return props;
//    }
//
//    public static Properties getTlsSmtpProperties(String host, String port,
//                                                  boolean useSmtpAuth, boolean useSsl) {
//        Properties tlsProps = new Properties();
//
//        // If you intend to use SSL/TLS, you will want to set the transport to
//        // "smtps" and use the mail.smtps.xxx properties.
//        tlsProps.put("mail.smtps.port", port);
//        tlsProps.put("mail.smtps.host", host);
//        tlsProps.put("mail.smtps.debug", "true");
//        if (useSmtpAuth) {
//            tlsProps.put("mail.smtps.auth", "true");
//        }
//        if (useSsl) {
//            tlsProps.put("mail.smtps.ssl.enable", "true");
//            tlsProps.put("mail.smtps.starttls.enable", "true");
//        }
//        return tlsProps;
//    }
//
//    public static Properties loadProperties() throws Exception {
//        Properties prop = new Properties();
//        prop.load(new FileInputStream("test/test.properties"));
//        return prop;
//    }
//
//    /**
//     * Send a message over the given session.
//     *
//     * @param	session	a session object that can be used to connect to an SMTP server
//     * @param	props	the properties contains SMTP information
//     * @param	msg		the MIME message contents
//     * @see		Session
//     * @see		Properties
//     * @see		MimeMessage
//     */
//    public static void send(Session session, Properties props, MimeMessage msg,
//                            SmtpTransport st, boolean useSmtpAuth) throws Exception {
//        String host = props.getProperty("smtp.host");
//        Transport transport;
//        if (st.equals(SmtpTransport.SMTPS)) {
//            transport = session.getTransport("smtps");
//            System.out.println("Using smtps transport");
//        } else {
//            transport = session.getTransport("smtp");
//            System.out.println("Using smtp transport");
//        }
//
//        final String user = props.getProperty("smtp.user");
//        final String password = props.getProperty("smtp.pass");
//        if (password == null) {
//            System.out.println("We didn't get a password!");
//        }
//
//        try {
//            if (useSmtpAuth) {
//                System.out.println("Connecting to " + host + " as " + user);
//                transport.connect(host, user, password);
//            } else {
//                transport.connect();
//            }
//            transport.sendMessage(msg, msg.getAllRecipients());
//            System.out.println("Message sent");
//        } finally {
//            transport.close();
//            System.out.println("Connection to " + host + " closed");
//        }
//    }
//
//    // Links:
//    // http://www.oracle.com/technetwork/java/javamail/faq/index.html#gmail
//    // http://www.oracle.com/technetwork/java/javamail/faq/index.html#commonmistakes
//    // http://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
//    // http://www.rgagnon.com/javadetails/java-0538.html
//    // https://blogs.oracle.com/apanicker/entry/java_code_for_smtp_server
//    // http://stackoverflow.com/questions/19115732/send-mail-in-javax-mail-without-authentication
//    // http://stackoverflow.com/questions/10409517/trouble-sending-via-gmails-smtp-server-with-java
//
//    // Additional settings.
//    //props.put("mail.smtp.userset", true); // use RSET instead of NOOP
//    //props.put("mail.smtp.connectiontimeout", 60000);
//    //props.put("mail.smtp.timeout", 60000);
//
//    // Typical SSL/TLS and non-SSL ports:
//    // Yahoo! Mail SMTP port: 465
//    // Yahoo! Mail SMTP TLS/SSL required: yes
//    // "mail.smtp.port", "587"
//
//    /**
//     * @param args
//     * @throws IOException
//     */
//    public  void main(String[] args) throws Exception {
//        Properties prop = loadProperties();
//
//        // If password is supplied, set useSmtpAuth to true.
//        boolean useSmtpAuth = true;
////        String pass = null;
////        if (args[0] != null) {
////            pass = args[0];
////            useSmtpAuth = true;
//            prop.setProperty("smtp.pass","Mauth.ioEmail");
////        }
//
//        String port = prop.getProperty("smtp.port", "25");
//        String host = prop.getProperty("smtp.host", "mx.zoho.com");
//
//        Properties smtpProps;
//        boolean useSsl = Boolean.parseBoolean(prop.getProperty("smtp.useSsl",
//                "false"));
//        if (useSsl) {
//            smtpProps = getTlsSmtpProperties(host, port, useSmtpAuth, useSsl);
//        } else {
//            smtpProps = getSmtpProperties(host, port, useSmtpAuth, useSsl);
//        }
//
//		/*
//		 * How you might get an authenticated session.
//		 * {@code
//		 * if (useSmtpAuth) {
//		 *     session = getAuthenticatedSession(prop, pass);
//		 * }
//		 * }
//		 */
//        Session session;
//        session = Session.getInstance(smtpProps);
//        session.setDebug(true);
//        debugSession(session);
//
//        String text = prop.getProperty("smtp.text", "Ping!");
//        MimeMessage msg = getMessage(text, session);
//        SmtpTransport st;
//        if (useSsl) {
//            st = SmtpTransport.SMTPS;
//        } else {
//            st = SmtpTransport.SMTP;
//        }
//        send(session, prop, msg, st, useSmtpAuth);
//    }
//
//    private static void debugSession(Session session) {
//        Properties sessionProps = session.getProperties();
//        sessionProps.list(System.out);
//    }
//
//    /**
//     * Using an authenticator is still supported, but is no longer necessary.
//     * Just use the overloaded Transport.connect() method instead.
//     *
//     * @see <a href="http://www.oracle.com/technetwork/java/javamail/faq/index.html#commonmistakes">JavaMail Common Mistakes</a>
//     */
//    @SuppressWarnings("unused")
//    @Deprecated
//    private static Session getAuthenticatedSession(Properties smtpProps,
//                                                   String pass) throws Exception {
//        Properties prop = loadProperties();
//        final String username = prop.getProperty("smtp.user");
//        final String password = pass;
//
//        System.out.println("Using session authenticator with user: " + username);
//        Authenticator auth = new Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        };
//        return Session.getInstance(smtpProps, auth);
//    }
//
//    /**
//     * Prepare a MIME message to send via SMTP.
//     *
//     * @param text
//     * @param fromEmail
//     * @param recipientList
//     * @param session
//     * @return
//     * @throws Exception
//     */
//    private static MimeMessage getMessage(String text, Session session)
//            throws Exception {
//        MimeMessage msg = new MimeMessage(session);
//
//        Properties prop = loadProperties();
//        String subject = prop.getProperty("smtp.subject", "Test subject");
//        String fromEmail = prop.getProperty("smtp.from");
//        String recipients = prop.getProperty("smtp.to");
//        List<String> recipientList;
//        recipientList = Arrays.asList(recipients.split(","));
//        for (String to : recipientList) {
//            msg.addRecipients(RecipientType.TO, to);
//        }
//
//        msg.setFrom(new InternetAddress(fromEmail, false));
//        msg.setSubject(subject, "UTF-8");
//
//        MimeMultipart mp = new MimeMultipart();
//        MimeBodyPart partText = new MimeBodyPart();
//        partText.setText(text);
//        mp.addBodyPart(partText);
//        msg.setContent(mp);
//        return msg;
//    }
}