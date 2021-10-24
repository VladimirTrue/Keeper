package entity;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Period {


    private long id;
    private long userId;
    private String periodName;
    private LocalDate startDate;
    private LocalDate endDate;


    private List<IncomeForPeriod> incomesList;
    private List<ExpenseForPeriod> expensesList;
    private List<Day> dayList;

    public Period() {
    }

    public Period(long userId, String periodName, LocalDate startDate, LocalDate endDate) {
        this.userId = userId;
        this.periodName = periodName;
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

    //TODO почитать как это сделать через интрерфейс и дженерик
    private void changeIncome(IncomeForPeriod incomeForPeriod, String name, BigDecimal income) {
        IncomeForPeriod currIncomeForPeriod = incomesList.get(incomesList.indexOf(incomeForPeriod));
        currIncomeForPeriod.setCategoryName(name);
        currIncomeForPeriod.setIncome(income);
        incomesList.remove(incomeForPeriod);
        incomesList.add(currIncomeForPeriod);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<IncomeForPeriod> getIncomesList() {
        return incomesList;
    }

    public void setIncomesList(List<IncomeForPeriod> incomesList) {
        this.incomesList = incomesList;
    }

    public List<ExpenseForPeriod> getExpensesList() {
        return expensesList;
    }

    public void setExpensesList(List<ExpenseForPeriod> expensesList) {
        this.expensesList = expensesList;
    }

    public List<Day> getDayList() {
        return dayList;
    }

    public void setDayList(List<Day> dayList) {
        this.dayList = dayList;
    }
}
