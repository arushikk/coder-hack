package com.crio.CoderHack.coderhack;
import com.crio.CoderHack.coderhack.Controller.UserController;
import com.crio.CoderHack.coderhack.DTO.UserRequestDTO;
import com.crio.CoderHack.coderhack.DTO.UserResponseDTO;
import com.crio.CoderHack.coderhack.Model.User;
import com.crio.CoderHack.coderhack.Service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        // Mock data
        List<User> users = Arrays.asList(new User(), new User());
        when(userService.getAllUsers()).thenReturn(users);

        // Call the controller method
        ResponseEntity<List<User>> response = userController.getAllUsers();

        // Verify the result
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(users, response.getBody());
    }

    @Test
    public void testGetUserById() {
        // Mock data
        BigInteger userId = BigInteger.ONE;
        User user = new User();
        when(userService.getUserById(userId)).thenReturn(user);

        // Call the controller method
        ResponseEntity<User> response = userController.getUserById(userId);

        // Verify the result
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    // Similarly, write tests for other controller methods
    // testRegisterUser(), testUpdateScore(), and testDeregisterUser()

    // Example:
    @Test
    public void testRegisterUser() {
        // Mock data
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        when(userService.registerUser(any(UserRequestDTO.class))).thenReturn(userResponseDTO);

        // Call the controller method
        ResponseEntity<UserResponseDTO> response = userController.registerUser(userRequestDTO);

        // Verify the result
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(userResponseDTO, response.getBody());
    }
    @Test
    public void testUpdateScore() {
        // Mock data
        BigInteger userId = BigInteger.ONE;
        User user = new User();
        user.setScore(100);
        when(userService.updateScore(eq(userId), anyInt())).thenReturn(user);

        // Call the controller method
        ResponseEntity<User> response = userController.updateScore(userId, user);

        // Verify the result
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testDeregisterUser() {
        // Mock data
        BigInteger userId = BigInteger.ONE;
        when(userService.deregisterUser(userId)).thenReturn(true);

        // Call the controller method
        ResponseEntity<Void> response = userController.deregisterUser(userId);

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }



}
