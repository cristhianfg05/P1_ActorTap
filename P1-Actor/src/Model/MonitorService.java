package Model;


public class MonitorService implements Observer{
    /**
     * Give's info about the state of the Actor
     * @param name Actor's name
     * @param action Action the actor is doing
     */
    @Override
    public void update(String name, Actions action) {
        System.out.println("ESTOY SIENDO NOTIFICADO " +name+ " ha "+action.name());
    }
}
