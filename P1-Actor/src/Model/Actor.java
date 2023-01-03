package Model;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Actor implements ActorInterface{

    private LinkedBlockingQueue<MessageInterface> queueMsg;
    private String name;
    private int numMsg;
    private ArrayList<Observer> subList;

    public Actor(String name){
        queueMsg = new LinkedBlockingQueue<>();
        this.name = name;
        this.numMsg = 0;
        subList = new ArrayList<>();
        notifySub(Actions.CREATE);
    }
    @Override
    public void send(MessageInterface message) {
        this.queueMsg.add(message);
        notifySub(Actions.SEND);
    }

    @Override
    public LinkedBlockingQueue<MessageInterface> getQueueMsg() {
        return queueMsg;
    }

    @Override
    public void process(MessageInterface message) throws InterruptedException {
        System.out.println(message);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMsg() {
        return this.numMsg;
    }

    @Override
    public void run() {
        while (true) {
            try {
                MessageInterface aux = this.queueMsg.take();
                if (aux instanceof Message) {
                    this.numMsg++;
                    process(aux);
                }else{
                    notifySub(Actions.DIE);
                    break;
                }
            } catch (InterruptedException e) {
                notifySub(Actions.ERROR);
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return "Actor{" +
                ", name='" + name + '\'' +
                ", numMsg=" + numMsg +
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
