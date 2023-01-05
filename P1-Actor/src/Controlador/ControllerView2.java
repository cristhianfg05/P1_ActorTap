package Controlador;

import Model.*;

import javax.swing.*;

public class ControllerView2 {

    public ControllerView2() {
    }

    ActorContext ac = ActorContext.getInstance();
    ActorProxy sender = ActorContext.spawnActor(new Actor("ENVIADOR"));

    public String crearActorGenerico(String name, String action) {
        ActorProxy newActor;
        switch (action) {
            case "Decorator":
                System.out.println("ESTAMOS CREANDO UN Decorator de nombre " + name);
                newActor = ActorContext.spawnActor((new FirewallDecorator(new Actor(name))).getActor());
                return name + " Actor Type: FirewallDecorator";
            case "Encrypt/Decrypt":
                System.out.println("ESTAMOS CREANDO UN Encrypt/Decrypt de nombre " + name);
                newActor = ActorContext.spawnActor((new EncryptionDecorator(new Actor(name))).getActor());
                return name + " Actor Type: EncryptionDecorator";
            case "LambdaDeco":
                System.out.println("ESTAMOS CREANDO UN LambdaDecorator de nombre " + name);
                newActor = ActorContext.spawnActor((new LambdaFirewallDecorator(new Actor(name), x -> x.getMsg() != null)).getActor());
                return name + " Actor Type: LambdaFirewallDecorator";
            default:
                System.out.println("ALGO HA FALLADO");
                break;
        }
        return null;
    }

    public String[] returnNames(DefaultListModel<String> listActor) {
        String[] ret = new String[listActor.size()];
        for (int i = 0; i < listActor.size(); i++) {
            ret[i] = listActor.get(i);
        }
        return ret;
    }

    public void crearActor(String text, String action, int numRing, DefaultListModel<String> listActor) {
        ActorProxy newActor;
        switch (action) {
            case "RingActor":
                if (numRing > 1) {
                    ActorProxy ringArray[] = new ActorProxy[numRing];
                    for (int i = 0; i < numRing; i++) {
                        String name = text + i;
                        ringArray[i] = ActorContext.spawnActor(new RingActor(name));
                        listActor.addElement(name + " Actor Type: RingActor");
                    }

                    for (int i = 1; i < numRing; i++) {
                        ringArray[i - 1].getRingActor().linkActor(ringArray[i].getRingActor());
                    }
                    ringArray[numRing - 1].getRingActor().linkActor(ringArray[0].getRingActor());
                }else if (numRing == 1){
                    newActor = ActorContext.spawnActor(new RingActor(text));
                    listActor.addElement(text + " Actor Typer: RingActor");
                }else{
                    System.out.println("numero invalido");
                }
                break;
            case "PingPong":
                ActorProxy ping1 = ActorContext.spawnActor(new PingPongActor(text+"1"));
                ActorProxy ping2 = ActorContext.spawnActor(new PingPongActor(text+"2"));
                ping2.getPingPongActor().setPareja(ping1.getPingPongActor());
                ping1.getPingPongActor().setPareja(ping2.getPingPongActor());
                listActor.addElement(text+"1 Actor Typer PingPong");
                listActor.addElement(text+"2 Actor Typer PingPong");
                break;

            case "InsultActor":
                ProxyClient insult = ActorContext.spawnProxy(new InsultActor(text));
                listActor.addElement(text + " Actor Typer Insult with ProxyClient");
                break;

            default:
                System.out.println("ALGO HA FALLADO");
                break;
        }
    }

    public void enviarMensaje(String actor, String msg, String action) {
        ActorInterface newActor;
        switch (action) {
            case "Message":
                newActor = ac.lookup(actor);
                newActor.send(new Message(sender,msg));
                break;
            case "AddInsultMessage":
                newActor = ac.lookup(actor);
                newActor.send(new AddInsultMessage(sender,msg));
                break;

            case "GetInsultMessage":
                newActor = ac.lookup(actor);
                newActor.send(new GetInsultMessage(sender,msg));
                break;
            case "GetAllInsult":
                newActor = ac.lookup(actor);
                newActor.send(new GetAllInsultsMessage(sender,msg));
                break;
            case "AddClosureMessage":
                newActor = ac.lookup(actor);
                newActor.send(new AddClosureMessage(x-> x.getMsg().equals(msg)));
                break;

            default:
                System.out.println("ALGO HA FALLADO");
                break;
        }
    }
}
