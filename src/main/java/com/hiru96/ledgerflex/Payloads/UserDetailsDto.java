package com.hiru96.ledgerflex.Payloads;

import com.hiru96.ledgerflex.Model.Enum.ERole;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
@Data
public class UserDetailsDto {

    private String name;
    private ERole role;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
    private Integer userId;
    private Boolean isActive;
}
