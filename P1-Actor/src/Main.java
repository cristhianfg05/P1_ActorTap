public class Main {

    public static void main(String[] args) {
        ActorContext a = ActorContext.getInstance();
        ActorProxy hello = ActorContext.spawnActor("name",new RingActor());
        hello.send(new Message(null,"Hello World"));
    }
}
