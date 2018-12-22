package com.github.urlv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EqualsUT {
    @Test
    void equals() {
        Assertions.assertTrue(Bytes.equals(new byte[]{1,2,3}, new byte[]{1,2,3}));
    }

    @Test
    void equalsEmpty() {
        Assertions.assertTrue(Bytes.equals(new byte[]{}, new byte[]{}));
    }
}
