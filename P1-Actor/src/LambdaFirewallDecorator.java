import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaFirewallDecorator extends RingActor{

    /**It will get a predicate through constructor that we will use after in order to send the message**/
    List<Predicate<MessageInterface>> predicate = new ArrayList<>();

    public LambdaFirewallDecorator(RingActor actor, Predicate<MessageInterface> predicate) {
        super(actor);
        this.predicate.add(predicate);
    }

    /**Override of send method, this will call test method from predicate to see if the message can be sent**/
    @Override
    public void send(MessageInterface message) {
        if (message instanceof Message) {
            System.out.println("he entrado");
            List<Predicate<MessageInterface>> aux = predicate.stream()
                    .filter(x -> x.test(message)).collect(Collectors.toList());
            System.out.println("Size aux: " + aux.size() + " Size de la lista de preds : " + predicate.size());
            if (aux.size() == predicate.size()) {
                System.out.println("Envio el mensajito");
                super.send(message);
            }
        }else{
            predicate.add(((AddClosureMessage)message).getPredicate());
        }
    }
}
