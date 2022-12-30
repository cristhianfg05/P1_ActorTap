import java.util.function.Predicate;

public class AddClosureMessage implements MessageInterface{

    private ActorInterface reciever;
    private ActorInterface sender;
    private Predicate<MessageInterface> predicate;

    /**
     * Constructor with the first predicate
     *
     * @param predicate
     */
    public AddClosureMessage(Predicate<MessageInterface> predicate){
        this.predicate = predicate;
    }

    /**
     * @return reciever
     */
    @Override
    public ActorInterface getReciever() {
        return reciever;
    }

    /**
     * Set the reciever
     *
     * @param reciever
     */
    @Override
    public void setReciever(ActorInterface reciever) {
        this.reciever = reciever;
    }

    @Override
    public String getMsg() {
        return null;
    }

    /**
     * @return all predicate list
     */
    public Predicate<MessageInterface> getPredicate(){
        return this.predicate;
    }

    @Override
    public void setMsg(String msg) {

    }

    /**
     * @return sender
     */
    @Override
    public ActorInterface getSender() {
        return sender;
    }

    /**
     * Set actor Sender
     *
     * @param sender
     */
    @Override
    public void setSender(ActorInterface sender) {
        this.sender = sender;
    }


}
