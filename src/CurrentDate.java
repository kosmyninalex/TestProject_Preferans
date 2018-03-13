import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDate {
        public static String getDate () {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            System.out.println();
            return dtf.format(now);
        }
}
