public class Message implements MessageInterface{

    private ActorInterface reciever;
    private String msg;

    private ActorInterface sender;


    public Message(){}

    /**
     * Message constructor
     *
     * @param actor
     * @param msg
     */
    public Message(ActorInterface actor, String msg) {
        this.sender = actor;
        this.msg = msg;
    }

    /**
     * Message constructor
     *
     * @param sender
     * @param reciever
     * @param msg
     */
    public Message(ActorInterface sender,ActorInterface reciever, String msg) {
        this.reciever = reciever;
        this.msg = msg;
        this.sender = sender;
    }

    /**
     * @return reciever
     */
    public ActorInterface getReciever() {
        return reciever;
    }

    /**
     * Set reciever
     *
     * @param reciever
     */
    public void setReciever(ActorInterface reciever) {
        this.reciever = reciever;
    }

    /**
     * @return String msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Set msg
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "El mensaje fue enviado por " + this.sender + "\nMSG: "+this.msg;
    }

    /**
     * @return sender
     */
    public ActorInterface getSender() {
        return sender;
    }

    /**
     * Set sender
     *
     * @param sender
     */
    public void setSender(ActorInterface sender) {
        this.sender = sender;
    }
}
