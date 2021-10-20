package entity;

import org.joda.time.Instant;

import javax.persistence.Entity;
import java.math.BigDecimal;


public class Spend {
    private Instant dayOfSpend;
    private String category;
    private BigDecimal expense;

    public Spend(Instant dayOfSpend, String category, BigDecimal expense) {
        this.dayOfSpend = dayOfSpend;
        this.category = category;
        this.expense = expense;
    }
}
