package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConcatUT {
    @Test
    void concatBothEmpty() {
        byte[] result = Bytes.concat(new byte[]{}, new byte[]{});
        Assertions.assertEquals(0, result.length);
    }

    @Test
    void concatWithFirstArrayEmpty() {
        byte[] result = Bytes.concat(new byte[]{}, new byte[]{1, 2, 3});
        Assertions.assertEquals(3, result.length);
        Assertions.assertArrayEquals(new byte[]{1, 2, 3}, result);
    }

    @Test
    void concatWithSecondArrayEmpty() {
        byte[] result = Bytes.concat(new byte[]{4, 5, 6}, new byte[]{});
        Assertions.assertEquals(3, result.length);
        Assertions.assertArrayEquals(new byte[]{4, 5, 6}, result);
    }

    @Test
    void concatArraySameSize() {
        byte[] result = Bytes.concat(new byte[]{1, 2, 3}, new byte[]{4, 5, 6});
        Assertions.assertEquals(6, result.length);
        Assertions.assertArrayEquals(new byte[]{1, 2, 3, 4, 5, 6}, result);
    }

    @Test
    void concatArrayWithFirstArrayBigger() {
        byte[] result = Bytes.concat(new byte[]{1, 2, 3, 4, 5}, new byte[]{6, 7});
        Assertions.assertEquals(7, result.length);
        Assertions.assertArrayEquals(new byte[]{1, 2, 3, 4, 5, 6 ,7}, result);
    }

    @Test
    void concatArrayWithSecondArrayBigger() {
        byte[] result = Bytes.concat(new byte[]{1}, new byte[]{2, 3, 4, 5});
        Assertions.assertEquals(5, result.length);
        Assertions.assertArrayEquals(new byte[]{1, 2, 3, 4, 5}, result);
    }
}
