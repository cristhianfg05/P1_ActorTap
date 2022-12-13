import java.lang.Class;
public class FirewallDecorator extends RingActor{
    public FirewallDecorator(RingActor actor) {
        super();
    }

    public void send (MessageInterface message){
        System.out.println("FirewallDecorator send");

        if (!(message.getSender() instanceof ProxyClient)){
            System.out.println("No soy proxy");
            super.send(message);
        } else {
            System.out.println("El proxy de aqui no pasa");
        }
    }

}
