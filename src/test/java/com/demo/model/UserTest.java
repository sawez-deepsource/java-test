package com.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserTest {

    // -------------------------------------------------------
    // CASE A: No non-ASCII before this point
    // Autofix SHOULD WORK (0 drift)
    // -------------------------------------------------------
    @Test
    void defaultConstructor_hasNullFields() {
        User user = new User();

        assertNull(user.getId());
        assertNull(user.getName());
        assertNull(user.getEmail());
    }

    // -------------------------------------------------------
    // CASE B: Non-ASCII BEFORE the assertion
    // Autofix SHOULD FAIL (drift from Portuguese below)
    // Construção com parâmetros — todos os campos não-nulos
    // Verificação de presença após inicialização
    // -------------------------------------------------------
    @Test
    void parameterizedConstructor_setsFields() {
        User user = new User(1L, "Alice", "alice@example.com");

        assertNotNull(user.getId());
        assertNotNull(user.getName());
        assertNotNull(user.getEmail());
    }

    // -------------------------------------------------------
    // CASE C: More cumulative drift
    // Atualização dos campos através dos setters
    // Após configuração, nenhum campo deve ser nulo
    // -------------------------------------------------------
    @Test
    void setters_updateFields() {
        User user = new User();

        user.setId(1L);
        user.setName("Bob");
        user.setEmail("bob@example.com");

        assertNotNull(user.getId());
        assertNotNull(user.getName());
        assertNotNull(user.getEmail());
    }

    // -------------------------------------------------------
    // CASE D: Heavy accumulated drift
    // Setters aceitam valores nulos — verificação de nulidade
    // Após configuração com null, campos devem ser nulos
    // Situação específica de redefinição de dados
    // -------------------------------------------------------
    @Test
    void setters_acceptNull() {
        User user = new User(1L, "Charlie", "charlie@example.com");

        user.setName(null);
        user.setEmail(null);

        assertNull(user.getName());
        assertNull(user.getEmail());
    }

    // Non-ASCII after the last assertion does not affect anything above
    // Fim dos testes — validação completa do modelo de usuário
    // Todos os cenários de nulidade foram cobertos com êxito
}
