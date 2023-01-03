package Model;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class ActorProxy implements ActorInterface{
    private ActorInterface actor;

    /**
     * Model.ActorProxy constructor
     *
     * @param a Type of actor
     */
    public ActorProxy(ActorInterface a) {
        actor = a;
    }

    /**
     * Goes to the send method from the Model.Actor inside the proxy
     *
     * @param message
     */
    public void send(MessageInterface message) {
        actor.send(message);
    }

    public RingActor getRingActor(){
        return (RingActor) this.actor;
    }
    public PingPongActor getPingPongActor(){
        return (PingPongActor) this.actor;
    }

    /**
     * @return queueMsg from actor inside the proxy
     */
    public LinkedBlockingQueue<MessageInterface> getQueueMsg() {
       return actor.getQueueMsg();
    }

    /**
     * @param message
     * @throws InterruptedException
     */
    @Override
    public void process(MessageInterface message) throws InterruptedException {

    }


    public String getName() {
        return actor.getName();
    }

    public int getMsg() {
        return actor.getMsg();
    }


    @Override
    public String toString() {
        return actor.toString();
    }

    /**
     * @param o
     */
    public void subscrib(Observer o) {
        actor.subscrib(o);
    }

    public void unsub(Observer o) {
        actor.unsub(o);
    }

    /**
     * @param a
     */
    @Override
    public void notifySub(Actions a) {

    }

    /**
     *
     */
    @Override
    public void run() {

    }
}
