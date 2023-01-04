package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActorContext extends Thread{
    private static ActorContext actor;
    private static HashMap<String, ActorInterface> map;



    private ActorContext(){}

    /**
     * Singleton usage
     * @return Model.ActorContext
     */
    public static ActorContext getInstance(){
        if (actor == null){
            actor = new ActorContext();
            map = new HashMap<String, ActorInterface>();
        }
        return actor;
    }

    /**
     * @param newActor "Model.Actor type"
     *
     * Create the new Proxy and start the Thread from the actor recived
     *
     * @return ActorPorxy "Model.Actor container"
     */
    public static ActorProxy spawnActor(ActorInterface newActor){
        /**Creo un actorProxy a traves del actor que me ha llegado**/
        ActorProxy aux = new ActorProxy(newActor);
        new Thread(newActor).start();
        //Thread.startVirtualThread(newActor);
        /**Almaceno el actor en el hashMap*/
        map.put(newActor.getName(), newActor);

        /**Devuelvo el actorProxy (puede ser cualquier tipo de actor)**/
        return aux;
    }

    /**
     * @param newActor "Model.Actor Type"
     *
     * Create the new Model.ProxyClient and start the Thread from the actor recived
     *
     * @return Model.ProxyClient
     */
    public static ProxyClient spawnProxy(ActorInterface newActor){
        /**Creo un Model.ProxyClient a traves del proxy que me ha llegado**/
        ProxyClient aux = new ProxyClient(newActor);
        new Thread(newActor).start();

        /**Almaceno el actor en el hashMap*/
        map.put(newActor.getName(), newActor);

        /**Devuelvo el actorProxy (puede ser cualquier tipo de actor)**/
        return aux;
    }

    /**
     * @param name
     *
     * Check if actor exists
     *
     * @return if exists
     */
    public ActorInterface lookup(String name){
        return map.get(name);
    }

    /**
     * Acummulate all the names from the actors
     *
     * @return names from Model.Actor map
     */
    public List<String> getNames(){
        List<String> names = new ArrayList<String>();
        for(Map.Entry<String, ActorInterface> entry : map.entrySet()){
            names.add(entry.getKey());
        }
        return names;
    }
}
