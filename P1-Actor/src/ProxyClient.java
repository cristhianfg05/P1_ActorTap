import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProxyClient implements ActorInterface, Runnable{
    /**EL PROXY CLIENT SERA EJECUTADO DESDE EL MAIN Y USARA EL HIlO DE EL MISMO**/
    private LinkedBlockingQueue<MessageInterface> queueMsg;
    private ActorInterface actor;


    /**
     * ProxyClient constructor
     *
     * @param actor
     */
    public ProxyClient(ActorInterface actor){
        queueMsg = new LinkedBlockingQueue<>();
        this.actor = actor;
    }

    /**
     * Send the message to the actor inside the proxy
     *
     * @param message
     */
    public void send(MessageInterface message){
        ActorInterface aux = message.getReciever();
        message.setSender(this);
        message.setReciever(aux);
        //aux.getQueueMsg().add(message);

        actor.send(message);
    }

    /**
     * @return queueMsg
     */
    @Override
    public LinkedBlockingQueue<MessageInterface> getQueueMsg() {
        return queueMsg;
    }

    /**
     * @return last Message from queue
     * @throws InterruptedException
     */
    public MessageInterface recieve() throws InterruptedException {
        return queueMsg.take();
    }


    public void process(MessageInterface message){

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void run() {

    }
}
