import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

// Implements the same interface as the object to be decorated
// It has an instance of the object to be decorated so we delegate
// every task in its functions
public class ActorDecorator implements ActorInterface{
    ActorInterface actor;
    public ActorDecorator(ActorInterface actor){
        this.actor = actor;
    }
    @Override
    public void send(MessageInterface message) {
        actor.send(message);
    }

    @Override
    public LinkedBlockingQueue<MessageInterface> getQueueMsg() {
        return actor.getQueueMsg();
    }

    public void process(MessageInterface message) throws InterruptedException {
        System.out.println("Process del actordecorator");
        actor.process(message);
    }

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
