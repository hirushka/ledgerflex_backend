package com.hiru96.ledgerflex.Controller;


import com.hiru96.ledgerflex.Model.Enum.ERole;
import com.hiru96.ledgerflex.Payloads.*;
import com.hiru96.ledgerflex.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hiru96.ledgerflex.Model.User;
import com.hiru96.ledgerflex.Repo.UserRepo;
import com.hiru96.ledgerflex.Security.JwtTokenProvider;

import javax.validation.Valid;
import java.net.URI;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private UserService userService;

	@Autowired
    private AuthenticationManager authenticationManager;

	@Autowired
    private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		System.out.println(loginRequest.getUsername() +"|" + loginRequest.getPassword());
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenProvider.generateToken(authentication);
		System.out.println("*****************Login Calling*******************");
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) throws ExecutionException, InterruptedException {

		System.out.println(signUpRequest.getPassword());
		System.out.println(signUpRequest.getConfirmPassword());
		//checking maching passwords
		if(signUpRequest.getPassword().equals(signUpRequest.getConfirmPassword())) {
			
			
			// Creating user's account
			User user = new User();
			user.setName(signUpRequest.getName());
			user.setEmail(signUpRequest.getEmail());
			user.setUsername(signUpRequest.getUsername());
			user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
			user.setRole(ERole.INITIAL);
			//user.setole("ROLE_USER");
			//user.setUsertype("ROLE_USER");



			//result = userFirebaseService.saveUserWithCollectionId(user.getUserName(),user);
			UserDto result = userService.saveUser(user);

			URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/{username}")
					.buildAndExpand(result.getName()).toUri();

			return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
		}
		else {
			System.out.println("password mismatched");
			return null;
		}

	}

	@GetMapping("/hello")
	public ResponseEntity<String> getHello(){
		return new ResponseEntity<>("hello", HttpStatus.OK);
	}

}
