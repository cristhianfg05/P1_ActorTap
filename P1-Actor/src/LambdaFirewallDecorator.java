import java.util.function.Predicate;

public class LambdaFirewallDecorator extends ActorDecorator {

    /**It will get a predicate through constructor that we will use after in order to send the message**/
    Predicate<MessageInterface> predicate;
    public LambdaFirewallDecorator(ActorInterface actor, Predicate<MessageInterface> predicate) {
        super(actor);
        this.predicate = predicate;
    }
    /**Override of send method, this will call test method from predicate to see if the message can be sent**/
    @Override
    public void send(MessageInterface message){
        if(predicate.test(message)){
            super.send(message);
        }
    }
    public void addClosureMessage(Predicate<MessageInterface> predicate){
        this.predicate = predicate;
    }
}
