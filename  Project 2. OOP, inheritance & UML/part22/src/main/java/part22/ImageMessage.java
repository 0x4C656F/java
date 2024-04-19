package part22;

public class ImageMessage extends BaseMessage {
    private String imageUrl;

    public ImageMessage(String author, String imageUrl) {
        super(author);
        this.imageUrl = imageUrl;
    }

    @Override
    public String render() {
        return author + " sent an image: " + imageUrl + "\n";
    }
    
}

