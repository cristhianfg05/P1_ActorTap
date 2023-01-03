package Model;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class PingPongActor implements ActorInterface, Runnable, Publisher {
    private LinkedBlockingQueue<MessageInterface> queueMsg;
    private int num_vueltas;
    private String name;

    private PingPongActor pareja;
    private int numMsg;
    private ArrayList<Observer> subList;

    public PingPongActor(String name) {
        this.name = name;
        queueMsg = new LinkedBlockingQueue<>();
        this.num_vueltas = 0;
        numMsg = 0;
        subList = new ArrayList<>();
        notifySub(Actions.CREATE);
    }

    public void setPareja(PingPongActor p) {
        pareja = p;
    }

    @Override
    public void send(MessageInterface message) {

        if (message instanceof Message) {
            this.queueMsg.add(message);
            System.out.println("Mensaje recibido de "+message.getSender());
            message.setSender(this);
            num_vueltas++;
            notifySub(Actions.SEND);
            if (this.pareja.num_vueltas < 6)
                this.pareja.send(message);
            else this.pareja.send(new QuitMessage());
        } else {
            System.out.println("He roto la cadena");
            this.queueMsg.add(message);
        }

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
        return numMsg;
    }

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

    public int getNum_vueltas() {
        return num_vueltas;
    }

    @Override
    public String toString() {
        return "PingPongActor{" +
                "num_vueltas=" + num_vueltas +
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
