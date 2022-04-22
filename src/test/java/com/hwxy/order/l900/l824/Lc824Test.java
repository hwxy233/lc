package com.hwxy.order.l900.l824;

import com.hwxy.leetcode.order.l900.l824.Lc824;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc824Test {

    @Test
    public void toGoatLatin() {
        Lc824 lc824 = new Lc824();
        assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa",
                lc824.toGoatLatin("I speak Goat Latin"));
        assertEquals(
                "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa",
                lc824.toGoatLatin("The quick brown fox jumped over the lazy dog"));
        assertEquals(
                "Eachmaa ordwmaaa onsistscmaaaa ofmaaaaa owercaselmaaaaaa andmaaaaaaa uppercasemaaaaaaaa etterslmaaaaaaaaa onlymaaaaaaaaaa",
                lc824.toGoatLatin("Each word consists of lowercase and uppercase letters only"));
    }
}
