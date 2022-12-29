import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InsultServiceImp implements InsultService{
    private List<MessageInterface> insults;
    private Random random;

    public InsultServiceImp(){
        insults = new ArrayList<>();
        random = new Random();
    }

    @Override
    public void addInsult(MessageInterface insult) {
        insults.add(insult);
    }

    @Override
    public MessageInterface getInsult() {
        int index = random.nextInt(insults.size());
        return insults.get(index);
    }

    @Override
    public List getAllInsults() {
        return insults;
    }
}
