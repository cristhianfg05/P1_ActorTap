public class ActorContext extends Thread{
    private static ActorContext actor;


    private ActorContext(){}

    public ActorContext getInstance(){
        if (actor == null)
            actor = new ActorContext();
        return actor;
    }
}
