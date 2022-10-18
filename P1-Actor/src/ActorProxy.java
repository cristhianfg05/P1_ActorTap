public class ActorProxy implements ActorInterface{

    private ActorInterface actor;

    public ActorProxy(ActorInterface a){
        actor = a;
    }
    @Override
    public void send(Message message) {
        /**DESDE AQUI SE LLAMA AL SEND DE CADA ACTOR*/
        actor.send(message);
    }
}
