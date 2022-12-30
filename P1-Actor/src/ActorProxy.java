import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ActorProxy implements ActorInterface, Runnable {
    private ActorInterface actor;
    private LinkedBlockingQueue<Message> queueMsg;

    /**
     * ActorProxy constructor
     *
     * @param a Type of actor
     */
    public ActorProxy(ActorInterface a) {
        actor = a;
        queueMsg = new LinkedBlockingQueue<>();
    }

    /**
     * Goes to the send method from the Actor inside the proxy
     *
     * @param message
     */
    @Override
    public void send(MessageInterface message) {

        actor.send(message);
    }

    public RingActor getRingActor(){
        return (RingActor) this.actor;
    }

    /**
     * @return queueMsg from actor inside the proxy
     */
    @Override
    public LinkedBlockingQueue<MessageInterface> getQueueMsg() {
       return actor.getQueueMsg();
    }

    @Override
    public void process(MessageInterface message) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void run() {

    }
}
