import java.util.Queue;

public interface ActorInterface extends Runnable {
    public void send(Message message);
    public Queue<Message> getQueueMsg();
}
