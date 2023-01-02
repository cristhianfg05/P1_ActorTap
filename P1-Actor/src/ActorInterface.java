import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public interface ActorInterface extends Runnable {

    public void send(MessageInterface message);
    public LinkedBlockingQueue<MessageInterface> getQueueMsg();

    public void process(MessageInterface message) throws InterruptedException;

    public String getName();

    public int getMsg();
}
