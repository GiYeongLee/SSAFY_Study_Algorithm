import java.time.*;

public class test {

	public static void main(String[] args) {		
		LocalDate now = LocalDate.now();
		
		int year = now.getYear();
		int month = now.getMonthValue();
		
		int[] dates = {31, ((year % 4 == 0) && (year % 100 != 0) || (year % 400) == 0  ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		System.out.println(dates[month - 1]);
	}
}
