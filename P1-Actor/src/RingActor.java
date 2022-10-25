import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class RingActor implements ActorInterface, Runnable{

    /**TODOS LOS ACTORES TIENEN SU COLA**/
    private LinkedBlockingQueue<Message> queueMsg;
    private RingActor nextActor;

    public RingActor (){
        queueMsg = new LinkedBlockingQueue<>();
        nextActor = null;
    }

    public void linkActor(RingActor actor){
        nextActor = actor;
    }

    @Override
    public void send(Message message) {
        ActorInterface aux = message.getReciever();
        aux.getQueueMsg().add(message);
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

    public Queue<Message> getQueueMsg() {
        return queueMsg;
    }

}
