package Model;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaFirewallDecorator extends ActorDecorator {

    /**It will get a predicate through constructor that we will use after in order to send the message**/
    List<Predicate<MessageInterface>> predicate = new ArrayList<>();

    /**
     * Model.LambdaFirewallDecorator constructor
     *
     * @param actor
     * @param predicate
     */
    public LambdaFirewallDecorator(ActorInterface actor, Predicate<MessageInterface> predicate) {
        super(actor);
        this.predicate.add(predicate);
    }


    /**
     * if it's a Model.Message object filter this one with the different predicates, if it's not a Model.Message then its a predicate
     * and has to be added to the list
     *
     * @param message
     */
    @Override
    public void send(MessageInterface message) {
        if (message instanceof Message) {
            System.out.println("he entrado");
            List<Predicate<MessageInterface>> aux = predicate.stream()
                    .filter(x -> x.test(message)).collect(Collectors.toList());
            if (aux.size() == predicate.size()) {
                System.out.println("Envio el mensajito");
                super.send(message);
            }
        }else{
            predicate.add(((AddClosureMessage)message).getPredicate());
        }
    }
}
