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

    public RingActor (RingActor next){
        queueMsg = new LinkedBlockingQueue<>();
        nextActor = next;
    }

    public void linkActor(RingActor actor){
        nextActor = actor;
    }

    @Override
    public void send(MessageInterface message) {
        /**FALTA CORREGIR QUE CADA RING SOLO ENVIE MENSAJE AL SIGUIENTE RING ACTOR**/
        ActorInterface aux = message.getReciever();
        message.setSender(this);
        message.setReciever(aux);
        aux.getQueueMsg().add(message);
    }

    @Override
    public void process(MessageInterface message) {
        System.out.println("Process Ring");
        System.out.println(message);
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("LLego el ring run");
                process(this.queueMsg.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public LinkedBlockingQueue<MessageInterface> getQueueMsg() {
        return queueMsg;
    }


}
