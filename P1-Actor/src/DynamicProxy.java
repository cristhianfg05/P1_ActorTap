import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object target;
    private ActorInterface actor;

    /**
     * DinamicProxy Constructor
     *
     * @param target
     * @param actor
     */
    private DynamicProxy(Object target, ActorInterface actor){
        this.target = target;
        this.actor = actor;
    }

    /**
     * NAHUEL EXPLICA QUE PASA AQUI
     *
     * @param target
     * @param actor
     * @return
     */
    public static Object intercept(Object target, ActorInterface actor){
        return java.lang.reflect.Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DynamicProxy(target,actor)
        );
    }

    /**
     * @param proxy  the proxy instance that the method was invoked on
     * @param method the {@code Method} instance corresponding to
     *               the interface method invoked on the proxy instance.  The declaring
     *               class of the {@code Method} object will be the interface that
     *               the method was declared in, which may be a superinterface of the
     *               proxy interface that the proxy class inherits the method through.
     * @param args   an array of objects containing the values of the
     *               arguments passed in the method invocation on the proxy instance,
     *               or {@code null} if interface method takes no arguments.
     *               Arguments of primitive types are wrapped in instances of the
     *               appropriate primitive wrapper class, such as
     *               {@code java.lang.Integer} or {@code java.lang.Boolean}.
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Hola, voy a enviar un msj: ");
        actor.send(new Message(new InsultActor("Insult Example"),"Idiota"));
        Object result = method.invoke(target, args);
        return result;
    }
}
