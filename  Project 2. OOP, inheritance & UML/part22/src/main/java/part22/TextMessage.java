package part22;

public class TextMessage extends BaseMessage {
    private String text;

    public TextMessage(String author, String text) {
        super(author);
        this.text = text;
    }

    @Override
    public String render() {
        return author + ": " + text + "\n";
    }
    

}
