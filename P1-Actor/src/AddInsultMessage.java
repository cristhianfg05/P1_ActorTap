public class AddInsultMessage implements MessageInterface{
    private ActorInterface sender;
    private String msg;
    private ActorInterface reciever;


    public AddInsultMessage(ActorInterface actor, String msg) {
        this.reciever = actor;
        this.msg = msg;
    }
    @Override
    public ActorInterface getReciever() {
        return reciever;
    }

    @Override
    public void setReciever(ActorInterface reciever) {
        this.reciever = reciever;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public ActorInterface getSender() {
        return sender;
    }

    @Override
    public void setSender(ActorInterface sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "AddInsultMessage{" +
                "msg='" + msg + '\'' +
                '}';
    }
}