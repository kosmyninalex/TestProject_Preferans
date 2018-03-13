import java.io.*;

/**
 * Created by Admin on 3/14/2018.
 */
public class Logging {
   // private static int eventID = 0;
    private static String fileName = "log.txt";
    public static void logEvent (String s)
    {
        String res = "TEST_preferans " +  CurrentDate.getDate() + ". Event: " + s + "\r\n";

        try {
            PrintWriter fileOutputStream = new PrintWriter(new FileOutputStream(new File(fileName), true));
            fileOutputStream.write(res);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println ("Something bad has happened in our logger");
            e.printStackTrace();
        }

        System.out.println (res);


    }
}
