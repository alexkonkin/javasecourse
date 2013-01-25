package com.globallogic.javase;

import java.io.*;
import java.util.*;

public class CalendarSeeker{
	String[] inpStrDate;
	Integer varDay;
	Integer varMonth;
	Integer varYear;
	Integer dayOfWeek;
	
	enum monthName { January(1), February(2), March(3),
						April(4), May(5), June(6), 
						July(7), August(8), September(9), 
						October(10), November(11), December(12);
					
					private int monthNumber;
					private monthName(int monthNumber) {
						this.monthNumber = monthNumber;
					}
					public int getMonthNumber() {
					return monthNumber;
					}
	}

	public CalendarSeeker(String inpDate){
		inpStrDate = inpDate.split(" "); 
	}

	public String GetNameOfTheDay(Integer varDayNum){
		String nameOfTheDay="";
		switch (varDayNum){
            case 1:  nameOfTheDay = "Monday";
                     break;
            case 2:  nameOfTheDay = "Tuesday";
                     break;
            case 3:  nameOfTheDay = "Wednesday";
                     break;
            case 4:  nameOfTheDay = "Thirsday";
                     break;
            case 5:  nameOfTheDay = "Friday";
                     break;
            case 6:  nameOfTheDay = "Saturday";
                     break;
            case 7:  nameOfTheDay = "Sunday";
                     break;
		}
		return nameOfTheDay;
	}
	
	public void DoCalculation(){
		System.out.println("debug " + Arrays.toString(inpStrDate));
		varDay = Integer.parseInt(inpStrDate[0]);
		varMonth = monthName.valueOf(inpStrDate[1]).getMonthNumber();
		varYear = Integer.parseInt(inpStrDate[2]);
		
		if( varMonth <= 2){
			varYear = varYear - 1;
			varDay = varDay + 3;
		}
		dayOfWeek =  1 + (varDay + varYear + varYear/4 - varYear/100 + varYear/400 + (31*varMonth+10)/12) % 7;
		
		System.out.println("The name of the Day is : " + GetNameOfTheDay(dayOfWeek));
		
	}
}
