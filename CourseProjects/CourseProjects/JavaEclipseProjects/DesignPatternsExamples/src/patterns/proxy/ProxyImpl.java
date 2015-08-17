package patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyImpl implements InvocationHandler {

    private double math_op1(double p1, double p2) {
        return p1+p2;
    }
    private double math_op2(double p1, double p2) {
        return p1-p2;
    }
    private double math_op3(double p1, double p2) {
        return p1*p2;
    }
    private double math_op4(double p1, double p2) {
        return p1/p2;
    }
    private double finance_op1(double amt) {
        return (amt/100) * 17.5;
    }
    private double finance_op2(double amt) {
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
            return new Double(math_op1(paramOne,paramTwo));
        } else if(name.equals("subtract")) {
            return new Double(math_op2(paramOne,paramTwo));
        } else if(name.equals("multiply")) {
            return new Double(math_op3(paramOne,paramTwo));
        } else if(name.equals("divide")) {
            return new Double(math_op4(paramOne,paramTwo));
        } else {
            return null;
        }
    }
    private Object processFinanceMethod(Object[] args, String name) {
        double paramOne = ((Double)args[0]).doubleValue();
        if(name.equals("calculateVat")) {
            return new Double(finance_op1(paramOne));
        } else if(name.equals("calculateTax")) {
            return new Double(finance_op2(paramOne));
        } else {
            return null;
        }
    }
}
