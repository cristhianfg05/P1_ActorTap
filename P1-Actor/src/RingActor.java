import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class RingActor implements ActorInterface, Runnable{

    /**TODOS LOS ACTORES TIENEN SU COLA**/
    private LinkedBlockingQueue<MessageInterface> queueMsg;
    private RingActor nextActor;

    public RingActor (){
        queueMsg = new LinkedBlockingQueue<>();
        nextActor = null;
    }

    public void linkActor(RingActor actor){
        nextActor = actor;
    }

    @Override
    public void send(MessageInterface message) {
        ActorInterface aux = message.getReciever();
        aux.getQueueMsg().add((Message) message);
        message.setSender(this);
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println(this.queueMsg.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Queue<MessageInterface> getQueueMsg() {
        return queueMsg;
    }

    @Override
    public void recieve() {

    }

}
