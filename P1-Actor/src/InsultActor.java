import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class InsultActor implements  ActorInterface, Runnable{

    private LinkedBlockingQueue<MessageInterface> queueInsultMsg;
    private ArrayList<MessageInterface> InsultList;
    @Override
    public void send(MessageInterface message) {
        ActorInterface aux = message.getReciever();
        aux.getQueueMsg().add((Message) message);
        message.setSender(this);
    }

    @Override
    public Queue<MessageInterface> getQueueMsg() {
        return this.queueInsultMsg;
    }

    @Override
    public void recieve() {

    }


    @Override
    public void run() {
        while(true){
            try {
                if(this.queueInsultMsg.peek() instanceof Message){
                    System.out.println(this.queueInsultMsg.take());
                }else if(this.queueInsultMsg.peek() instanceof GetInsultMessage){
                    int rnd = new Random().nextInt(InsultList.size());
                    /**AUN POR DECIDIR QUE HAY QUE HACER**/
                }else if(this.queueInsultMsg.peek() instanceof AddInsultMessage){
                    InsultList.add(this.queueInsultMsg.take());
                }else{
                    /**GetAllinsults**/
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
