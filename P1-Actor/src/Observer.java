import java.lang.reflect.AccessibleObject;
import java.util.HashMap;

public class Observer {

    private static Observer ob;

    private Observer(){}

    /**
     * Singletone usage
     *
     * @return Observer instance
     */
    public static Observer getInstance(){
        if (ob == null){
            ob = new Observer();
        }
        return ob;
    }

    /**
     * @param m Monitor
     * @param a Actor
     * @return true if added to list
     */
    public static boolean Subscribe(MonitorService m, ActorInterface a){
        m.getList().add(a);
        return true;
    }
    /**
     * @param m Monitor
     * @param a Actor
     * @return true if removed from list
     */
    public static boolean Unsubscribe(MonitorService m, ActorInterface a){
        if(m.actorSubscrito(a)){
            m.getList().remove(a);
            return true;
        }
        return false;
    }

    /**
     * @param m Monitor
     * @param state Actor state
     * @param a Actor
     * @return true if notified
     */
    public static boolean notifyMonitor(MonitorService m, String state, ActorInterface a){
        if(m.actorSubscrito(a)) m.Update(state);
        return true;
    }

}
