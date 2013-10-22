public class ImageDetails {

    String Success;
    int status;
    ImageData ImageData = new ImageData();

    public void DisplayJSON(){

        String ImageDetail = ImageData.toString();

        System.out.println("\nFrom Image Details\n" + ImageDetail + "\n");

    }

}
