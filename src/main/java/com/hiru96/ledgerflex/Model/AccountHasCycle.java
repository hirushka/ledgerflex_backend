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
@Table(name = "ACCOUNT_HAS_CYCLE")
public class AccountHasCycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @JsonIgnore
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne
    private Account account;
    @JsonIgnore
    @JoinColumn(name = "CYCLE_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne
    private Cycle cycle;
}
