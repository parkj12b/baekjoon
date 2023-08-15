import java.io.*;
import java.util.*;

public class Main {

    static int[] daysMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] today = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dDay = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int todayYear = today[0];
        int todayMonth = today[1];
        int todayDay = today[2];
        int dDayYear = dDay[0];
        int dDayMonth = dDay[1];
        int dDayDay = dDay[2];
        if(dDayYear - todayYear > 1000 || (dDayYear - todayYear == 1000 && dDayMonth - todayMonth > 0) || (dDayYear - todayYear == 1000 && dDayMonth - todayMonth == 0 && dDayDay >= todayDay)){
            System.out.println("gg");
        } else {
            int diff = convertToDays(dDayYear, dDayMonth, dDayDay) - convertToDays(todayYear, todayMonth, todayDay);
            System.out.println("D-"+ diff);
        }
        
        // int diff = convertToDays(2009, 1, 1) - convertToDays(2008, 12, 31);

        
    }
    
    static int convertToDays(int year, int month, int day){
        year -= 1;
        int years = year*365;
        int yDay = years + year/4 - year / 100 + year/400;
        int monthTotal = 0;
        year+=1;
        for(int i = 1; i < month; i++){
            if(i == 2){
                if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
                    yDay += daysMonth[i] + 1;
                } else {
                    yDay += daysMonth[i];
                }
            } else {
                yDay += daysMonth[i];
            }
        }
        yDay += day;

        return yDay;

    }

}