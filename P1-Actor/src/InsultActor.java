import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class InsultActor implements  ActorInterface, Runnable{

    private LinkedBlockingQueue<MessageInterface> queueInsultMsg;
    private ArrayList<MessageInterface> InsultList;

    public InsultActor(){
        queueInsultMsg = new LinkedBlockingQueue<>();
        InsultList = new ArrayList<>();
    }
    @Override
    public void send(MessageInterface message) {
        ActorInterface aux = message.getReciever();
        message.setSender(this);
        message.setReciever(aux);
        aux.getQueueMsg().add(message);
    }

    @Override
    public LinkedBlockingQueue<MessageInterface> getQueueMsg() {
        return this.queueInsultMsg;
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
}
