import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;
public class Tests {

    public ActorContext ActorED = ActorContext.getInstance();
    @Test
    public void testRing(){
        Instant start = Instant.now();

        ActorProxy ringArray[] = new ActorProxy[10];
        for (int i = 0; i < 10; i++){
            String name = "Ring "+i;
            ringArray[i] = ActorContext.spawnActor(new RingActor(name));
        }

        for (int i = 1; i < 10; i++){
            ringArray[i-1].getRingActor().linkActor(ringArray[i].getRingActor());
        }
        ringArray[9].getRingActor().linkActor(ringArray[0].getRingActor());

        ringArray[0].send(new Message(ringArray[9], "CHE VOS CUANTAS COPAS TENES BOBO?"));
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start,end);
        System.out.println((Float.valueOf(timeElapsed.getNano()) / 1000000.0) + " milisegundos");

    }

    @Test
    public void testPingPong(){
        ActorProxy ping1 = ActorContext.spawnActor(new PingPongActor("PingPong 1"));
        ActorProxy ping2 = ActorContext.spawnActor(new PingPongActor("PingPong 2"));
        ping2.getPingPongActor().setPareja(ping1.getPingPongActor());
        ping1.getPingPongActor().setPareja(ping2.getPingPongActor());
        ping2.send(new Message(ping1,"Hola que tal?"));
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testParte2() throws InterruptedException {
        ProxyClient insult = ActorContext.spawnProxy(new InsultActor("Insult"));
        insult.send(new AddInsultMessage(insult, "tonto"));
        insult.send(new AddInsultMessage(insult, "imbecil"));
        insult.send(new AddInsultMessage(insult, "monkey"));
        insult.send(new AddInsultMessage(insult, "CR7 enjoyer"));
        insult.send(new AddInsultMessage(insult, "noob"));
        insult.send(new AddInsultMessage(insult, "tonto2"));
        insult.send(new AddInsultMessage(insult, "imbecil2"));
        insult.send(new AddInsultMessage(insult, "monkey2"));
        insult.send(new AddInsultMessage(insult, "CR7 enjoyer2"));
        insult.send(new AddInsultMessage(insult, "noob2"));
        insult.send(new AddInsultMessage(insult, "tonto3"));
        insult.send(new AddInsultMessage(insult, "imbecil3"));
        insult.send(new AddInsultMessage(insult, "monkey3"));
        insult.send(new AddInsultMessage(insult, "CR7 enjoyer3"));
        insult.send(new AddInsultMessage(insult, "noob3"));
        insult.send(new GetInsultMessage(insult, ""));
        MessageInterface result = insult.recieve();
        System.out.println(result.getMsg());
    }

    @Test
    public void testParte3(){
        System.out.println("-----------------------------------------------------------------------------");
        ActorProxy sender = ActorContext.spawnActor(new FirewallDecorator(new EncryptionDecorator(new Actor("Ring0"))));
        ActorProxy target = ActorContext.spawnActor(new FirewallDecorator (new Actor("Ring1"))); // new EncryptionDecorator()
        ActorProxy target1 = ActorContext.spawnActor(new EncryptionDecorator(new FirewallDecorator (new Actor("Ring2"))));
        ActorProxy target2 = ActorContext.spawnActor(new FirewallDecorator (new Actor("Ring3")));
        ProxyClient proxy = ActorContext.spawnProxy( new FirewallDecorator(new Actor("Ring4")));
        ActorProxy lambaDecorator = ActorContext.spawnActor( new LambdaFirewallDecorator(new Actor("RingLambda"), x -> x.getMsg() != null ));

        target.send(new Message(sender,"hola que tal"));
        target1.send(new Message(sender, "hola que tal dos"));
        target.send(new Message(proxy,"soy un proxy muy malo"));
        System.out.println("Ahora el lambda enviara un mensaje: ");

        lambaDecorator.send(new AddClosureMessage(x-> x.getMsg().equals("predicado")));
        target2.send(new Message(lambaDecorator,"pepito"));
        lambaDecorator.send(new Message(target2,"predicado"));
        System.out.println("-----------------------------------------------------------------------------");
    }

    @Test
    public void testParte4(){
        ActorProxy actor = ActorContext.spawnActor(new InsultActor("name"));
        InsultService insulter = (InsultService) DynamicProxy.intercept(new InsultServiceImp(), actor);
        insulter.addInsult(new Message(null,"stupid"));
        insulter.addInsult(new Message(null,"Chupachanclas"));
        insulter.addInsult(new Message(null,"Gilipollas"));

        insulter.addInsult(new Message(null,"stupid1"));
        insulter.addInsult(new Message(null,"Chupachanclas2"));
        insulter.addInsult(new Message(null,"Gilipollas3"));
        insulter.addInsult(new Message(null,"stupid4"));
        insulter.addInsult(new Message(null,"Chupachanclas5"));
        insulter.addInsult(new Message(null,"Gilipollas6"));
        insulter.addInsult(new Message(null,"stupid7"));
        insulter.addInsult(new Message(null,"Chupachanclas8"));
        insulter.addInsult(new Message(null,"Gilipollas9"));



        System.out.println(insulter.getInsult());
    }
}
