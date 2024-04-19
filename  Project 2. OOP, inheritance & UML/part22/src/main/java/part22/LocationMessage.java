package part22;

public class LocationMessage extends BaseMessage {
    private String locationUrl;

    public LocationMessage(String author, String locationUrl) {
        super(author);
        this.locationUrl = locationUrl;
    }

    @Override
    public String render() {
        return author + " shared a location: " + locationUrl + "\n";
    }
    
}
