import java.util.HashMap;
import java.util.List;

public class ActorContext extends Thread{
    private static ActorContext actor;
    private HashMap<String, ActorInterface> name;


    private ActorContext(){}

    public ActorContext getInstance(){
        if (actor == null)
            actor = new ActorContext();
        return actor;
    }

    public void spawnActor(String name,ActorInstance new_actor){

    }

    public boolean lookup(String name){
        return ;
    }

    public List<String> getNames(){

    }
}
