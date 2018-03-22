package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EqualsUT {
    @Test
    void equals() {
        Assertions.assertTrue(Bytes.equals(new byte[]{1,2,3}, new byte[]{1,2,3}));
    }

    @Test
    void equalsEmpty() {
        Assertions.assertTrue(Bytes.equals(new byte[]{}, new byte[]{}));
    }
}
