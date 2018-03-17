import java.io.*;
public class Logging {
   // private static int eventID = 0;
    private static String fileName = "log.txt";
    public static void logEvent (String s)
    {
        String res = "TEST_preferans " +  CurrentDate.getDate() + ". Event: " + s;

        try {
            PrintWriter fileOutputStream = new PrintWriter(new FileOutputStream(new File(fileName), true));
            fileOutputStream.write(res + "\r\n");
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println ("Something bad has happened in our logger");
            e.printStackTrace();
        }

        System.out.println (res);


    }
}

//Class with logging method that prints String argument to constole and append its as a new line to the end of flie