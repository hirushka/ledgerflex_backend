package com.hiru96.ledgerflex.Controller;

import java.security.PublicKey;
import java.util.List;

import com.hiru96.ledgerflex.Payloads.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.hiru96.ledgerflex.Model.User;
import com.hiru96.ledgerflex.Service.UserService;

@RestController
@RequestMapping("/api/ledgerflex")
@CrossOrigin(origins = "localhost", maxAge = 3600)

@Transactional
@RequiredArgsConstructor
public class UserController {

	private final UserService usrService;
	
	@GetMapping("/getAll")
	List<UserDto> getAllUsers(){
		List<UserDto> allUsrList = usrService.getAllUsers();
		return allUsrList;
	}
	
	@GetMapping("/get/{username}")
	UserDto findTheUserByUsername(@PathVariable (value = "username") String username) {
		return usrService.findUserByUsername(username);
	}

	@PutMapping("/update")
	UserDto updateUser(@RequestBody UserDto userDto){
		return usrService.updateUser(userDto);
	}
}
