package com.example.practice23;
import com.example.practice23.models.User;
import com.example.practice23.models.enums.Role;
import com.example.practice23.repositories.UserRepository;
import com.example.practice23.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {
	@Mock
	private UserRepository userRepository;
	@Mock
	private PasswordEncoder passwordEncoder;
	private UserService userService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		userService = new UserService(userRepository, passwordEncoder);
	}

	@Test
	public void testCreateUser_Success() {
		User user = new User();
		user.setEmail("test@example.com");
		user.setPassword("password");

		when(userRepository.findByEmail(user.getEmail())).thenReturn(null);
		when(passwordEncoder.encode(user.getPassword())).thenReturn("encodedPassword");

		assertTrue(userService.createUser(user));
		assertTrue(user.isActive());
		assertTrue(user.getRoles().contains(Role.ROLE_USER));
	}

	@Test
	public void testCreateUser_UserAlreadyExists() {
		User user = new User();
		user.setEmail("existing@example.com");

		when(userRepository.findByEmail(user.getEmail())).thenReturn(user);

		assertFalse(userService.createUser(user));
		assertFalse(user.isActive());
		assertFalse(user.getRoles().contains(Role.ROLE_USER));
	}
}
