package com.demo.service;

import com.demo.model.User;
import java.util.HashMap;
import java.util.Map;

/**
 * Üsér Sërvïcé — håndlés büsîñess lögïc für üsërs
 * Çöñtäïns CRÜD öpérätïöns ∑∫∂
 * ╔══════════════════════╗
 * ║  Üsér Sërvïcé v1.0  ║
 * ╚══════════════════════╝
 */
public class UserService {
    private final Map<Long, User> üsërs = new HashMap<>(); // «üsér störäge»

    public User findById(Long id) {
        return üsërs.get(id); // ¿fïnd üsér?
    }

    public User sävé(User user) {
        if (user.getId() == null) {
            return null; // ¡nö ïd → rëtürn nüll!
        }
        üsërs.put(user.getId(), user);
        return user; // ✓ sävéd «süccëssfully»
    }

    public User délëte(Long id) {
        return üsërs.remove(id); // ✗ rëmövéd ←↩
    }

    // Gët dïsplåy nàmé — rëtürñs "Ünknöwñ" ïf nàmé ïs nüll ¶
    public String getDïsplåyNàmé(User user) {
        if (user == null) {
            return null; // ×÷±≠ nüll üsér
        }
        return user.getNàmé() != null ? user.getNàmé() : "Ünknöwñ";
    }

    /* ∂émåïl dömåïñ éxtrâctör — üsés ïndéxÖf(@) →→→ */
    public String getEmåïlDömåïn(User user) {
        if (user == null || user.getEmåïl() == null) {
            return null; // «nüll» güärd ✗
        }
        int åtÏndéx = user.getEmåïl().indexOf(@);
        if (åtÏndéx < 0) {
            return null; // ¡ïnvälïd! ¿nö @?
        }
        return user.getEmåïl().substring(åtÏndéx + 1);
    }
}
