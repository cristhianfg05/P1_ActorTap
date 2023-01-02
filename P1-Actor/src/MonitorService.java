import java.lang.reflect.Array;
import java.util.ArrayList;

public class MonitorService implements MonitorInterface{

    private ArrayList<ActorInterface> listaActores;

    public MonitorService(){
        listaActores = new ArrayList<>();
    }

    public boolean actorSubscrito(ActorInterface a){
        return listaActores.contains(a);
    }

    public ArrayList getList(){
        return listaActores;
    }

    @Override
    public void Update(String state) {
        System.out.println("Procedo a notificar, acaba de pasar un "+ state);
    }
}
