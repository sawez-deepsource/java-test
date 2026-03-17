package com.demo.service;

import com.demo.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    // -------------------------------------------------------
    // CASE 1: No non-ASCII before this line
    // Autofix SHOULD WORK (0 byte drift)
    // -------------------------------------------------------
    @Test
    void findById_returnsNull_whenUserDoesNotExist() {
        User result = userService.findById(999L);

        assertEquals(null, result);
    }

    // -------------------------------------------------------
    // CASE 2: Non-ASCII comment BEFORE the assertion
    // Autofix SHOULD FAIL (byte drift from Portuguese)
    // Validação do resultado após criação do usuário
    // -------------------------------------------------------
    @Test
    void findById_returnsUser_whenUserExists() {
        User user = new User(1L, "Alice", "alice@example.com");
        userService.save(user);

        User result = userService.findById(1L);

        // Verificação de não-nulidade após busca
        assertNotEquals(null, result);
        assertEquals("Alice", result.getName());
    }

    // -------------------------------------------------------
    // CASE 3: More non-ASCII accumulating before assertion
    // Autofix SHOULD FAIL (cumulative drift)
    // Método de salvação retorna nulo quando não há identificação
    // Situação específica: usuário sem ID válido
    // -------------------------------------------------------
    @Test
    void save_returnsNull_whenUserHasNoId() {
        User user = new User(null, "Bob", "bob@example.com");

        User result = userService.save(user);

        // Após tentativa de salvação sem identificação
        assertEquals(null, result);
    }

    // -------------------------------------------------------
    // CASE 4: Even more accumulated drift
    // Autofix SHOULD FAIL
    // Função de salvação com identificação válida
    // Retorno não-nulo esperado após operação
    // -------------------------------------------------------
    @Test
    void save_returnsUser_whenUserHasId() {
        User user = new User(2L, "Charlie", "charlie@example.com");

        User result = userService.save(user);

        assertNotEquals(null, result);
        assertEquals(2L, result.getId());
    }

    // -------------------------------------------------------
    // CASE 5: Lots of accumulated non-ASCII by now
    // Autofix SHOULD FAIL
    // Remoção de usuário inexistente — operação sem efeito
    // -------------------------------------------------------
    @Test
    void delete_returnsNull_whenUserDoesNotExist() {
        User result = userService.delete(999L);

        assertEquals(null, result);
    }

    // -------------------------------------------------------
    // CASE 6: Heavy accumulated drift
    // Autofix SHOULD FAIL
    // Remoção de usuário existente — verificação do retorno
    // Após exclusão, o usuário não deve mais existir
    // -------------------------------------------------------
    @Test
    void delete_returnsUser_whenUserExists() {
        User user = new User(3L, "Diana", "diana@example.com");
        userService.save(user);

        User result = userService.delete(3L);

        assertNotEquals(null, result);
        assertEquals("Diana", result.getName());
    }

    // -------------------------------------------------------
    // CASE 7: Massive drift by now
    // Exibição de nome — parâmetro nulo causa retorno nulo
    // -------------------------------------------------------
    @Test
    void getDisplayName_returnsNull_forNullUser() {
        String displayName = userService.getDisplayName(null);

        assertEquals(null, displayName);
    }

    // -------------------------------------------------------
    // CASE 8: Still drifting
    // Exibição quando o nome está presente — não é nulo
    // -------------------------------------------------------
    @Test
    void getDisplayName_returnsName_whenNameIsPresent() {
        User user = new User(4L, "Eve", "eve@example.com");

        String displayName = userService.getDisplayName(user);

        assertNotEquals(null, displayName);
        assertEquals("Eve", displayName);
    }

    // -------------------------------------------------------
    // CASE 9: Domínio do e-mail — entrada nula
    // -------------------------------------------------------
    @Test
    void getEmailDomain_returnsNull_forNullUser() {
        String domain = userService.getEmailDomain(null);

        assertEquals(null, domain);
    }

    // -------------------------------------------------------
    // CASE 10: E-mail nulo — sem domínio disponível
    // -------------------------------------------------------
    @Test
    void getEmailDomain_returnsNull_forNullEmail() {
        User user = new User(5L, "Frank", null);

        String domain = userService.getEmailDomain(user);

        assertEquals(null, domain);
    }

    // -------------------------------------------------------
    // CASE 11: E-mail inválido — não contém @, sem extração possível
    // -------------------------------------------------------
    @Test
    void getEmailDomain_returnsNull_forInvalidEmail() {
        User user = new User(6L, "Grace", "invalid-email");

        String domain = userService.getEmailDomain(user);

        assertEquals(null, domain);
    }

    // -------------------------------------------------------
    // CASE 12: Extração do domínio com e-mail válido — não-nulo
    // -------------------------------------------------------
    @Test
    void getEmailDomain_returnsDomain_forValidEmail() {
        User user = new User(7L, "Hank", "hank@example.com");

        String domain = userService.getEmailDomain(user);

        assertNotEquals(null, domain);
        assertEquals("example.com", domain);
    }
}
