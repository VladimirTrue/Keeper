package entity;

import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.math.BigDecimal;

public class Day {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "totalSpend")
    private Spend totalSpend;
    @Column(name = "budgedForDay")
    private BigDecimal budgedForDay;
    @Column(name = "saldo")
    private BigDecimal saldo;
    @Column(name = "balance")
    private BigDecimal balance;

    public Day() {
    }

    public Day(LocalDate date) {
        this.date = date;
    }

    public void setTotalSpend(Spend totalSpend) {
        this.totalSpend = totalSpend;
    }

    public void setBudgedForDay(BigDecimal budgedForDay) {
        this.budgedForDay = budgedForDay;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public Spend getTotalSpend() {
        return totalSpend;
    }

    public BigDecimal getBudgedForDay() {
        return budgedForDay;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("Day = {date = %s, totalSpend = %s, budgedForDay = %s, saldo = %s balance = %s}",
                date, totalSpend, budgedForDay,saldo, balance);
    }
}
