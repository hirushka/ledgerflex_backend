package com.hiru96.ledgerflex.Security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hiru96.ledgerflex.Model.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class UserPrincipal implements UserDetails {


	private String userName;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserPrincipal( String userName, String password
			/*,
			Collection<? extends GrantedAuthority> authorities*/) {
		this.userName = userName;
		this.password = password;
		//this.authorities = authorities;
	}

	public static UserPrincipal create(User user) {
//		List<GrantedAuthority> authorities = user.getRoles().stream()
//				.map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
		List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
//		authorities.add(new SimpleGrantedAuthority("USER_ADMIN"));

		return new UserPrincipal(user.getUsername(), user.getPassword()/*,
				authorities*/);
	}


	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserPrincipal that = (UserPrincipal) o;
		return Objects.equals(userName, that.userName);
	}

	@Override
	public int hashCode() {

		return Objects.hash(userName);
	}
}
