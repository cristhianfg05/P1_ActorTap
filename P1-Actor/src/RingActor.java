import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class RingActor implements ActorInterface, Runnable{

    /**TODOS LOS ACTORES TIENEN SU COLA**/
    private LinkedBlockingQueue<MessageInterface> queueMsg;
    private RingActor nextActor;
    private int num_vueltas;

    public RingActor (){
        queueMsg = new LinkedBlockingQueue<>();
        nextActor = null;
        this.num_vueltas = 0;
    }
    public void linkActor(RingActor actor){
        nextActor = actor;
    }

    @Override
    public void send(MessageInterface message) {

        message.setSender(message.getSender());
        message.setReciever(this);
        this.queueMsg.add(message);
        num_vueltas++;
        if(this.nextActor != null && this.nextActor.num_vueltas < 100){
            this.nextActor.send(message);
        }
    }

    @Override
    public void process(MessageInterface message) {
        //System.out.println("Process Ring");
        System.out.println(message);
    }

    @Override
    public void run() {
        while(true){
            try {
                MessageInterface aux = this.queueMsg.take();
                if(aux instanceof Message)
                    process(aux);
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
