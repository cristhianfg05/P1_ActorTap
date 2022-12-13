import java.nio.charset.StandardCharsets;
/**aitor.arjona@urv.cat**/
public class Main {

    public static void main(String[] args) throws InterruptedException {

        ActorContext ActorED = ActorContext.getInstance();
        /**PARTE 1**/
        /**ActorContext es la estructura donde se guardan los actores**/
        /**

        ActorProxy Sender = ActorContext.spawnActor("Sender",new RingActor());
        ActorProxy Reciever = ActorContext.spawnActor("Reciever",new RingActor());
        ActorProxy Sender2 = ActorContext.spawnActor("Reciever",new RingActor());

        /**SENDERS -> RECIEVER**/
        /**
        Sender.send(new Message(Reciever,"Mensaje del Sender al Reciever"));
        Sender2.send(new Message(Reciever,"Mensaje del Sender2 al Reciever"));
        Sender.send(new Message(Reciever,"Mensaje del Sender al Reciever"));
        Sender2.send(new Message(Reciever,"Mensaje del Sender2 al Reciever"));
        Sender.send(new Message(Reciever,"Mensaje del Sender al Reciever"));

        /**RECIEVER -> SENDERS**/
        /**
        Reciever.send(new Message(Sender,"Mensaje del Reciever al Sender"));
        Reciever.send(new Message(Sender2,"Mensaje del Reciever al Sender2"));
        Reciever.send(new Message(Sender,"Mensaje del Reciever al Sender"));
        Reciever.send(new Message(Sender2,"Mensaje del Reciever al Sender2"));
        Reciever.send(new Message(Sender,"Mensaje del Reciever al Sender"));

        /**PRUEBA CON PAUSA PARA LAS COLAS**/
        /**
        Thread.sleep(10000);
        Sender.send(new Message(Reciever,"Mensaje del Sender al Reciever"));
        Reciever.send(new Message(Sender,"Mensaje del Reciever al Sender"));

        /**PARTE 2**/
        /**
        ProxyClient insult = ActorContext.spawnProxy("Insult", new InsultActor());
        insult.send(new AddInsultMessage(insult, "HOLA"));
        insult.send(new GetInsultMessage(insult, ""));
        MessageInterface result = insult.recieve();
        System.out.println(result.getMsg());
         **/

        /**PARTE 3**/
        RingActor siguiente=new RingActor();
        ActorProxy sender = ActorContext.spawnActor("name",new EncryptionDecorator(siguiente));
        ActorProxy target = ActorContext.spawnActor("name1",new EncryptionDecorator(new RingActor(siguiente)));

        //ProxyClient proxy = ActorContext.spawnProxy("name2", new FirewallDecorator(new RingActor()));
        //ActorProxy lambaDecorator = ActorContext.spawnActor("lambaDecorator", new LambdaFirewallDecorator(new RingActor(), x -> x.getMsg() != null ));

        target.send(new Message(sender,target, "hola que tal"));
        //proxy.send(new Message(target,"soy un proxy muy malo"));
        //System.out.println("Ahora el lambda enviara un mensaje: ");

        //lambaDecorator.send(new AddClosureMessage(x-> x.getMsg().equals("predicado")));
        //lambaDecorator.send(new Message(target,"predicado"));

        /**
        ActorProxy Ring1 = ActorContext.spawnActor("Sender",new RingActor());
        ActorProxy Ring2 = ActorContext.spawnActor("Sender",new RingActor());
        ActorProxy Ring3 = ActorContext.spawnActor("Sender",new RingActor());
        ActorProxy Ring4 = ActorContext.spawnActor("Sender",new RingActor());
        ActorProxy Ring5 = ActorContext.spawnActor("Sender",new RingActor());
        **/
        





    }
}
