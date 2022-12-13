
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

    // Se llama desde el run
    public void process(MessageInterface message){
        message.setMsg(CaesarCipher.decrypt(message.getMsg(), 1));
        System.out.println("Decrypted message: " + message.getMsg());
    }
}
