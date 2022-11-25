import java.lang.Class;
public class FirewallDecorator extends ActorDecorator{
    public FirewallDecorator(ActorInterface actor) {
        super(actor);
    }

    public void send (MessageInterface message){
        System.out.println("FirewallDecorator send");

        if (!ProxyClient.class.isInstance(message.getSender())){
            System.out.println("No soy proxy");
            super.send(message);
        } else {
            System.out.println("El proxy de aqui no pasa");
        }
    }
}
