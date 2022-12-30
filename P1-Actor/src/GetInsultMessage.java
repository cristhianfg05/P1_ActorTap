public class GetInsultMessage implements MessageInterface{

    private ActorInterface sender;
    private String msg;
    private ActorInterface reciever;


    /**
     * GetInsultMessage constructor
     *
     * @param actor
     * @param msg
     */
    public GetInsultMessage(ActorInterface actor, String msg) {
        this.reciever = actor;
        this.msg = msg;
    }

    /**
     * @return reciever
     */
    @Override
    public ActorInterface getReciever() {
        return reciever;
    }

    /**
     * Set reciever
     *
     * @param reciever
     */
    @Override
    public void setReciever(ActorInterface reciever) {
        this.reciever = reciever;
    }

    /**
     * @return String msg
     */
    @Override
    public String getMsg() {
        return msg;
    }

    /**
     * Set message
     *
     * @param msg
     */
    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return sender
     */
    @Override
    public ActorInterface getSender() {
        return sender;
    }

    /**
     * Set sender
     *
     * @param sender
     */
    @Override
    public void setSender(ActorInterface sender) {
        this.sender = sender;
    }
}
