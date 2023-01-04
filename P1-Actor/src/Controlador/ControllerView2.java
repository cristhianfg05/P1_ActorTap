package Controlador;

import Model.*;

import javax.swing.*;

public class ControllerView2 {

    public ControllerView2(){}
    ActorContext ac = ActorContext.getInstance();

    public String crearActorGenerico(String name, String action) {
    ActorProxy newActor;
    switch(action){
        case "Decorator":
            System.out.println("ESTAMOS CREANDO UN Decorator de nombre "+name);
            newActor = ActorContext.spawnActor((new FirewallDecorator(new Actor(name))).getActor());
            return name+" Actor Type: FirewallDecorator";
        case "Encrypt/Decrypt":
            System.out.println("ESTAMOS CREANDO UN Encrypt/Decrypt de nombre "+name);
            newActor = ActorContext.spawnActor((new EncryptionDecorator(new Actor(name))).getActor());
            return name+" Actor Type: EncryptionDecorator";
        case "LambdaDeco":
            System.out.println("ESTAMOS CREANDO UN LambdaDecorator de nombre "+name);
            newActor = ActorContext.spawnActor((new LambdaFirewallDecorator(new Actor(name), x -> x.getMsg() != null)).getActor());
            return name+" Actor Type: LambdaFirewallDecorator";
        default:
            System.out.println("ALGO HA FALLADO");
            break;
    }
    return null;
}

    public String[] returnNames(DefaultListModel<String> listActor) {
        String[] ret = new String[listActor.size()];
        for (int i = 0; i< listActor.size(); i++){
            ret[i] = listActor.get(i);
        }
        return ret;
    }

    public void crearActor(String text, String action, int numRing, DefaultListModel<String> listActor) {
        ActorProxy newActor;
        switch(action){
            case "RingActor":
                ActorProxy ringArray[] = new ActorProxy[numRing];
                for (int i = 0; i < numRing; i++){
                    String name = text+i;
                    ringArray[i] = ActorContext.spawnActor(new RingActor(name));
                    listActor.addElement(name + " Actor Type: RingActor");
                }

                for (int i = 1; i < numRing; i++){
                    ringArray[i-1].getRingActor().linkActor(ringArray[i].getRingActor());
                }
                ringArray[numRing-1].getRingActor().linkActor(ringArray[0].getRingActor());
                break;
            case "PingPong":
                break;

            case "InsultActor":
                break;

            default:
                System.out.println("ALGO HA FALLADO");
                break;
        }
    }
}
