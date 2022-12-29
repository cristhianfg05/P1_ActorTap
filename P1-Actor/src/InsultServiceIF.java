import java.util.List;

public interface InsultServiceIF {

    public void addInsult(MessageInterface insult);

    public MessageInterface getInsult();

    public List getAllInsults();
}
