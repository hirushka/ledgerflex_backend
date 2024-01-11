package com.hiru96.ledgerflex.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hiru96.ledgerflex.Model.Enum.ECycleType;
import com.hiru96.ledgerflex.Model.Enum.ERole;
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
@Table(name = "USERS_DETAILS")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;
    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;
    @Enumerated
    @Column(name = "ROLE")
    private ERole role;
    @Column(name="CREATED_DATE", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
    @JsonIgnore
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    @OneToOne
    private User user;
    @Column(name="IS_ACTIVE", nullable = false)
    private Boolean isActive;
    @Enumerated
    @Column(name = "CYCLE_TYPE")
    private ECycleType eCycleType;
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<IncomeCategory> incomeCategories = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<ExpenseCategory> expenseCategories = new ArrayList<>();
    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }
}
