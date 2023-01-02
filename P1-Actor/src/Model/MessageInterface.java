package Model;

public interface MessageInterface {

    public ActorInterface getReciever();
    public void setReciever(ActorInterface reciever);
    public String getMsg();
    public void setMsg(String msg);
    public ActorInterface getSender();
    public void setSender(ActorInterface sender);
}
