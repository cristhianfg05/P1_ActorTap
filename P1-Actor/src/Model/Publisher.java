package Model;

public interface Publisher {
    void subscrib(Observer o);
    void unsub(Observer o);
    void notifySub(Actions a);

}
