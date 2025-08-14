import java.io.*;
import java.util.*;

public class Nandita{
   public static void main(String args[]) throws FileNotFoundException{
      
      Scanner scan = new Scanner(new File("nandita.dat")); 
   
      while (scan.hasNextLine()){
         
         if (scan.hasNext()){
            String month = scan.next(); 
            String monthInNum = "";
            if (month.equals("JANUARY")){
               monthInNum = "01";
            }
            if (month.equals("FEBRUARY")){
               monthInNum = "02";
            }
            if (month.equals("MARCH")){
               monthInNum = "03";
            }
            if (month.equals("APRIL")){
               monthInNum = "04";
            }
            if (month.equals("MAY")){
               monthInNum = "05";
            }
            if (month.equals("JUNE")){
               monthInNum = "06";
            }
            if (month.equals("JULY")){
               monthInNum = "07";
            }
            if (month.equals("AUGUST")){
               monthInNum = "08";
            }
            if (month.equals("SEPTEMBER")){
               monthInNum = "09";
            }
            if (month.equals("OCTOBER")){
               monthInNum = "10";
            }
            if (month.equals("NOVEMBER")){
               monthInNum = "11";
            }
            if (month.equals("DECEMBER")){
               monthInNum = "12";
            }
         
         //if charat(x) == "" --> read x+1
            String date = scan.next();
            date = date.substring(0, date.length()-1);
            if (Integer.valueOf(date) < 10){
               date = "0" + date;
            }
            int year = scan.nextInt();
            String cutYear = (Integer.toString(year)).substring(2);
         
            System.out.println(monthInNum + "/" + date + "/" + cutYear);
            System.out.println(date + "." + monthInNum + "." + year);
            System.out.println(year + "-" + monthInNum + "-" + date);
            System.out.println("=====");
         }
      }   
   }
}

//APRIL 15, 2018
//DECEMBER 7, 1941
//SEPTEMBER 11, 2001
