package io.mauth.fakefood.util;

/**
 * Created by rahulb on 19/11/17.
 */

// Reading the file and converting to the image

public class JpegToString {

//    public static byte[] extractBytes2(String ImageName) throws IOException {
//
//        File imgPath = new File(ImageName);
//        BufferedImage bufferedImage = ImageIO.read(imgPath);
//
//        ByteOutputStream bos = null;
//        try {
//            bos = new ByteOutputStream();
//            ImageIO.write(bufferedImage, "jpg", bos);
//        } finally {
//            try {
//                bos.close();
//            } catch (Exception e) {
//            }
//        }
//
//        return bos == null ? null : bos.getBytes();
//
//    }
//
//    public static String byteToBase64(byte [] bytes){
//
//        byte base64[] = Base64.getEncoder().encode(bytes);
//        return new String( base64);
//    }
//
//    public static void main(String args[]){
//        String name = "/home/rahulb/FakeFood/src/main/resources/images/back.jpg";
////        try {
//////            System.out.print(   byteToBase64(  extractBytes2( name) ) );
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//
//
//        toGson(new DateDto(new Date()),DateDto.class);
//    }
//
//    public static String toGson(Object ob, Class cl){
//        Gson gson = new Gson();
//        return gson.toJson(ob,cl);
//    }
//
//  static class DateDto implements Serializable{
//        private Date today;
//
//        public DateDto(Date today) {
//            this.today = today;
//        }
//
//        public DateDto() {
//        }
//
//        public Date getToday() {
//            return today;
//        }
//
//        public void setToday(Date today) {
//            this.today = today;
//        }
//    }

}
