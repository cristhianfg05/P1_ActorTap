import java.lang.Class;

// In this case we override the send method because we don't want any proxy to be able to send a message
public class FirewallDecorator extends ActorDecorator{
    public FirewallDecorator(ActorInterface actor) {
        super(actor);
    }

    @Override
    public void send (MessageInterface message){
        System.out.println("FirewallDecorator send");

        if (message.getSender() instanceof ProxyClient){
            System.out.println("El proxy de aqui no pasa");
        } else {
            System.out.println("No soy proxy");
            super.send(message);
        }
    }
}
