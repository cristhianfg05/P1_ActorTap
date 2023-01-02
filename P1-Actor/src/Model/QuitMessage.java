package Model;

public class QuitMessage implements MessageInterface{

    public QuitMessage(){}
    @Override
    public ActorInterface getReciever() {
        return null;
    }

    @Override
    public void setReciever(ActorInterface reciever) {

    }

    @Override
    public String getMsg() {
        return null;
    }

    @Override
    public void setMsg(String msg) {

    }

    @Override
    public ActorInterface getSender() {
        return null;
    }

    @Override
    public void setSender(ActorInterface sender) {

    }
}
