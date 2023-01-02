package Model;

public class GetAllInsultsMessage implements MessageInterface{
    private ActorInterface sender;
    private String msg;
    private ActorInterface reciever;


    /**
     * Model.GetAllInsultsMessage constructor
     *
     * @param actor
     * @param msg
     */
    public GetAllInsultsMessage(ActorInterface actor, String msg) {
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
     * Set receiver
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