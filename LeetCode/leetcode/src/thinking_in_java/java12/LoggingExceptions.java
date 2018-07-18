package thinking_in_java.java12;

import sun.rmi.runtime.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2018/5/15.
 */
class LoggingException extends Exception{
//    private static Logger logger = Logger.getLogger("loggingException");

    private static final String TAG = "loggingException";
    public LoggingException() {

    }

    @Override
    public String toString() {
        return TAG;
    }
}
public class LoggingExceptions {
    public static void main(String[] args){
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
                e.printStackTrace();
        }
    }
}
