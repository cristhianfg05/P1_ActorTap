import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActorContext extends Thread{
    private static ActorContext actor;
    private static HashMap<String, ActorInterface> map;


    private ActorContext(){}

    public static ActorContext getInstance(){
        if (actor == null){
            actor = new ActorContext();
            map = new HashMap<String, ActorInterface>();
        }
        return actor;
    }

    public static ActorProxy spawnActor(String name,ActorInterface newActor){
        ActorProxy aux = new ActorProxy(newActor);
        map.put(name, aux);
        return aux;
    }

    public boolean lookup(String name){
        return map.containsKey(name);
    }

    public List<String> getNames(){
        List<String> names = new ArrayList<String>();
        /**ESTE BUCLE REHACERLO CON LAMBDAS**/
        for(Map.Entry<String, ActorInterface> entry : map.entrySet()){
            names.add(entry.getKey());
        }
        return names;
    }
}
