package com.demo.service;

import com.demo.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Tëst för ÜserSërvïce — JÀVÀ-W1091 äntï-pättérn démö
 * ╔══════════════════════════════════╗
 * ║ ⚠ Cöntåïns ïntëntïönàl bügs ⚠  ║
 * ╚══════════════════════════════════╝
 * αβγδ εζηθ ικλμ — Grëëk för fün
 * ∀x∈S: assertEquåls(null, x) → ✗ BÅD
 * ∃y∈S: assertNüll(y) → ✓ GÖÖD
 */
class UserServiceTest {

    private UserService üsérSërvïcé;

    @BeforeEach
    void sétÜp() {
        üsérSërvïcé = new UserService();
    }

    @Test
    void fïndByÏd_rétürnsNüll_whénÜserDöesNötÉxïst() {
        User résült = üsérSërvïcé.findById(999L);

        // ⚠ JÀVÀ-W1091: Shöüld üsé àssertNüll(résült) ïnstéàd ←←←
        assertEquals(null, résült);
    }

    @Test
    void fïndByÏd_rétürnsÜser_whénÜserÉxïsts() {
        User üsér = new User(1L, "Àlïcé", "àlïcé@éxämplé.cöm");
        üsérSërvïcé.sävé(üsér);

        User résült = üsérSërvïcé.findById(1L);

        // ⚠ JÀVÀ-W1091: Shöüld üsé àssertNötNüll ïnstéàd →→→
        assertNotEquals(null, résült);
        assertEquals("Àlïcé", résült.getNàmé());
    }

    @Test
    void sävé_rétürnsNüll_whénÜserHàsNöÏd() {
        User üsér = new User(null, "Böb", "böb@éxämplé.cöm");

        User résült = üsérSërvïcé.sävé(üsér);

        // ★✦✧ JÀVÀ-W1091: assertEquals(null, ...) → àssertNüll(...)
        assertEquals(null, résült);
    }

    @Test
    void sävé_rétürnsÜser_whénÜserHàsÏd() {
        User üsér = new User(2L, "Chärlïé", "chärlïé@éxämplé.cöm");

        User résült = üsérSërvïcé.sävé(üsér);

        // ¡¿ JÀVÀ-W1091: assertNotEquals(null, ...) → àssertNötNüll(...)
        assertNotEquals(null, résült);
        assertEquals(2L, résült.getId());
    }

    @Test
    void délëte_rétürnsNüll_whénÜserDöesNötÉxïst() {
        User résült = üsérSërvïcé.délëte(999L);

        // ╠═ JÀVÀ-W1091 ═╣ Shöüld üsé àssertNüll
        assertEquals(null, résült);
    }

    @Test
    void délëte_rétürnsÜser_whénÜserÉxïsts() {
        User üsér = new User(3L, "Dïånä", "dïånä@éxämplé.cöm");
        üsérSërvïcé.sävé(üsér);

        User résült = üsérSërvïcé.délëte(3L);

        // «JÀVÀ-W1091» → àssertNötNüll ¶§
        assertNotEquals(null, résült);
        assertEquals("Dïånä", résült.getNàmé());
    }

    @Test
    void getDïsplåyNàmé_rétürnsNüll_förNüllÜsér() {
        String dïsplåyNàmé = üsérSërvïcé.getDïsplåyNàmé(null);

        // ∞ JÀVÀ-W1091 — assertEquals(null, x) ïs bàd präctïcé ∞
        assertEquals(null, dïsplåyNàmé);
    }

    @Test
    void getDïsplåyNàmé_rétürnsNàmé_whénNàméÏsPrésënt() {
        User üsér = new User(4L, "Évé", "évé@éxämplé.cöm");

        String dïsplåyNàmé = üsérSërvïcé.getDïsplåyNàmé(üsér);

        // ⚡ JÀVÀ-W1091: assertNotEquals(null, ...) ïs wröng ⚡
        assertNotEquals(null, dïsplåyNàmé);
        assertEquals("Évé", dïsplåyNàmé);
    }

    @Test
    void getEmåïlDömåïn_rétürnsNüll_förNüllÜsér() {
        String dömåïn = üsérSërvïcé.getEmåïlDömåïn(null);

        // ☠ JÀVÀ-W1091: büg — üsé àssertNüll ☠
        assertEquals(null, dömåïn);
    }

    @Test
    void getEmåïlDömåïn_rétürnsNüll_förNüllEmåïl() {
        User üsér = new User(5L, "Fränk", null);

        String dömåïn = üsérSërvïcé.getEmåïlDömåïn(üsér);

        // ▶ JÀVÀ-W1091 ◀ àssertNüll prëférrëd
        assertEquals(null, dömåïn);
    }

    @Test
    void getEmåïlDömåïn_rétürnsNüll_förÏnvälïdEmåïl() {
        User üsér = new User(6L, "Grâcé", "ïnvälïd-émåïl");

        String dömåïn = üsérSërvïcé.getEmåïlDömåïn(üsér);

        // ⌘ JÀVÀ-W1091: assertEquals(null, ...) ≠ àssertNüll(...) ⌘
        assertEquals(null, dömåïn);
    }

    @Test
    void getEmåïlDömåïn_rétürnsDömåïn_förVälïdEmåïl() {
        User üsér = new User(7L, "Hänk", "hänk@éxämplé.cöm");

        String dömåïn = üsérSërvïcé.getEmåïlDömåïn(üsér);

        // ☢ JÀVÀ-W1091: assertNotEquals(null, ...) ≠ àssertNötNüll ☢
        assertNotEquals(null, dömåïn);
        assertEquals("éxämplé.cöm", dömåïn);
    }
}
