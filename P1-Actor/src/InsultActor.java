import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class InsultActor implements  ActorInterface, Runnable, InsultService{

    private LinkedBlockingQueue<MessageInterface> queueInsultMsg;
    private ArrayList<MessageInterface> InsultList;

    public InsultActor(){
        queueInsultMsg = new LinkedBlockingQueue<>();
        InsultList = new ArrayList<>();
    }
    @Override
    public void send(MessageInterface message) {
        message.setSender(message.getSender());
        message.setReciever(this);
        this.getQueueMsg().add(message);
    }

    @Override
    public LinkedBlockingQueue<MessageInterface> getQueueMsg() {
        return this.queueInsultMsg;
    }

    public ArrayList getInsultList(){
        return this.InsultList;
    }
    @Override
    public void process(MessageInterface message) throws InterruptedException {
        if(message instanceof Message){
            System.out.println(this.queueInsultMsg.take());
        }else if(message instanceof GetInsultMessage){
            int rnd = new Random().nextInt(InsultList.size());
            message.getSender().send(new Message(null, InsultList.get(rnd).getMsg()));
        }else if(message instanceof AddInsultMessage){
            InsultList.add(this.queueInsultMsg.take());
        }else{
            for (MessageInterface m : InsultList) {
                send(m);
            }
        }
    }

    @Override
    public void run() {
        while(true){

                /**PREGUNTAR A PEDRO POR EL SWITCH**/
            MessageInterface aux = null;
            try {
                aux = queueInsultMsg.take();
                process(aux);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public void addInsult(MessageInterface insult) {
        InsultList.add(insult);
    }

    @Override
    public MessageInterface getInsult() {
        int index = new Random().nextInt(InsultList.size());
        return InsultList.get(index);
    }

    @Override
    public List getAllInsults() {
        return InsultList;
    }
}
