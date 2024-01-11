package com.hiru96.ledgerflex.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hiru96.ledgerflex.Model.Enum.ECycleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CYCLE")
public class Cycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "CYCLE_TYPE", nullable = false)
    private ECycleType cycleType;
    @Column(name ="IS_ACTIVE", nullable = false)
    private Boolean isActive;
    @Column(name="START_DATE", nullable = false)
    private Date startDate;
    @Column(name = "END_DATE", nullable = false)
    private Date endDate;
    @JsonIgnore
    @OneToMany(mappedBy = "cycle", fetch = FetchType.LAZY)
    private List<AccountHasCycle> accountHasCycles = new ArrayList<>();

}

