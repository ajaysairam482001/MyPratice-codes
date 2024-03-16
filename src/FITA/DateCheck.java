package FITA;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCheck {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date d = sdf.parse("12-04-2024");

        //get todays date
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY,0);
        today.set(Calendar.MINUTE,0);
        today.set(Calendar.SECOND,0);

        Calendar dateToCheck = Calendar.getInstance();
        dateToCheck.setTime(d);

        System.out.println(today.getTime());
        System.out.println(dateToCheck.getTime());

        if(dateToCheck.before(today)){
            System.out.println("Attendance not allowed");
        } else if (dateToCheck.after(today)) {
            System.out.println("Present");
        }else {
            System.out.println("Present");
        }
    }
}
