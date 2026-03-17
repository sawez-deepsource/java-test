package com.demo.service;

import com.demo.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void findById_returnsNull_whenUserDoesNotExist() {
        User result = userService.findById(999L);

        // JAVA-W1091: Should use assertNull(result) instead
        assertNull(result);
    }

    @Test
    void findById_returnsUser_whenUserExists() {
        User user = new User(1L, "Alice", "alice@example.com");
        userService.save(user);

        User result = userService.findById(1L);

        // JAVA-W1091: Should use assertNotNull(result) instead
        assertNotNull(result);
        assertEquals("Alice", result.getName());
    }

    @Test
    void save_returnsNull_whenUserHasNoId() {
        User user = new User(null, "Bob", "bob@example.com");

        User result = userService.save(user);

        // JAVA-W1091: Should use assertNull(result) instead
        assertNull(result);
    }

    @Test
    void save_returnsUser_whenUserHasId() {
        User user = new User(2L, "Charlie", "charlie@example.com");

        User result = userService.save(user);

        // JAVA-W1091: Should use assertNotNull(result) instead
        assertNotNull(result);
        assertEquals(2L, result.getId());
    }

    @Test
    void delete_returnsNull_whenUserDoesNotExist() {
        User result = userService.delete(999L);

        // JAVA-W1091: Should use assertNull(result) instead
        assertNull(result);
    }

    @Test
    void delete_returnsUser_whenUserExists() {
        User user = new User(3L, "Diana", "diana@example.com");
        userService.save(user);

        User result = userService.delete(3L);

        // JAVA-W1091: Should use assertNotNull(result) instead
        assertNotNull(result);
        assertEquals("Diana", result.getName());
    }

    @Test
    void getDisplayName_returnsNull_forNullUser() {
        String displayName = userService.getDisplayName(null);

        // JAVA-W1091: Should use assertNull(displayName) instead
        assertNull(displayName);
    }

    @Test
    void getDisplayName_returnsName_whenNameIsPresent() {
        User user = new User(4L, "Eve", "eve@example.com");

        String displayName = userService.getDisplayName(user);

        // JAVA-W1091: Should use assertNotNull(displayName) instead
        assertNotNull(displayName);
        assertEquals("Eve", displayName);
    }

    @Test
    void getEmailDomain_returnsNull_forNullUser() {
        String domain = userService.getEmailDomain(null);

        // JAVA-W1091: Should use assertNull(domain) instead
        assertNull(domain);
    }

    @Test
    void getEmailDomain_returnsNull_forNullEmail() {
        User user = new User(5L, "Frank", null);

        String domain = userService.getEmailDomain(user);

        // JAVA-W1091: Should use assertNull(domain) instead
        assertNull(domain);
    }

    @Test
    void getEmailDomain_returnsNull_forInvalidEmail() {
        User user = new User(6L, "Grace", "invalid-email");

        String domain = userService.getEmailDomain(user);

        // JAVA-W1091: Should use assertNull(domain) instead
        assertNull(domain);
    }

    @Test
    void getEmailDomain_returnsDomain_forValidEmail() {
        User user = new User(7L, "Hank", "hank@example.com");

        String domain = userService.getEmailDomain(user);

        // JAVA-W1091: Should use assertNotNull(domain) instead
        assertNotNull(domain);
        assertEquals("example.com", domain);
    }
}
