import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object target;
    private ActorInterface actor;

    private DynamicProxy(Object target, ActorInterface actor){
        this.target = target;
        this.actor = actor;
    }

    public static Object intercept(Object target, ActorInterface actor){
        return java.lang.reflect.Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DynamicProxy(target,actor)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Hola, voy a enviar un msj: ");
        actor.send(new Message(new InsultActor(),"Idiota"));
        Object result = method.invoke(target, args);
        return result;
    }
}
