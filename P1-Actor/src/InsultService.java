import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public interface InsultService {

    public void addInsult(MessageInterface insult);

    public MessageInterface getInsult();

    public List getAllInsults();
}

