package Model;

import java.util.HashMap;

public class FactoryVirtual extends Factory{

    private static FactoryVirtual f;
    private static HashMap<String, ActorInterface> map;

    private FactoryVirtual(){}
    public static FactoryVirtual getInstance(){
        if(f == null){
            f = new FactoryVirtual();
            map = new HashMap<String,ActorInterface>();
        }
        return f;
    }


    public static ActorProxy spawnActor(ActorInterface a) {
        ActorProxy aux = new ActorProxy(a);
        Thread.startVirtualThread(a);
        /**Almaceno el actor en el hashMap*/
        map.put(a.getName(), a);

        /**Devuelvo el actorProxy (puede ser cualquier tipo de actor)**/
        return aux;
    }

    @Override
    public ProxyClient spawnProxy(ActorInterface a) {
        ProxyClient aux = new ProxyClient(a);
        Thread.startVirtualThread(a);

        /**Almaceno el actor en el hashMap*/
        map.put(a.getName(), a);

        /**Devuelvo el actorProxy (puede ser cualquier tipo de actor)**/
        return aux;
    }
}
