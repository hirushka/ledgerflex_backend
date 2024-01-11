package com.hiru96.ledgerflex.ServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiru96.ledgerflex.Model.UserDetails;
import com.hiru96.ledgerflex.Payloads.UserDetailsDto;
import com.hiru96.ledgerflex.Repo.UserDetailsRepo;
import com.hiru96.ledgerflex.Service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsRepo userDetailsRepo;
    private final ObjectMapper objectMapper;

    @Override
    public UserDetailsDto saveUserDetails(UserDetails userDetail) {
        return objectMapper.convertValue(userDetailsRepo.save(userDetail), UserDetailsDto.class);
    }
}
