import java.util.concurrent.LinkedBlockingQueue;

public class Actor implements ActorInterface, Runnable{

    private LinkedBlockingQueue<MessageInterface> queueMsg;
    private String name;

    public Actor(String name){
        queueMsg = new LinkedBlockingQueue<>();
        this.name = name;
    }
    @Override
    public void send(MessageInterface message) {
        this.queueMsg.add(message);
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
    public int getMsg() {
        return 0;
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
}
