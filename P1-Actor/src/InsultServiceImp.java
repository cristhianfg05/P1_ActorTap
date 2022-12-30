import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InsultServiceImp implements InsultService{
    private List<MessageInterface> insults;
    private Random random;

    /**
     * InsultServiceImp constructor
     */
    public InsultServiceImp(){
        insults = new ArrayList<>();
        random = new Random();
    }

    /**
     * Add insult to the list
     *
     * @param insult
     */
    @Override
    public void addInsult(MessageInterface insult) {
        insults.add(insult);
    }

    /**
     * @return random insult
     */
    @Override
    public MessageInterface getInsult() {
        int index = random.nextInt(insults.size());
        return insults.get(index);
    }

    /**
     * @return all insultList
     */
    @Override
    public List getAllInsults() {
        return insults;
    }
}
