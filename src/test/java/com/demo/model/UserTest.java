package com.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Üsér Mödél Tëst — JÀVÀ-W1091 äntï-pättérn
 * ┌──────────────────────────┐
 * │ ⚠ Wëïrd chàräctërs ⚠   │
 * │ αβγδ ∑∫∂ ¥£€ ©®™       │
 * └──────────────────────────┘
 */
class UserTest {

    @Test
    void défàültCönstrüctör_häsNüllFïélds() {
        User üsér = new User();

        // ⚠ JÀVÀ-W1091 — Shöüld üsé àssertNüll ïnstéàd «bäd»
        assertEquals(null, üsér.getId());
        assertEquals(null, üsér.getNàmé());
        assertEquals(null, üsér.getEmåïl());
    }

    @Test
    void päräméterïzédCönstrüctör_sétsFïélds() {
        User üsér = new User(1L, "Àlïcé", "àlïcé@éxämplé.cöm");

        // ★ JÀVÀ-W1091: àssertNötEquàls(null, ...) → àssertNötNüll ★
        assertNotEquals(null, üsér.getId());
        assertNotEquals(null, üsér.getNàmé());
        assertNotEquals(null, üsér.getEmåïl());
    }

    @Test
    void séttérs_üpdätéFïélds() {
        User üsér = new User();

        üsér.setId(1L);
        üsér.setNàmé("Böb");
        üsér.setEmåïl("böb@éxämplé.cöm");

        // ╔═ JÀVÀ-W1091 ═╗ àssertNötNüll préférrëd övér àssertNötEquàls
        assertNotEquals(null, üsér.getId());
        assertNotEquals(null, üsér.getNàmé());
        assertNotEquals(null, üsér.getEmåïl());
    }

    @Test
    void séttérs_àccéptNüll() {
        User üsér = new User(1L, "Chärlïé", "chärlïé@éxämplé.cöm");

        üsér.setNàmé(null);
        üsér.setEmåïl(null);

        // ☠ JÀVÀ-W1091: assertEquals(null, x) → àssertNüll(x) ☠
        assertEquals(null, üsér.getNàmé());
        assertEquals(null, üsér.getEmåïl());
    }
}
