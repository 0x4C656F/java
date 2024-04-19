package part22;

import java.time.LocalDateTime;

public abstract class BaseMessage {
    protected LocalDateTime date;
    protected String author;

    public BaseMessage(String author) {
        this.date = LocalDateTime.now();
        this.author = author;
    }

    public abstract String render();
}
