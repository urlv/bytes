package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CopyUT {
    @Test
    void copy() {
        byte[] array = new byte[]{1,2,3,4};
        byte[] copy = Bytes.copy(array);

        Assertions.assertArrayEquals(copy, array);

        array[0] = 5;
        Assertions.assertNotEquals(copy[0], array[0]);
    }

    @Test
    void copyEmpty(){
        Assertions.assertArrayEquals(new byte[]{}, Bytes.copy(new byte[]{}));
    }
}
