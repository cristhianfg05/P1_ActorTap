public class Main {

    public static void main(String[] args) {
        System.out.println("HELLO WORLD");
        ActorProxy hello = ActorContext.spawnActor("name",new RingActor());
        hello.send(new Message(null,"Hello World"));
    }
}
