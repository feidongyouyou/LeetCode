package thinking_in_java.java12;

/**
 * Created by Administrator on 2018/5/15.
 */

class SimpleException extends Exception{}

public class InheritingExceptions {
    public void f() throws SimpleException{
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        }catch (SimpleException e){
            System.out.println("Caught it!");
        }
    }
}
