package com.hiru96.ledgerflex.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@Setter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EXPENSE")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "AMOUNT", nullable = false)
    private Long amount;
    @JsonIgnore
    @JoinColumn(name = "EXPENSE_CATEGORY_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne
    private ExpenseCategory expenseCategory;
    @JsonIgnore
    @JoinColumn(name = "TRANSACTION_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne
    private Transaction transaction;
}
