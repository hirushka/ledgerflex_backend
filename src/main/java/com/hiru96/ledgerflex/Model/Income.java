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
@Table(name = "INCOME")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "AMOUNT", nullable = false)
    private Long amount;
    @JsonIgnore
    @JoinColumn(name = "INCOME_CATEGORY_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne
    private IncomeCategory incomeCategory;
    @JsonIgnore
    @JoinColumn(name = "TRANSACTION_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne
    private Transaction transaction;


}
