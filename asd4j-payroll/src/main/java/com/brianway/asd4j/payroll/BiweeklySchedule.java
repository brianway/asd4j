package com.brianway.asd4j.payroll;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by brian on 16/12/27.
 */
public class BiweeklySchedule implements PaymentSchedule {

    private static final Set<Date> paydates = calculateBiWeeklyPayDates();
    private static final int DAYS_OF_TWO_WEEKS = 14;

    @Override
    public boolean isPayday(Date payDate) {
        return paydates.contains(payDate);
    }

    @Override
    public Date getPayPeriodStartDate(Date payDate) {
        return DateHelper.subtractDays(payDate, DAYS_OF_TWO_WEEKS - 1);
    }

    // TODO: this only works from 1950 - 2050, need to calculate more dates for a payday outside that range
    private static Set<Date> calculateBiWeeklyPayDates() {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(1950, Calendar.JANUARY, 6);//Friday

        Set<Date> paydates = new HashSet<Date>();
        // 100 years,about 5200 weeks
        for (int i = 0; i < 2610; i++) {
            paydates.add(cal.getTime());
            cal.add(Calendar.DATE, DAYS_OF_TWO_WEEKS);
        }
        return paydates;
    }

}
