
import java.util.Queue;

public class EncryptionDecorator extends  ActorDecorator{
    public EncryptionDecorator(ActorInterface actor) {
        super(actor);
    }
    @Override
    public void send(MessageInterface message){
        message.setMsg(CaesarCipher.encrypt(message.getMsg(), 1));
        System.out.println("Encrypted message: " + message.getMsg());
        super.send(message);
    }

}
