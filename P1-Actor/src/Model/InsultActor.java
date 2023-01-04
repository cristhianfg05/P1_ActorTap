package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class InsultActor implements  ActorInterface, Runnable, InsultService{

    private LinkedBlockingQueue<MessageInterface> queueInsultMsg;
    private ArrayList<MessageInterface> InsultList;

    private int numMsg;

    private String name;
    private ArrayList<Observer> subList;

    /**
     * Model.InsultActor constructor
     *
     * @param name
     */
    public InsultActor(String name){
        this.name = name;
        queueInsultMsg = new LinkedBlockingQueue<>();
        InsultList = new ArrayList<>();
        numMsg = 0;
        subList = new ArrayList<>();
        notifySub(Actions.CREATE);
    }

    /**
     * The actor recieves a message from another actor and he get it inside his own queue
     *
     * @param message
     */
    @Override
    public void send(MessageInterface message){
        getQueueMsg().add(message);
        if(message instanceof Message){
            notifySub(Actions.SEND);
            numMsg++;
        }
    }

    /**
     * @return queueMsg
     */
    @Override
    public LinkedBlockingQueue<MessageInterface> getQueueMsg() {
        return this.queueInsultMsg;
    }

    /**
     * @return InsultList
     */
    public ArrayList getInsultList(){
        return this.InsultList;
    }

    /**
     * Process the message, if it's a normal one just print, else check if it's getInsult, addInsult or getAllInsults
     * then act adding or sending the message
     *
     * @param message
     * @throws InterruptedException
     */
    @Override
    public void process(MessageInterface message) throws InterruptedException {
        if(message instanceof Message){
            System.out.println(message);
        }else if(message instanceof GetInsultMessage){
            int rnd = new Random().nextInt(InsultList.size());
            System.out.println("HE LLEGADO, EL RANDOM ES "+rnd);
            message.getReciever().send(new Message(null, InsultList.get(rnd).getMsg()));
        }else if(message instanceof AddInsultMessage){
            InsultList.add(message);
        }else{
            ActorInterface rec = message.getReciever();
            for (MessageInterface m : InsultList) {
                rec.send(new Message(null, m.getMsg()));
            }
        }
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
     * Thread from Model.InsultActor
     */
    @Override
    public void run() {
        while(true){
            MessageInterface aux = null;
            try {
                aux = queueInsultMsg.take();
                if(!(aux instanceof QuitMessage))
                    process(aux);
                else{
                    notifySub(Actions.DIE);
                    break;
                }
            } catch (InterruptedException e) {
                notifySub(Actions.ERROR);
                throw new RuntimeException(e);
            }

        }
    }

    /**
     * AddInsult to the insult list
     *
     * @param insult
     */
    @Override
    public void addInsult(MessageInterface insult) {
        InsultList.add(insult);
    }

    /**
     * @return random insult
     */
    @Override
    public MessageInterface getInsult() {
        int index = new Random().nextInt(InsultList.size());
        return InsultList.get(index);
    }

    /**
     * @return all insults
     */
    @Override
    public List getAllInsults() {
        return InsultList;
    }

    @Override
    public String toString() {
        if(name == null)
            return "Model.Main";
        else
            return "Model.InsultActor{" +
                "name='" + name + '\'' +
                '}';
    }

    /**
     * Add the observer to the subs list
     * @param o Observer
     */
    @Override
    public void subscrib(Observer o) {
        if(!subList.contains(o)){
            subList.add(o);
            notifySub(Actions.CREATE);
            System.out.println("Se ha suscrito exitosamente");
        }
    }
    /**
     * Remove the observer from the subs list
     * @param o Observer
     */
    @Override
    public void unsub(Observer o) {
        if(subList.contains(o)){
            subList.remove(o);
            System.out.println("Se ha dessuscrito exitosamente");
        }
    }


    /**
     * Notify each Observer
     * @param a Action done
     */
    @Override
    public void notifySub(Actions a) {
        for(Observer o : subList){
            o.update(name,a);
        }
    }
}

