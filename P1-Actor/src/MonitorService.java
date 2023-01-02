import java.lang.reflect.Array;
import java.util.ArrayList;

public class MonitorService implements MonitorInterface{

    private ArrayList<ActorInterface> listaActores;

    /**
     * Constructor from MonitorService
     */
    public MonitorService(){
        listaActores = new ArrayList<>();
    }

    /**
     * @param a Actor interface
     * @return if Monitor is subscribed to an Actor
     */
    public boolean actorSubscrito(ActorInterface a){
        return listaActores.contains(a);
    }

    /**
     * @return subscribed list
     */
    public ArrayList getList(){
        return listaActores;
    }

    /**
     * Notify the Monitor about the state of the actor
     * due to probles during the development it only notify some sent messages
     *
     * @param state
     */
    @Override
    public void Update(String state) {
        System.out.println("Procedo a notificar, acaba de pasar un "+ state);
    }
}
