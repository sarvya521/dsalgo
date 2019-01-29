package algo;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TimeOfYear {

	private static final Map<Integer, String> MONTH = new HashMap<Integer, String>();
	static {
		MONTH.put(1, "JAN");
		MONTH.put(2, "FEB");
		MONTH.put(3, "MAR");
		MONTH.put(4, "APR");
		MONTH.put(5, "MAY");
		MONTH.put(6, "JUN");
		MONTH.put(7, "JUL");
		MONTH.put(8, "AUG");
		MONTH.put(9, "SEP");
		MONTH.put(10, "OCT");
		MONTH.put(11, "NOV");
		MONTH.put(12, "DEC");
		
	}
	
	private static final Map<Integer, Integer> MONTH_DAYS = new HashMap<Integer, Integer>();
	static {
		MONTH_DAYS.put(1, 31);
		MONTH_DAYS.put(2, 28);
		MONTH_DAYS.put(3, 31);
		MONTH_DAYS.put(4, 30);
		MONTH_DAYS.put(5, 31);
		MONTH_DAYS.put(6, 30);
		MONTH_DAYS.put(7, 31);
		MONTH_DAYS.put(8, 31);
		MONTH_DAYS.put(9, 30);
		MONTH_DAYS.put(10, 31);
		MONTH_DAYS.put(11, 30);
		MONTH_DAYS.put(12, 31);
		
	}
	
	private static final Map<Integer, String> DAY = new HashMap<Integer, String>();
	static {
		DAY.put(1, "Monday");
		DAY.put(2, "Tuesday");
		DAY.put(3, "Wednesday");
		DAY.put(4, "Thursday");
		DAY.put(5, "Friday");
		DAY.put(6, "Saturday");
		DAY.put(7, "Sunday");
	}
	
	static final long daySec = 3600*24;
	static final long weekSec = daySec*7;
	static final long yearSec = daySec*365;
	static final long leapSec = daySec*366;
	
	static final long thirtyDaySec = daySec*30;
	static final long thirtyOneDaySec = daySec*31;
	static final long twentyEightDaySec = daySec*28;
	
	static final long startYear = 1970;
	static final long startMonth = 1;
	static final long startDay = 4;
	
	static void solve(long seconds, int date, int month, int year, int day, StringBuilder builder) {
		if(seconds < daySec) {
			builder.append(String.format("%02d", date)).append("-").append(MONTH.get(month)).append("-").append(year).append(" ").append(DAY.get(day));
			return;
		}
		boolean isLeapYear = year % 4 == 0;
		if(isLeapYear && seconds >= leapSec) {
			seconds = seconds - leapSec;
			day = (day + 366)%7;
			if(day == 0) {
				day = 7;
			}
			year = year + 1;
			month = 1;
			date = 1;
		} else if(isLeapYear == false && seconds >= yearSec) {
			seconds = seconds - yearSec;
			day = (day + 365)%7;
			if(day == 0) {
				day = 7;
			}
			year = year + 1;
			month = 1;
			date = 1;
		} else {
			int days = MONTH_DAYS.get(month);
			if(isLeapYear && month == 2) {
				days = 29;
			}
			if((seconds - (days*daySec)) >= 0) {
				seconds = seconds - (days*daySec);
				month = month + 1;
				date = 1;
				day = (day + days)%7;
				if(day == 0) {
					day = 7;
				}
			} else if(seconds >= daySec) {
				seconds = seconds - daySec;
				date = date + 1;
				day = day + 1;
				if(day == 8) {
					day = 1;
				}
			}
		}
		solve(seconds, date, month, year, day, builder);
	}
	
	public static void main(String[] args) {
		long seconds = 978284504;//System.currentTimeMillis()/1000;
		int date=1;
		int month=1;
		int year=1970;
		int day=4;
		StringBuilder builder = new StringBuilder();
		solve(seconds, date, month, year, day, builder);
		System.out.println(builder);
	}
}
