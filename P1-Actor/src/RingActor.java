import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class RingActor implements ActorInterface, Runnable {


    private LinkedBlockingQueue<MessageInterface> queueMsg;
    private RingActor nextActor;
    private int num_vueltas;
    private int numMsg;

    private String name;

    /**
     * RingActor constructor
     *
     * @param name
     */

    public RingActor(String name) {
        this.name = name;
        queueMsg = new LinkedBlockingQueue<>();
        nextActor = null;
        this.num_vueltas = 0;
        numMsg = 0;
    }

    /**
     * Links actor to next RingActor
     *
     * @param actor
     */
    public void linkActor(RingActor actor) {
        nextActor = actor;
    }

    /**
     * Sets message to his own queue and send message to the next ringActor
     *
     * @param message
     */
    @Override
    public void send(MessageInterface message) {

        if (message instanceof Message) {
            this.queueMsg.add(message);
            System.out.println("Mensaje recibido de "+message.getSender());
            message.setSender(this);
            num_vueltas++;
            numMsg++;
            if (this.nextActor != null && this.nextActor.num_vueltas < 1) {
                this.nextActor.send(message);
            } else this.nextActor.send(new QuitMessage());
        } else {
            this.queueMsg.add(message);
            System.out.println("He roto la cadena");
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

    @Override
    public int getMsg() {
        return numMsg;
    }

    /**
     * Thread from each RingActor
     */
    @Override
    public void run() {
        while (true) {
            try {
                MessageInterface aux = this.queueMsg.take();
                if (aux instanceof Message)
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
        if (name == null)
            return "Main";
        else
            return "RingActor{" +
                    "name='" + name + '\'' +
                    '}';
    }
}
