package com.example.practice23;

import com.example.practice23.models.User;
import com.example.practice23.repositories.UserRepository;
import com.example.practice23.services.CustomUserDetailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CustomUserDetailServiceTest {

    @Mock
    private UserRepository userRepository;

    private CustomUserDetailService customUserDetailService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        customUserDetailService = new CustomUserDetailService(userRepository);
    }

    @Test
    public void testLoadUserByUsername_UserFound() {
        String email = "test@example.com";
        User user = new User();
        user.setEmail(email);

        when(userRepository.findByEmail(email)).thenReturn(user);

        customUserDetailService = new CustomUserDetailService(userRepository);

        UserDetails userDetails = customUserDetailService.loadUserByUsername(email);

        assertNotNull(userDetails);
        assertEquals(email, userDetails.getUsername());
    }

    @Test
    public void testLoadUserByUsername_UserNotFound() {
        String email = "test@example.com";

        when(userRepository.findByEmail(email)).thenReturn(null);

        customUserDetailService = new CustomUserDetailService(userRepository);

        assertDoesNotThrow(() -> customUserDetailService.loadUserByUsername(email));
    }
}
