import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class InsultService implements ActorInterface {
    InsultActor actor;
    public InsultService(){
        actor = null;
    }
    public String getInsult(){
        int x = new Random().nextInt(actor.getInsultList().size())
        return actor.getInsultList().get(x).toString();
    }
    public List getAllInsults(){
        return null;
    }
    public void addInsult(MessageInterface insult){

    }

    @Override
    public void send(MessageInterface message) {

    }

    @Override
    public LinkedBlockingQueue<MessageInterface> getQueueMsg() {
        return null;
    }

    @Override
    public void process(MessageInterface message) throws InterruptedException {

    }

    @Override
    public void run() {

    }
}
