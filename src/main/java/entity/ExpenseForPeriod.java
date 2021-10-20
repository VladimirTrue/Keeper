package entity;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
public class ExpenseForPeriod {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "categoryName")
    private String categoryName;
    @Column(name = "expense")
    private BigDecimal expense;

    public ExpenseForPeriod(String categoryName, BigDecimal expense) {
        this.categoryName = categoryName;
        this.expense = expense;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getExpense() {
        return expense;
    }

    public void setExpense(BigDecimal expense) {
        this.expense = expense;
    }
}
