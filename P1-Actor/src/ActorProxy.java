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
        if( ! (message.getReciever()  instanceof  ActorProxy)){
            recieve(message);
        }

    }

    private void recieve(Message m) {
        m.getReciever().send(new Message(this, m.getMsg()));
        System.out.println("ESTO ES EL PROXY" + queueMsg);
    }

    @Override
    public Queue<Message> getQueueMsg() {
       return actor.getQueueMsg();
    }

    @Override
    public void run() {

    }
}
