public class FirewallDecorator extends ActorDecorator{
    public FirewallDecorator(ActorInterface actor) {
        super(actor);
    }

    public void send (MessageInterface message){
        System.out.println("FirewallDecorator send");
        if (!(message.getSender() instanceof ProxyClient)){
            System.out.println("No soy proxy");
            super.send(message);
        }
    }
}
