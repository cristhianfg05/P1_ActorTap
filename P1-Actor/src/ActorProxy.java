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
    public void send(Message message) {
        /**DESDE AQUI SE LLAMA AL SEND DE CADA ACTOR*/
        queueMsg.add(message);
        actor.send(message);
        recieve(message);
    }

    private void recieve(Message m) {
        m.getReciever().send(new Message(this, m.getMsg()));
    }

    @Override
    public Queue<Message> getQueueMsg() {
       return actor.getQueueMsg();
    }

    @Override
    public void run() {

    }
}
