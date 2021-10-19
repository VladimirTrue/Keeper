package entity;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class Period {

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<IncomeForPeriod> incomesList;
    private List<ExpensesForPeriod> expensesList;
    private List<Day> dayList;

    public Period(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.incomesList = new ArrayList<>();
        this.expensesList = new ArrayList<>();
        int daysBetween = Days.daysBetween(this.startDate, this.endDate).getDays();
        this.dayList = new ArrayList<>();
        this.dayList.add(new Day(startDate));
        for (int i = 1; i <= daysBetween; i++) {
            this.dayList.add(new Day(startDate.plusDays(i)));
        }
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getName() {
        return name;
    }

    public List<IncomeForPeriod> getIncomesList() {
        return incomesList;
    }

    public List<ExpensesForPeriod> getExpensesList() {
        return expensesList;
    }

    public List<Day> getDayList() {
        return dayList;
    }
}
