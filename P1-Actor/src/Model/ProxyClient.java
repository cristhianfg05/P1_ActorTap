package Model;

import java.util.concurrent.LinkedBlockingQueue;

public class ProxyClient implements ActorInterface{
    private LinkedBlockingQueue<MessageInterface> queueMsg;
    private ActorInterface actor;


    /**
     * Model.ProxyClient constructor
     *
     * @param actor
     */
    public ProxyClient(ActorInterface actor){
        queueMsg = new LinkedBlockingQueue<>();
        this.actor = actor;
    }

    /**
     * Send the message to the actor inside the proxy
     *
     * @param message
     */
    public void send(MessageInterface message){
        message.setReciever(this);
        //aux.getQueueMsg().add(message);
        if(message instanceof Message){
            System.out.println("He llegado");
            queueMsg.add(message);
        }else actor.send(message);
    }

    /**
     * @return queueMsg
     */
    @Override
    public LinkedBlockingQueue<MessageInterface> getQueueMsg() {
        return queueMsg;
    }

    /**
     * @return last Model.Message from queue
     * @throws InterruptedException
     */
    public MessageInterface recieve() throws InterruptedException {
        return queueMsg.take();
    }


    public void process(MessageInterface message){

    }

    @Override
    public String getName() {
        return actor.getName();
    }

    @Override
    public int getMsg() {
        return actor.getMsg();
    }

    @Override
    public void run() {

    }

    /**
     * @param o
     */
    @Override
    public void subscrib(Observer o) {

    }

    /**
     * @param o
     */
    @Override
    public void unsub(Observer o) {

    }

    /**
     * @param a
     */
    @Override
    public void notifySub(Actions a) {

    }
}
