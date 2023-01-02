import java.lang.reflect.AccessibleObject;
import java.util.HashMap;

public class Observer {

    private static Observer ob;

    private Observer(){}

    public static Observer getInstance(){
        if (ob == null){
            ob = new Observer();
        }
        return ob;
    }

    public static boolean Subscribe(MonitorService m, ActorInterface a){
        m.getList().add(a);
        return true;
    }

    public static boolean Unsubscribe(MonitorService m, ActorInterface a){
        if(m.actorSubscrito(a)){
            m.getList().remove(a);
            return true;
        }
        return false;
    }

    public static boolean notifyMonitor(MonitorService m, String state, ActorInterface a){
        if(m.actorSubscrito(a)) m.Update(state);
        return true;
    }

}
