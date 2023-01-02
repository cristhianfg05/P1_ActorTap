package Model;

import java.util.List;


public interface InsultService {

    public void addInsult(MessageInterface insult);

    public MessageInterface getInsult();

    public List getAllInsults();
}

