package Model;

import java.util.concurrent.LinkedBlockingQueue;


public class ActorDecorator{
    ActorInterface actor;

    /**
     * Model.ActorDecorator Constructor
     *
     * @param actor
     */
    public ActorDecorator(ActorInterface actor){
        this.actor = actor;
    }

    /**
     * Go to send from the actor inside the object
     *
     * @param message
     */
    public void send(MessageInterface message) {
        actor.send(message);
    }

    /**
     * @return Model.Message queue from the actor inside the Object
     */
    public LinkedBlockingQueue<MessageInterface> getQueueMsg() {
        return actor.getQueueMsg();
    }

    /**
     * @param message
     * @throws InterruptedException if fails
     * goes to the actor process
     */
    public void process(MessageInterface message) throws InterruptedException {
        System.out.println("Process del actordecorator");
        actor.process(message);
    }


    public String getName() {
        return actor.getName();
    }

    public int getMsg() {
        return actor.getMsg();
    }

    /**
     * Thread method, process every msg from the queue
     */
    public void run() {
        while(true){
            try {
                process(actor.getQueueMsg().take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
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

    /**
     * @param o
     */
    public void unsub(Observer o) {
        actor.unsub(o);
    }

    public ActorInterface getActor() {
        return actor;
    }
}
