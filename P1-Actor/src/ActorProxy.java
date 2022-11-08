import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ActorProxy implements ActorInterface, Runnable {

    private ActorInterface actor;
    private LinkedBlockingQueue<Message> queueMsg;

    public ActorProxy(ActorInterface a) {
        actor = a;
        queueMsg = new LinkedBlockingQueue<>();
    }

    @Override
    public void send(MessageInterface message) {
        /**DESDE AQUI SE LLAMA AL SEND DE CADA ACTOR*/
        queueMsg.add((Message) message);
        actor.send(message);


    }

    private void recieve(Message m) {

    }

    @Override
    public Queue<MessageInterface> getQueueMsg() {
       return actor.getQueueMsg();
    }

    @Override
    public void recieve() {

    }

    @Override
    public void run() {

    }
}
