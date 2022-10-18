import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActorContext extends Thread{
    private static ActorContext actor;
    private static HashMap<String, ActorInterface> map;


    private ActorContext(){}

    public ActorContext getInstance(){
        if (actor == null)
            actor = new ActorContext();
        return actor;
    }

    public static ActorProxy spawnActor(String name,ActorInterface new_actor){
        map.put(name, new_actor);
        return (ActorProxy)map.get(name);
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
