import java.util.concurrent.LinkedBlockingQueue;

public class PingPongActor implements ActorInterface, Runnable {
    private LinkedBlockingQueue<MessageInterface> queueMsg;
    private int num_vueltas;
    private String name;

    private PingPongActor pareja;

    public PingPongActor(String name) {
        this.name = name;
        queueMsg = new LinkedBlockingQueue<>();
        this.num_vueltas = 0;
    }

    public void setPareja(PingPongActor p) {
        pareja = p;
    }

    @Override
    public void send(MessageInterface message) {

        if (message instanceof Message) {
            this.queueMsg.add(message);
            System.out.println("Mensaje recibido de "+message.getSender());
            message.setSender(this);
            num_vueltas++;
            if (this.pareja.num_vueltas < 6)
                this.pareja.send(message);
            else this.pareja.send(new QuitMessage());
        } else {
            System.out.println("He roto la cadena");
            this.queueMsg.add(message);
        }

    }


    @Override
    public LinkedBlockingQueue<MessageInterface> getQueueMsg() {
        return queueMsg;
    }

    @Override
    public void process(MessageInterface message) throws InterruptedException {
        System.out.println(message);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                MessageInterface aux = this.queueMsg.take();
                if (aux instanceof Message)
                    process(aux);
                else break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getNum_vueltas() {
        return num_vueltas;
    }

    @Override
    public String toString() {
        if (name == null)
            return "Main";
        else
            return "PingPongActor{" +
                    "name='" + name + '\'' +
                    '}';
    }
}
