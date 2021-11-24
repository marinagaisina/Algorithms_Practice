package com.marinagaisina;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MilitaryTimeConversion {
    //Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
    //s='12:01:00PM' return '12:01:00. s='12:01:00AM' return '00:01:00'

    //Input Format
    //A single string  that represents a time in 12-hour clock format (i.e.: hh:mm:ssAM or hh:mm:ssPM).
    public static void main(String[] args) throws IOException, ParseException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = bufferedReader.readLine();
//
//        String result = MilitaryTimeConversion.timeConversion(s);
//
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
        String str = "2:02:00PM";
        System.out.println(timeConversion(str));
    }
    public static String timeConversion(String s) {
        String[] sArr = s.split(":");
        String hoursString = sArr[0];
        String minutesString = sArr[1];
        String secondsString = sArr[2];
        int h = Integer.parseInt(hoursString);
        if (s.contains("PM")) {
            if (h != 12) {
                h = h + 12;
            }
        } else if(h==12) {
            h = 0;
        }
        hoursString = String.format("%02d",h);
        secondsString = secondsString.substring(0,2);
        secondsString = String.format("%2s",secondsString);
        return hoursString+":"+minutesString+":"+secondsString;
    }
}
//Date/time pattern of input date (12 Hours format - hh used for 12 hours)
//DateFormat string12H = new SimpleDateFormat("hh:mm:ssaa");

//Date/time pattern of desired output date (24 Hours format HH - Used for 24 hours)
//DateFormat string24H = new SimpleDateFormat("HH:mm:ss");

//Returns Date object
//Date date = string12H.parse(s);

//old date format to new date format
//String output = null;
//output = string24H.format(date);
//System.out.println(output);

//return output;

//        y   = year   (yy or yyyy)
//        M   = month  (MM)
//        d   = day in month (dd)
//        h   = hour (0-12)  (hh)
//        H   = hour (0-23)  (HH)
//        m   = minute in hour (mm)
//        s   = seconds (ss)
//        S   = milliseconds (SSS)
//        z   = time zone  text        (e.g. Pacific Standard Time...)
//        Z   = time zone, time offset (e.g. -0800)



//        yyyy-MM-dd           (2009-12-31)
//
//        dd-MM-YYYY           (31-12-2009)
//
//        yyyy-MM-dd HH:mm:ss  (2009-12-31 23:59:59)
//
//        HH:mm:ss.SSS         (23:59.59.999)
//
//        yyyy-MM-dd HH:mm:ss.SSS   (2009-12-31 23:59:59.999)
//
//        yyyy-MM-dd HH:mm:ss.SSS Z   (2009-12-31 23:59:59.999 +0100)