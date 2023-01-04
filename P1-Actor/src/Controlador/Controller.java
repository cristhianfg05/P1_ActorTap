package Controlador;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Controller {

    public Controller(){}

    /**CREACIONES PARA LAS SIMULACIONES VISTA 1**/
    ActorContext ac = ActorContext.getInstance();
    ActorProxy targetEnc = ActorContext.spawnActor((new EncryptionDecorator(new Actor("enc"))).getActor());
    ActorProxy sender = ActorContext.spawnActor((new FirewallDecorator((new EncryptionDecorator(new Actor("a"))).getActor())).getActor());
    ActorProxy target = ActorContext.spawnActor((new FirewallDecorator(new Actor("b"))).getActor()); // new Model.EncryptionDecorator()
    ActorProxy target1 = ActorContext.spawnActor((new EncryptionDecorator((new FirewallDecorator(new Actor("c"))).getActor())).getActor());
    ActorProxy target2 = ActorContext.spawnActor((new FirewallDecorator(new Actor("d"))).getActor());
    ActorProxy lambaDecorator = ActorContext.spawnActor((new LambdaFirewallDecorator(new Actor("f"), x -> x.getMsg() != null)).getActor());

    public void simulacio1(String msg, String tipus){
        switch(tipus){
            case "RingActor":
                System.out.println("SIMULANDO RING ACTOR");
                ActorProxy ringArray[] = new ActorProxy[10];
                for (int i = 0; i < 10; i++){
                    String name = "Ring "+i;
                    ringArray[i] = ActorContext.spawnActor(new RingActor(name));
                }

                for (int i = 1; i < 10; i++){
                    ringArray[i-1].getRingActor().linkActor(ringArray[i].getRingActor());
                }
                ringArray[9].getRingActor().linkActor(ringArray[0].getRingActor());

                ringArray[0].send(new Message(ringArray[9], msg));
                break;
            case "PingPongActor":
                System.out.println("SIMULANDO PING PONG ACTOR");
                ActorProxy ping1 = ActorContext.spawnActor(new PingPongActor("PingPong 1"));
                ActorProxy ping2 = ActorContext.spawnActor(new PingPongActor("PingPong 2"));
                ping2.getPingPongActor().setPareja(ping1.getPingPongActor());
                ping1.getPingPongActor().setPareja(ping2.getPingPongActor());
                ping2.send(new Message(ping1,msg));
                break;
            case "Encrypt":
                System.out.println("SIMULANDO ENCRYPT/DECRYPT");
                targetEnc.send(new Message(sender, msg));
                break;
            case "Decorator":
                System.out.println("SIMULANDO ACTOR DECORATOR");
                target.send(new Message(sender,"hola que tal"));
                break;
            case "DecoEncrypt":
                System.out.println("SIMULANDO ENCRYPT/DECRYPT + ACTOR DECORATOR");
                target1.send(new Message(sender, msg));
                break;
            default:
                System.out.println("ESTO ESTA MAL");
                break;
        }
    }

    public void simulacio2(String msg, String predicate){
        System.out.println("P: "+predicate+ " msg: "+msg);
        if(predicate.equals("")){
            lambaDecorator.send(new Message(target2,msg));
        }else{
            lambaDecorator.send(new AddClosureMessage(x-> x.getMsg().equals(predicate)));
            lambaDecorator.send(new Message(target2,msg));
        }
    }


}
