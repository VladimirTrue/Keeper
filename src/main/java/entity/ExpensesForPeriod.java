package entity;

import java.math.BigDecimal;
import java.util.Map;

public class ExpensesForPeriod {

    private String periodName;
    //K - категория обязательного расхода V - значение
    private Map<String, BigDecimal> expensesMap;

    public ExpensesForPeriod(String periodName, Map<String, BigDecimal> expensesMap) {
        this.periodName = periodName;
        this.expensesMap = expensesMap;
    }
}
