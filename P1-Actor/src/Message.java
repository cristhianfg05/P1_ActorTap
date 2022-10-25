public class Message {

    private ActorInterface reciever;
    private String msg;

    private ActorInterface sender;

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

    public ActorInterface getSender() {
        return sender;
    }

    public void setSender(ActorInterface sender) {
        this.sender = sender;
    }
}
