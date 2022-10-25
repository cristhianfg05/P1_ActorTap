import java.util.Queue;

public class ActorProxy implements ActorInterface, Runnable {

    private ActorInterface actor;

    public ActorProxy(ActorInterface a) {
        actor = a;
    }

    @Override
    public void send(Message message) {
        /**DESDE AQUI SE LLAMA AL SEND DE CADA ACTOR*/
        actor.send(message);
    }

    @Override
    public Queue<Message> getQueueMsg() {
       return actor.getQueueMsg();
    }

    @Override
    public void run() {

    }
}
