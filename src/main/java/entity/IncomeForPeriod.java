package entity;

import org.joda.time.LocalDate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class IncomeForPeriod {

    private String periodName;
    //K - категория дохода V - значение
    private Map<String, BigDecimal> incomeMap;

    public IncomeForPeriod(String periodName, Map<String, BigDecimal> incomeMap) {
        this.periodName = periodName;
        this.incomeMap = incomeMap;
    }
}
