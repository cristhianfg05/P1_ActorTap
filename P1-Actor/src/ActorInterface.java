import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public interface ActorInterface extends Runnable {
    public void send(MessageInterface message);
    public LinkedBlockingQueue<MessageInterface> getQueueMsg();

}
