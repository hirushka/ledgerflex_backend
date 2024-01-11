package com.hiru96.ledgerflex.Service;

import com.hiru96.ledgerflex.Model.UserDetails;
import com.hiru96.ledgerflex.Payloads.UserDetailsDto;

public interface UserDetailsService {

    UserDetailsDto saveUserDetails(UserDetails userDetails);
}
