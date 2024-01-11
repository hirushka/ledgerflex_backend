package com.hiru96.ledgerflex.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hiru96.ledgerflex.Model.Enum.ETransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ACCOUNT")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "TRANSACTION_DATE", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime transactionDate;
    @Enumerated
    @Column(name = "TRANSACTION_TYPE", nullable = false)
    private ETransactionType transactionType;
    @Column(name = "AMOUNT", nullable = false)
    private Long amount;
    @Column(name = "DESCRIPTION")
    private String description;
    @JsonIgnore
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne
    private Account account;
    @JsonIgnore
    @OneToMany(mappedBy = "transaction", fetch = FetchType.LAZY)
    private List<Expense> expenseList = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "transaction", fetch = FetchType.LAZY)
    private List<Income> incomeList = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        transactionDate = LocalDateTime.now();
    }
}
