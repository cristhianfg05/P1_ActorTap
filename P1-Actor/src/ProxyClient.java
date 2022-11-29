import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProxyClient implements ActorInterface, Runnable{
    /**EL PROXY CLIENT SERA EJECUTADO DESDE EL MAIN Y USARA EL HIlO DE EL MISMO**/
    private LinkedBlockingQueue<MessageInterface> queueMsg;
    private ActorInterface actor;


    public ProxyClient(ActorInterface actor){
        queueMsg = new LinkedBlockingQueue<>();
        this.actor = actor;
    }

    public void send(MessageInterface message){
        ActorInterface aux = message.getReciever();
        message.setSender(this);
        message.setReciever(aux);
        //aux.getQueueMsg().add(message);

        actor.send(message);
    }

    @Override
    public LinkedBlockingQueue<MessageInterface> getQueueMsg() {
        return queueMsg;
    }

    public MessageInterface recieve() throws InterruptedException {
        return queueMsg.take();
    }


    public void process(MessageInterface message){

    }
    @Override
    public void run() {

    }
}
