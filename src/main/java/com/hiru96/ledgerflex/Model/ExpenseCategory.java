package com.hiru96.ledgerflex.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hiru96.ledgerflex.Model.Enum.EFrequency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EXPENSE_CATEGORY")
public class ExpenseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name="CATEGORY_NAME", nullable = false)
    private String CategoryName;
    @Column(name="FREQUENCY", nullable = false)
    private EFrequency frequency;
    @Column(name = "ALLOCATED_AMOUNT", nullable = false)
    private Long allocatedAmount;
    @JsonIgnore
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne
    private UserDetails user;
    @JsonIgnore
    @OneToMany(mappedBy = "expenseCategory", fetch = FetchType.LAZY)
    private List<Expense> expenseList = new ArrayList<>();
}
