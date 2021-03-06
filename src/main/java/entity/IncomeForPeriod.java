package entity;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
public class IncomeForPeriod {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "categoryName")
    private String categoryName;
    @Column(name = "income")
    private BigDecimal income;

    public IncomeForPeriod(String categoryName, BigDecimal income) {
        this.categoryName = categoryName;
        this.income = income;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }
}
