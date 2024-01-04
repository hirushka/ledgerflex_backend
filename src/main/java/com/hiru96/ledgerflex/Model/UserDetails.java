package com.hiru96.ledgerflex.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hiru96.ledgerflex.Model.Enum.ERole;
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
    @Column(name="CREATED_DATE")
    @JsonIgnore
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    @OneToOne
    private User user;
}
