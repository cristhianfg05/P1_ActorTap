package Model;

import java.util.HashMap;

public class FactoryNormal extends Factory{
    private static FactoryNormal f;
    private static HashMap<String, ActorInterface>map;

    private FactoryNormal(){}
    public static FactoryNormal getInstance(){
        if(f == null){
            f = new FactoryNormal();
            map = new HashMap<String,ActorInterface>();
        }
        return f;
    }


    public static ActorProxy spawnActor(ActorInterface a) {
        ActorProxy aux = new ActorProxy(a);
        new Thread(a).start();
        //Thread.startVirtualThread(newActor);
        /**Almaceno el actor en el hashMap*/
        map.put(a.getName(), a);

        /**Devuelvo el actorProxy (puede ser cualquier tipo de actor)**/
        return aux;
    }

    @Override
    public ProxyClient spawnProxy(ActorInterface a) {
        ProxyClient aux = new ProxyClient(a);
        new Thread(a).start();

        /**Almaceno el actor en el hashMap*/
        map.put(a.getName(), a);

        /**Devuelvo el actorProxy (puede ser cualquier tipo de actor)**/
        return aux;
    }
}
