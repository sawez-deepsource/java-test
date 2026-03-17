package com.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UserTest {

    @Test
    void defaultConstructor_hasNullFields() {
        User user = new User();

        // JAVA-W1091: Should use assertNull instead
        assertEquals(null, user.getId());
        assertEquals(null, user.getName());
        assertEquals(null, user.getEmail());
    }

    @Test
    void parameterizedConstructor_setsFields() {
        User user = new User(1L, "Alice", "alice@example.com");

        // JAVA-W1091: Should use assertNotNull instead
        assertNotEquals(null, user.getId());
        assertNotEquals(null, user.getName());
        assertNotEquals(null, user.getEmail());
    }

    @Test
    void setters_updateFields() {
        User user = new User();

        user.setId(1L);
        user.setName("Bob");
        user.setEmail("bob@example.com");

        // JAVA-W1091: Should use assertNotNull instead
        assertNotEquals(null, user.getId());
        assertNotEquals(null, user.getName());
        assertNotEquals(null, user.getEmail());
    }

    @Test
    void setters_acceptNull() {
        User user = new User(1L, "Charlie", "charlie@example.com");

        user.setName(null);
        user.setEmail(null);

        // JAVA-W1091: Should use assertNull instead
        assertEquals(null, user.getName());
        assertEquals(null, user.getEmail());
    }
}
