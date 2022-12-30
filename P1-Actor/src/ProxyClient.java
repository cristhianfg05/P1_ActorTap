import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProxyClient implements ActorInterface, Runnable{
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
        message.setReciever(this);
        //aux.getQueueMsg().add(message);
        if(message instanceof Message){
            System.out.println("He llegado");
            queueMsg.add(message);
        }else actor.send(message);
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
