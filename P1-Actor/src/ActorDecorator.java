import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


public class ActorDecorator implements ActorInterface{
    ActorInterface actor;

    /**
     * ActorDecorator Constructor
     *
     * @param actor
     */
    public ActorDecorator(ActorInterface actor){
        this.actor = actor;
    }

    /**
     * Go to send from the actor inside the object
     *
     * @param message
     */
    @Override
    public void send(MessageInterface message) {
        actor.send(message);
    }

    /**
     * @return Message queue from the actor inside the Object
     */
    @Override
    public LinkedBlockingQueue<MessageInterface> getQueueMsg() {
        return actor.getQueueMsg();
    }

    /**
     * @param message
     * @throws InterruptedException if fails
     * goes to the actor process
     */
    public void process(MessageInterface message) throws InterruptedException {
        System.out.println("Process del actordecorator");
        actor.process(message);
    }


    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getMsg() {
        return 0;
    }

    /**
     * Thread method, process every msg from the queue
     */
    @Override
    public void run() {
        while(true){
            try {
                process(actor.getQueueMsg().take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
