package com.hiru96.ledgerflex.Payloads;

import com.hiru96.ledgerflex.Model.Enum.ERole;
import lombok.Data;


@Data
public class UserDto {

    private Long id;
    private String name;
    private String username;
    private String email ;
    private ERole role;
}
