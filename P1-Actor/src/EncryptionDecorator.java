
import java.util.Queue;

public class EncryptionDecorator extends  RingActor{


    public EncryptionDecorator(RingActor actor) {
        super();
    }
    @Override
    public void send(MessageInterface message){
        message.setMsg(CaesarCipher.encrypt(message.getMsg(), 1));
        System.out.println("Encrypted message: " + message.getMsg());
        super.send(message);
    }

    // Se llama desde el run
   @Override
    public void process(MessageInterface message){
        System.out.println("Recibo el mensajito.");
        message.setMsg(CaesarCipher.decrypt(message.getMsg(), 1));
        super.process(message);
        System.out.println("Decrypted message: " + message.getMsg());
    }
}
