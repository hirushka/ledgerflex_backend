package com.hiru96.ledgerflex.ServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiru96.ledgerflex.Exceptions.ResourceNotFoundException;
import com.hiru96.ledgerflex.Model.User;
import com.hiru96.ledgerflex.Payloads.UserDto;
import com.hiru96.ledgerflex.Repo.UserRepo;
import com.hiru96.ledgerflex.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepo usrRepo;

    private final ObjectMapper objectMapper;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> allUsrList = usrRepo.findAll();
        List<UserDto> userLs = new ArrayList<>();
        return allUsrList.stream().map(user -> {
            return objectMapper.convertValue(user, UserDto.class);
        }).collect(Collectors.toList());

    }

    @Override
    public UserDto findUserByUsername(String username) {

        Optional<User> us = usrRepo.findByUsername(username);
        if (us.isPresent()) {
            return objectMapper.convertValue(us.get(), UserDto.class);
        } else {
            throw new ResourceNotFoundException("User", "username", username);
        }

    }

    @Override
    public UserDto saveUser(User user) {
        return objectMapper.convertValue(usrRepo.save(user), UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = objectMapper.convertValue(userDto, User.class);
        Optional<User> optionalUser = usrRepo.findById(user.getId());
        if (optionalUser.isPresent()) {
            user.setPassword(optionalUser.get().getPassword());
            return objectMapper.convertValue(usrRepo.save(user), UserDto.class);
        }
        throw new ResourceNotFoundException("User","id",userDto.getId());
    }


}
