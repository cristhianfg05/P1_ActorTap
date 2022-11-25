import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ActorDecorator implements ActorInterface{
    ActorInterface actor;

    public ActorDecorator(ActorInterface actor){
        this.actor = actor;
    }
    @Override
    public void send(MessageInterface message) {
        actor.send(message);
    }

    @Override
    public LinkedBlockingQueue<MessageInterface> getQueueMsg() {
        return actor.getQueueMsg();
    }

    @Override
    public void run() {
        while(true){
            try {
                MessageInterface aux = actor.getQueueMsg().take();
                aux.setMsg(CaesarCipher.decrypt(aux.getMsg(), 1));
                System.out.println("Decrypted message: " + aux.getMsg());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
