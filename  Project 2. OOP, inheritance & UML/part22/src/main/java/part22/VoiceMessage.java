package part22;

public class VoiceMessage extends BaseMessage {
    private String audioUrl;

    public VoiceMessage(String author, String audioUrl) {
        super(author);
        this.audioUrl = audioUrl;
    }

    @Override
    public String render() {
        return author + " sent a voice message: " + audioUrl + "\n";
    }
    
}
