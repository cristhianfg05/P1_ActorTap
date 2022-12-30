
import java.util.Queue;

// This class extends ActorDecorator, so it has the same methods and in this case we override the send and the
// process method because we want to encrypt our message
public class EncryptionDecorator extends  ActorDecorator{

    public EncryptionDecorator(ActorInterface actor) {
        super(actor);
    }

    /**
     * Encrypt message and then add to the list calling the actorDecorator
     *
     * @param message
     */
    @Override
    public void send(MessageInterface message){
        message.setMsg(CaesarCipher.encrypt(message.getMsg(), 1));
        System.out.println("Encrypted message: " + message.getMsg());
        super.send(message);
    }

    /**
     * Decrypt the message then process it
     *
     * @param message
     */
    @Override
    public void process(MessageInterface message){
        message.setMsg(CaesarCipher.decrypt(message.getMsg(), 1));
        System.out.println("Decrypted message: " + message.getMsg());
    }
}
