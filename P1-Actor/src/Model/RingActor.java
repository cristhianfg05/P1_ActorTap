package Model;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class RingActor implements ActorInterface, Runnable, Publisher {


    private LinkedBlockingQueue<MessageInterface> queueMsg;
    private RingActor nextActor;
    private int num_vueltas;
    private int numMsg;

    private String name;
    private ArrayList<Observer> subList;

    /**
     * Model.RingActor constructor
     *
     * @param name
     */

    public RingActor(String name) {
        this.name = name;
        queueMsg = new LinkedBlockingQueue<>();
        nextActor = null;
        this.num_vueltas = 0;
        numMsg = 0;
        subList = new ArrayList<>();
        notifySub(Actions.CREATE);
    }

    /**
     * Links actor to next Model.RingActor
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
            notifySub(Actions.SEND);
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
     * Thread from each Model.RingActor
     */
    @Override
    public void run() {
        while (true) {
            try {
                MessageInterface aux = this.queueMsg.take();
                if (aux instanceof Message) {
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

    /**
     * @return queueMsg
     */
    public LinkedBlockingQueue<MessageInterface> getQueueMsg() {
        return queueMsg;
    }

    @Override
    public String toString() {
        return "RingActor{" +
                ", num_vueltas=" + num_vueltas +
                ", numMsg=" + numMsg +
                ", name='" + name + '\'' +
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
