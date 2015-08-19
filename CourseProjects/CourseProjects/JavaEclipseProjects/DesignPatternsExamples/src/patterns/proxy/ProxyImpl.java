package patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyImpl implements InvocationHandler {

    private double add(double p1, double p2) {
        return p1+p2;
    }
    private double subtract(double p1, double p2) {
        return p1-p2;
    }
    private double multiply(double p1, double p2) {
        return p1*p2;
    }
    private double divide(double p1, double p2) {
        return p1/p2;
    }
    private double calculateVat(double amt) {
        return (amt/100) * 17.5;
    }
    private double calculateTax(double amt) {
        return (amt/100) * 20;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        if(method.getDeclaringClass() == Finance.class) {
            return processFinanceMethod(args, name);
        } else {
	        return processMathMethod(args, name);
        } 
    }
    private Object processMathMethod(Object[] args, String name) {
        double paramOne = ((Double)args[0]).doubleValue();
        double paramTwo = ((Double)args[1]).doubleValue();
        if(name.equals("add")) {
            return new Double(add(paramOne,paramTwo));
        } else if(name.equals("subtract")) {
            return new Double(subtract(paramOne,paramTwo));
        } else if(name.equals("multiply")) {
            return new Double(multiply(paramOne,paramTwo));
        } else if(name.equals("divide")) {
            return new Double(divide(paramOne,paramTwo));
        } else {
            return null;
        }
    }
    private Object processFinanceMethod(Object[] args, String name) {
        double paramOne = ((Double)args[0]).doubleValue();
        if(name.equals("calculateVat")) {
            return new Double(calculateVat(paramOne));
        } else if(name.equals("calculateTax")) {
            return new Double(calculateTax(paramOne));
        } else {
            return null;
        }
    }
}
