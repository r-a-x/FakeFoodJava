package io.mauth.fakefood.util;

/**
 * Created by rahulb on 3/12/17.
 */
public class ReadMailTest {

//    public static void main(String args[]) throws IOException, MessagingException {
//        Properties properties = new Properties();
//        properties.load(new FileInputStream(new File(System.getProperty("user.dir")+"/"+ "src/main/resources/readmail.properties")));
//        Session session = Session.getDefaultInstance(properties,null);
//        Store store = session.getStore("imaps");
//        store.connect("imap.zoho.com","admin@mauth.io","Mauth.ioEmail");
//        Folder inbox = store.getFolder("inbox");
//        inbox.open(Folder.READ_WRITE);
//        int messageCount = inbox.getMessageCount();
//        Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN),false));
//        getTextFromMessage(messages[0]);
//
//    }
//    private static String getTextFromMessage(Message message) throws MessagingException, IOException {
//        String result = "";
//        if (message.isMimeType("text/plain")) {
//            result = message.getContent().toString();
//        } else if (message.isMimeType("multipart/*")) {
//            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
//            result = getTextFromMimeMultipart(mimeMultipart);
//        }
//        return result;
//    }
//    private static String getTextFromMimeMultipart(
//            MimeMultipart mimeMultipart)  throws MessagingException, IOException{
//        String result = "";
//        int count = mimeMultipart.getCount();
//        for (int i = 0; i < count; i++) {
//            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
//            if (bodyPart.isMimeType("text/plain")) {
//                result = result + "\n" + bodyPart.getContent();
//                break; // without break same text appears twice in my tests
//            } else if (bodyPart.isMimeType("text/html")) {
//                String html = (String) bodyPart.getContent();
//                result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
//            } else if (bodyPart.getContent() instanceof MimeMultipart){
//                result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
//            }
//        }
//        return result;
//    }
}
