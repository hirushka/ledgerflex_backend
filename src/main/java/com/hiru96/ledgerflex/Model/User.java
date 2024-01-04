package com.hiru96.ledgerflex.Model;

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
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "USERNAME", nullable = false, length = 100)
    private String username;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name="IS_ACTIVE", nullable = false)
    private Boolean isActive;
}
