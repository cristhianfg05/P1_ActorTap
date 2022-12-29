import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
/**aitor.arjona@urv.cat**/
public class Main {

    public static void main(String[] args) throws InterruptedException {
        final int NUM_ACTORS = 6;

        ActorContext ActorED = ActorContext.getInstance();
        /**PARTE 1**/
        /**ActorContext es la estructura donde se guardan los actores**/
        /**
        ActorProxy ringArray[] = new ActorProxy[NUM_ACTORS];

        for(int i = 0; i < NUM_ACTORS; i++){
            String name = "Ring" + i;
            ringArray[i] = ActorContext.spawnActor(name, new RingActor());
        }

        for (int j = 1; j < NUM_ACTORS; j++){
            ringArray[j - 1].getRingActor().linkActor(ringArray[j].getRingActor());
        }
        ringArray[NUM_ACTORS -1].getRingActor().linkActor(ringArray[0].getRingActor());

        ringArray[0].send(new Message(ringArray[99], "CHE VOS CUANTAS COPAS TENES BOBO?"));
        **/

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
        /**
        ActorProxy sender = ActorContext.spawnActor("name",new FirewallDecorator(new EncryptionDecorator(new RingActor())));
        ActorProxy target = ActorContext.spawnActor("name1",new FirewallDecorator (new RingActor())); // new EncryptionDecorator()
        ActorProxy target1 = ActorContext.spawnActor("name3",new EncryptionDecorator(new FirewallDecorator (new RingActor())));
        ActorProxy target2 = ActorContext.spawnActor("name1",new FirewallDecorator (new RingActor()));
        ProxyClient proxy = ActorContext.spawnProxy("name2", new FirewallDecorator(new RingActor()));
        ActorProxy lambaDecorator = ActorContext.spawnActor("lambaDecorator", new LambdaFirewallDecorator(new RingActor(), x -> x.getMsg() != null ));

        target.send(new Message(sender,"hola que tal"));
        target1.send(new Message(sender, "hola que tal dos"));
        target.send(new Message(proxy,"soy un proxy muy malo"));
        System.out.println("Ahora el lambda enviara un mensaje: ");

        lambaDecorator.send(new AddClosureMessage(x-> x.getMsg().equals("predicado")));
        target2.send(new Message(lambaDecorator,"pepito"));
        lambaDecorator.send(new Message(target2,"predicado"));
        **/

        /**PARTE 4**/

        ActorProxy actor = ActorContext.spawnActor("name",new InsultActor());
        InsultServiceIF insulter = (InsultServiceIF) Proxy.newProxyInstance(InsultServiceIF.class.getClassLoader(),
                                                                        new Class[]{ InsultServiceIF.class},
                                                                        new DynamicProxy(new InsultService()));
        insulter.addInsult(new Message(null,"stupid"));
        System.out.println(insulter.getInsult());

        //InsultService insulter = DynamicProxy.intercept(new InsultService(), actor);

    }
}
