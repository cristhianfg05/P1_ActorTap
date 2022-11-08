import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class InsultActor implements  ActorInterface, Runnable{

    private LinkedBlockingQueue<MessageInterface> queueInsultMsg;
    @Override
    public void send(MessageInterface message) {
        ActorInterface aux = message.getReciever();
        aux.getQueueMsg().add((Message) message);
        message.setSender(this);
    }

    @Override
    public Queue<MessageInterface> getQueueMsg() {
        return this.queueInsultMsg;
    }

    @Override
    public void recieve() {
        
    }


    @Override
    public void run() {

    }
}
