import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class RingActor implements ActorInterface, Runnable{

    /**TODOS LOS ACTORES TIENEN SU COLA**/
    private LinkedBlockingQueue<MessageInterface> queueMsg;
    private RingActor nextActor;
    private int num_vueltas;

    private String name;

    /**
     * RingActor constructor
     *
     * @param name
     */
    public RingActor (String name){
        this.name = name;
        queueMsg = new LinkedBlockingQueue<>();
        nextActor = null;
        this.num_vueltas = 0;
    }

    /**
     * Links actor to next RingActor
     *
     * @param actor
     */
    public void linkActor(RingActor actor){
        nextActor = actor;
    }

    /**
     * Sets message to his own queue and send message to the next ringActor
     *
     * @param message
     */
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

    /**
     * process message printing
     *
     * @param message
     */
    @Override
    public void process(MessageInterface message) {
        //System.out.println("Process Ring");
        System.out.println(message);
    }

    /**
     * @return name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Thread from each RingActor
     */
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

    /**
     * @return queueMsg
     */
    public LinkedBlockingQueue<MessageInterface> getQueueMsg() {
        return queueMsg;
    }

    @Override
    public String toString() {
        if(name == null)
            return "Main";
        else
        return "RingActor{" +
                "name='" + name + '\'' +
                '}';
    }
}
