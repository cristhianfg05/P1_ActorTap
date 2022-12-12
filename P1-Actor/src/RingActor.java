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
        if(this.nextActor != null){
            message.setSender(this);
            message.setReciever(this.nextActor);
            this.nextActor.getQueueMsg().add(message);
            this.nextActor.send(message);
        }else
            System.out.println("NO HAY MAS ACTORES ENCADENADOS");

    }

    @Override
    public void process(MessageInterface message) {
       System.out.println(message);
    }

    @Override
    public void run() {
        while(true){
            try {
                MessageInterface msg = this.queueMsg.take();
                if(!(msg instanceof QuitMessage))
                    process(this.queueMsg.take());
                else break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public LinkedBlockingQueue<MessageInterface> getQueueMsg() {
        return queueMsg;
    }


}
