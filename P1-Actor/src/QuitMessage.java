public class QuitMessage implements MessageInterface{

    //Constructor vacio para que se pueda enviar para parar el proceso
    public  QuitMessage(){}
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
