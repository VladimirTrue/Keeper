package entity;

import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.LocalDate;

import java.math.BigDecimal;

public class Day {
    private LocalDate date;
    private Spend totalSpend;
    private BigDecimal budgedForDay;
    private BigDecimal saldo;
    private BigDecimal balance;

    public Day(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("Day = {date = %s, totalSpend = %s, budgedForDay = %s, saldo = %s balance = %s}",
                date, totalSpend, budgedForDay,saldo, balance);
    }
}
