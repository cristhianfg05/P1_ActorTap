package Model;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final int NUM_ACTORS = 6;

        ActorContext ActorED = ActorContext.getInstance();

        /**PARTE 1**/
        /**Model.ActorContext es la estructura donde se guardan los actores**/
        /**
         Model.ActorProxy ringArray[] = new Model.ActorProxy[NUM_ACTORS];

         for(int i = 0; i < NUM_ACTORS; i++){
         String name = "Ring" + i;
         ringArray[i] = Model.ActorContext.spawnActor(new Model.RingActor(name));
         }

         for (int j = 1; j < NUM_ACTORS; j++){
         ringArray[j - 1].getRingActor().linkActor(ringArray[j].getRingActor());
         }
         ringArray[NUM_ACTORS -1].getRingActor().linkActor(ringArray[0].getRingActor());

         ringArray[0].send(new Model.Message(ringArray[99], "CHE VOS CUANTAS COPAS TENES BOBO?"));
         **/

        /**PARTE 2**/
        /**
         Model.ProxyClient insult = Model.ActorContext.spawnProxy(new Model.InsultActor("Insult"));
         insult.send(new Model.AddInsultMessage(insult, "HOLA"));
         insult.send(new Model.GetInsultMessage(insult, ""));
         Model.MessageInterface result = insult.recieve();
         System.out.println(result.getMsg());
         **/

        /**PARTE 3**/

        ActorProxy sender = ActorContext.spawnActor(new FirewallDecorator(new EncryptionDecorator(new Actor("a"))));
        ActorProxy target = ActorContext.spawnActor(new FirewallDecorator(new Actor("b"))); // new Model.EncryptionDecorator()
        ActorProxy target3 = ActorContext.spawnActor(new EncryptionDecorator(new Actor("f")));
        ActorProxy target1 = ActorContext.spawnActor(new EncryptionDecorator(new FirewallDecorator(new Actor("c"))));
        ActorProxy target2 = ActorContext.spawnActor(new FirewallDecorator(new Actor("d")));
        ProxyClient proxy = ActorContext.spawnProxy(new FirewallDecorator(new Actor("e")));
        ActorProxy lambaDecorator = ActorContext.spawnActor(new LambdaFirewallDecorator(new Actor("f"), x -> x.getMsg() != null));

        //target.send(new Model.Message(sender, "hola que tal"));
        //target3.send(new Model.Message(sender, "hola que tal dos"));
        //target1.send(new Model.Message(sender, "hola que tal dos"));
        //target.send(new Model.Message(proxy, "soy un proxy muy malo"));
        //System.out.println("Ahora el lambda enviara un mensaje: ");

        lambaDecorator.send(new AddClosureMessage(x -> x.getMsg().equals("predicado")));
        //target2.send(new Model.Message(lambaDecorator, "pepito"));
        lambaDecorator.send(new Message(target2, "preicado"));


        /**PARTE 4**/
        /**
         Model.ActorProxy actor = Model.ActorContext.spawnActor(new Model.InsultActor("name"));
         Model.InsultService insulter = (Model.InsultService) Model.DynamicProxy.intercept(new Model.InsultServiceImp(), actor);
         insulter.addInsult(new Model.Message(null,"stupid"));

         System.out.println(insulter.getInsult());
         **/
    }
}
