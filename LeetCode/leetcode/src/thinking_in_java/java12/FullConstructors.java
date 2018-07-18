package thinking_in_java.java12;

/**
 * Created by Administrator on 2018/5/15.
 */

class MyExcption extends Exception{
    public MyExcption(){}
    public MyExcption(String msg){
        super(msg);
    }
}

public class FullConstructors {
    public static void f() throws MyExcption{
        System.out.println("Throwing MyException from f()");
        throw new MyExcption();
    }
    public static void g() throws MyExcption{
        System.out.println("Throwing MyException from g()");
        throw new MyExcption("Originated in g()");
    }

    public static void main(String[] args) {
        try{
            f();
        }catch (MyExcption e){
//            e.printStackTrace(System.out);
        }

        try {
            g();
        }catch (MyExcption e){
//            e.printStackTrace(System.out);
        }
    }
}
