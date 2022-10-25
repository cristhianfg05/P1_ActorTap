public class Message {

    ActorInterface reciever;
    String msg;

    public Message(ActorInterface actor, String msg) {
        this.reciever = actor;
        this.msg = msg;
    }

    public ActorInterface getReciever() {
        return reciever;
    }

    public void setReciever(ActorInterface reciever) {
        this.reciever = reciever;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
