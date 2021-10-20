package entity;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Period {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "startDate")
    private LocalDate startDate;
    @Column(name = "endDate")
    private LocalDate endDate;
    @Transient
    private List<IncomeForPeriod> incomesList;
    @Transient
    private List<ExpenseForPeriod> expensesList;
    @Transient
    private List<Day> dayList;

    public Period() {
    }

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

    //TODO почитать как это сделать через интрерфейс и дженерик
    private void changeIncome(IncomeForPeriod incomeForPeriod, String name, BigDecimal income) {
        IncomeForPeriod currIncomeForPeriod = incomesList.get(incomesList.indexOf(incomeForPeriod));
        currIncomeForPeriod.setCategoryName(name);
        currIncomeForPeriod.setIncome(income);
        incomesList.remove(incomeForPeriod);
        incomesList.add(currIncomeForPeriod);
    }

    private void changeIncome(IncomeForPeriod incomeForPeriod,BigDecimal income) {
        IncomeForPeriod currIncomeForPeriod = incomesList.get(incomesList.indexOf(incomeForPeriod));
        currIncomeForPeriod.setIncome(income);
        incomesList.remove(incomeForPeriod);
        incomesList.add(currIncomeForPeriod);
    }

    private void changeIncome(IncomeForPeriod incomeForPeriod, String name) {
        IncomeForPeriod currIncomeForPeriod = incomesList.get(incomesList.indexOf(incomeForPeriod));
        currIncomeForPeriod.setCategoryName(name);
        incomesList.remove(incomeForPeriod);
        incomesList.add(currIncomeForPeriod);
    }


    private void changeExpense(ExpenseForPeriod expenseForPeriod, String name, BigDecimal expense) {
        ExpenseForPeriod currExpenseForPeriod = expensesList.get(incomesList.indexOf(expenseForPeriod));
        currExpenseForPeriod.setCategoryName(name);
        currExpenseForPeriod.setExpense(expense);
        expensesList.remove(expenseForPeriod);
        expensesList.add(currExpenseForPeriod);
    }

    private void changeExpense(ExpenseForPeriod expenseForPeriod, String name) {
        ExpenseForPeriod currExpenseForPeriod = expensesList.get(incomesList.indexOf(expenseForPeriod));
        currExpenseForPeriod.setCategoryName(name);
        expensesList.remove(expenseForPeriod);
        expensesList.add(currExpenseForPeriod);
    }

    private void changeExpense(ExpenseForPeriod expenseForPeriod, BigDecimal expense) {
        ExpenseForPeriod currExpenseForPeriod = expensesList.get(incomesList.indexOf(expenseForPeriod));
        currExpenseForPeriod.setExpense(expense);
        expensesList.remove(expenseForPeriod);
        expensesList.add(currExpenseForPeriod);
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

    public List<ExpenseForPeriod> getExpensesList() {
        return expensesList;
    }

    public List<Day> getDayList() {
        return dayList;
    }
}
