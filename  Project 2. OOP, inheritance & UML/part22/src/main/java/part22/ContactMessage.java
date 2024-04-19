package part22;

public class ContactMessage extends BaseMessage {
    private String contactName;
    private String phoneNumber;

    public ContactMessage(String author, String contactName, String phoneNumber) {
        super(author);
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String render() {
        return author + " shared a contact: " + contactName + ", Phone: " + phoneNumber + "\n";
    }
    
}
