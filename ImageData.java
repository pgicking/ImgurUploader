/**
 * Created with IntelliJ IDEA.
 * User: peterg
 * Date: 10/10/13
 * Time: 7:36 PM
 *
 * Class to hold the json values for an image json response
 */

/*This will hold the json response to be used for other means like displaying in a readable format */

/**
 * Not sure what I was doing here, maybe my past self thought I would
 * be handle an image as an object, im gonna just keep it for now.
 */
public class ImageData {

        private String id;
        private String title;
        private String description;
        private int datetime;
        private String type;
        private boolean animated;
        private int width;
        private int height;
        private int size;
        private int views;
        private int bandwidth;
        private String deletehash;
        private String section;
        private String link;



    public void ImageDataInit(String id, String title, String description, int datetime, String type, boolean animated,
                            int width, int height, int size, int views, int bandwidth, String deletehash, String section,
                            String link) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.datetime = datetime;
            this.type = type;
            this.animated = animated;
            this.width = width;
            this.height = height;
            this.size = size;
            this.views = views;
            this.bandwidth = bandwidth;
            this.deletehash = deletehash;
            this.section = section;
            this.link = link;
        }

    @Override
    public String toString() {
        return "ImageData {" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", datetime=" + datetime +
                ", type='" + type + '\'' +
                ", animated=" + animated +
                ", width=" + width +
                ", height=" + height +
                ", size=" + size +
                ", views=" + views +
                ", bandwidth=" + bandwidth +
                ", deletehash='" + deletehash + '\'' +
                ", section='" + section + '\'' +
                ", link='" + link + '\'' +
                '}';
    }


/*    public static List<ImageData> getData(String jsonString){
        Gson gson = new Gson();

        Type type = new TypeToken<List<ImageData>>(){}.getType();
        List<ImageData> details = gson.fromJson(jsonString,type);
        return details;
    }    */

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDatetime() {
        return datetime;
    }

    public void setDatetime(int datetime) {
        this.datetime = datetime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAnimated() {
        return animated;
    }

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(int bandwidth) {
        this.bandwidth = bandwidth;
    }

    public String getDeletehash() {
        return deletehash;
    }

    public void setDeletehash(String deletehash) {
        this.deletehash = deletehash;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

