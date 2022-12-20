import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object target = null;
    public static Object newInstance(Object target){

        Class targetClass = target.getClass();
        Class interfaces[] = targetClass.getInterfaces();
        return Proxy.newProxyInstance(targetClass.getClassLoader(), interfaces,
                new DynamicProxy(target));
    }

    private DynamicProxy (Object target){
        this.target = target;
    }
    Object invocationResult = null;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            System.out.println("Before method " + method.getName());
            invocationResult = method.invoke(this.target, args);
            System.out.println("After method " + method.getName());
        } catch (InvocationTargetException ite) {
            //this is the exception thrown by method being invoked
            //we just rethrow the wrapped exception to conform the interface
            throw ite.getTargetException();
        } catch (Exception e) {
            System.err.println("Invocation of " + method.getName() + " failed.");
            System.err.println(e.getMessage());
        } finally {
            return invocationResult;
        }
    }
}
