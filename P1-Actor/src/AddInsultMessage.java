public class AddInsultMessage implements MessageInterface{
    private ActorInterface sender;
    private String msg;
    private ActorInterface reciever;


    /**
     * AddInsultMessage Constructor
     *
     * @param actor
     * @param msg
     */
    public AddInsultMessage(ActorInterface actor, String msg) {
        this.reciever = actor;
        this.msg = msg;
    }

    /**
     * @return receiver
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
     * @return String message
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

    @Override
    public String toString() {
        return "AddInsultMessage{" +
                "msg='" + msg + '\'' +
                '}';
    }
}