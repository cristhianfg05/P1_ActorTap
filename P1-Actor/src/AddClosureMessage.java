import java.util.function.Predicate;

public class AddClosureMessage implements MessageInterface{

    private ActorInterface reciever;
    private ActorInterface sender;
    private Predicate<MessageInterface> predicate;

    public AddClosureMessage(Predicate<MessageInterface> predicate){
        this.predicate = predicate;
    }

    @Override
    public ActorInterface getReciever() {
        return reciever;
    }

    @Override
    public void setReciever(ActorInterface reciever) {
        this.reciever = reciever;
    }

    @Override
    public String getMsg() {
        return null;
    }

    public Predicate<MessageInterface> getPredicate(){
        return this.predicate;
    }

    @Override
    public void setMsg(String msg) {

    }

    @Override
    public ActorInterface getSender() {
        return sender;
    }

    @Override
    public void setSender(ActorInterface sender) {
        this.sender = sender;
    }


}
