import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;

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
         ringArray[i] = ActorContext.spawnActor(new RingActor(name));
         }

         for (int j = 1; j < NUM_ACTORS; j++){
         ringArray[j - 1].getRingActor().linkActor(ringArray[j].getRingActor());
         }
         ringArray[NUM_ACTORS -1].getRingActor().linkActor(ringArray[0].getRingActor());

         ringArray[0].send(new Message(ringArray[99], "CHE VOS CUANTAS COPAS TENES BOBO?"));
         **/

        /**PARTE 2**/
        /**
         ProxyClient insult = ActorContext.spawnProxy(new InsultActor("Insult"));
         insult.send(new AddInsultMessage(insult, "HOLA"));
         insult.send(new GetInsultMessage(insult, ""));
         MessageInterface result = insult.recieve();
         System.out.println(result.getMsg());
         **/

        /**PARTE 3**/

        ActorProxy sender = ActorContext.spawnActor(new FirewallDecorator(new EncryptionDecorator(new Actor("a"))));
        ActorProxy target = ActorContext.spawnActor(new FirewallDecorator(new Actor("b"))); // new EncryptionDecorator()
        ActorProxy target3 = ActorContext.spawnActor(new EncryptionDecorator(new Actor("f")));
        ActorProxy target1 = ActorContext.spawnActor(new EncryptionDecorator(new FirewallDecorator(new Actor("c"))));
        ActorProxy target2 = ActorContext.spawnActor(new FirewallDecorator(new Actor("d")));
        ProxyClient proxy = ActorContext.spawnProxy(new FirewallDecorator(new Actor("e")));
        ActorProxy lambaDecorator = ActorContext.spawnActor(new LambdaFirewallDecorator(new Actor("f"), x -> x.getMsg() != null));

        //target.send(new Message(sender, "hola que tal"));
        //target3.send(new Message(sender, "hola que tal dos"));
        //target1.send(new Message(sender, "hola que tal dos"));
        //target.send(new Message(proxy, "soy un proxy muy malo"));
        //System.out.println("Ahora el lambda enviara un mensaje: ");

        lambaDecorator.send(new AddClosureMessage(x -> x.getMsg().equals("predicado")));
        //target2.send(new Message(lambaDecorator, "pepito"));
        lambaDecorator.send(new Message(target2, "preicado"));


        /**PARTE 4**/
        /**
         ActorProxy actor = ActorContext.spawnActor(new InsultActor("name"));
         InsultService insulter = (InsultService) DynamicProxy.intercept(new InsultServiceImp(), actor);
         insulter.addInsult(new Message(null,"stupid"));

         System.out.println(insulter.getInsult());
         **/
    }
}
