package TH10;

import java.util.Calendar;
import java.util.Date;

public class Age {

	int years = 0;
	int months = 0;
	int days = 0;
	int hours = 0;
	int mins = 0;

	public Age(Date birthDay) {
		super();

		Calendar birthDayCal = Calendar.getInstance();
		birthDayCal.setTimeInMillis(birthDay.getTime());

		Calendar currDay = Calendar.getInstance();

		this.years = currDay.get(Calendar.YEAR)
				- birthDayCal.get(Calendar.YEAR);

		int currMonth = currDay.get(Calendar.MONTH) + 1;
		int birthMonth = birthDayCal.get(Calendar.MONTH) + 1;

		// Get difference between months
		this.months = currMonth - birthMonth;

		// if month difference is in negative then reduce years by one and
		// calculate the number of months.
		if (this.months < 0) {
			this.years--;

			this.months = 12 - birthMonth + currMonth;

			if (currDay.get(Calendar.DATE) < birthDayCal.get(Calendar.DATE))
				this.months--;
		} else if (this.months == 0
				&& currDay.get(Calendar.DATE) < birthDayCal.get(Calendar.DATE)) {
			this.years--;
			this.months = 11;
		}

		// Calculate the days
		if (currDay.get(Calendar.DATE) > birthDayCal.get(Calendar.DATE))
			this.days = currDay.get(Calendar.DATE) - birthDayCal.get(Calendar.DATE);
		else if (currDay.get(Calendar.DATE) < birthDayCal.get(Calendar.DATE)) {
			int today = currDay.get(Calendar.DAY_OF_MONTH);
			currDay.add(Calendar.MONTH, -1);
			this.days = currDay.getActualMaximum(Calendar.DAY_OF_MONTH)
					- birthDayCal.get(Calendar.DAY_OF_MONTH) + today;
		} else {
			this.days = 0;
			if (this.months == 12) {
				this.years++;
				this.months = 0;
			}
		}
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMins() {
		return mins;
	}

	public void setMins(int mins) {
		this.mins = mins;
	}

}
