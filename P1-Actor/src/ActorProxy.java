import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ActorProxy implements ActorInterface, Runnable {
    /**EL ACTOR PROXY HACE DE CAMINO HACIA LOS OTROS ACTORES**/
    /**IMPIDIENDO QUE EL USUARIO TRABAJE CON LOS ACTORES DE MANERA DIRECTA**/
    private ActorInterface actor;
    private LinkedBlockingQueue<Message> queueMsg;

    public ActorProxy(ActorInterface a) {
        actor = a;
        queueMsg = new LinkedBlockingQueue<>();
    }

    @Override
    public void send(MessageInterface message) {
        /**DESDE AQUI SE LLAMA AL SEND DE CADA ACTOR**/
        actor.send(message);
    }


    @Override
    public Queue<MessageInterface> getQueueMsg() {
       return actor.getQueueMsg();
    }

    @Override
    public void run() {

    }
}
