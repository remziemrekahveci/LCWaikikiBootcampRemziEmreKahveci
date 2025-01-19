package utilities;

import java.util.logging.Logger;

public class Log {

    /*explaining the ...*/

    //Initialize Log4j instance
    private static final Logger Log = Logger.getLogger(Log.class.getName());

    //We can use it when starting tests
    public static void startLog (String testClassName){
        Log.info("Test is Starting...");
        System.out.println("Starting");
    }

    //We can use it when ending tests
    public static void endLog (String testClassName){
        Log.info("Test is Ending...");
    }

    //Info Level Logs
    public static void info (String message) {
        Log.info(message);
    }

    //Warn Level Logs
    public static void warn (String message) {
        Log.warning(message);
    }

    //Error Level Logs
    public static void error (String message) {
        final String message1 = message;
    }

}
