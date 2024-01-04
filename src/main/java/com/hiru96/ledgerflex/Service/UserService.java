package com.hiru96.ledgerflex.Service;

import java.util.List;

import com.hiru96.ledgerflex.Model.User;
import com.hiru96.ledgerflex.Payloads.UserDto;

public interface UserService {

	List<UserDto> getAllUsers();
	UserDto findUserByUsername(String username);
	UserDto saveUser(User user);
	UserDto updateUser(UserDto userDto);
}
