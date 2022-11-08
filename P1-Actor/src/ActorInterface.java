import java.util.Queue;

public interface ActorInterface extends Runnable {
    public void send(MessageInterface message);
    public Queue<MessageInterface> getQueueMsg();

    public void recieve();
}
