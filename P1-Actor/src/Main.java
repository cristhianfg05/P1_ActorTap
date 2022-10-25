public class Main {

    public static void main(String[] args) throws InterruptedException {
        ActorContext a = ActorContext.getInstance();
        ActorProxy hello = ActorContext.spawnActor("Sender",new RingActor());
        ActorProxy hello2 = ActorContext.spawnActor("Reciever",new RingActor());
        hello.send(new Message(hello2,"Hello World"));
        hello.send(new Message(hello2,"Hello World"));
        hello.send(new Message(hello2,"Hello World"));
        Thread.sleep(10000);
        hello.send(new Message(hello2,"Hello World"));
    }
}
