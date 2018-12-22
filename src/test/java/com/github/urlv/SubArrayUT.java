package com.github.urlv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SubArrayUT {
    //region subarray beginIndex parameter

    @Test
    void subArrayFromZero() {
        byte[] array = new byte[]{1, 2, 3, 4};
        byte[] subarray = Bytes.subarray(array, 0);
        Assertions.assertArrayEquals(array, subarray);
    }

    @Test
    void subArrayFromLast() {
        byte[] array = new byte[]{1, 2, 3, 4};
        byte[] subarray = Bytes.subarray(array, 4);
        Assertions.assertArrayEquals(new byte[]{}, subarray);
    }

    @Test
    void subArrayFromMiddle() {
        byte[] array = new byte[]{1, 2, 3, 4};
        byte[] subarray = Bytes.subarray(array, 2);
        Assertions.assertArrayEquals(new byte[]{3,4}, subarray);
    }

    @Test
    void subArrayFromInvalidIndex() {
        byte[] array = new byte[]{1, 2, 3, 4};
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> Bytes.subarray(array, -1));
    }

    //endregion

    //region subarray beginIndex and endIndex parameters

    @Test
    void subArrayFromZeroToLast() {
        byte[] array = new byte[]{1, 2, 3, 4};
        byte[] subarray = Bytes.subarray(array, 0, array.length);
        Assertions.assertArrayEquals(array, subarray);
    }

    @Test
    void subArrayFromLastToLast() {
        byte[] array = new byte[]{1, 2, 3, 4};
        byte[] subarray = Bytes.subarray(array, 4, 4);
        Assertions.assertArrayEquals(new byte[]{}, subarray);
    }

    @Test
    void subArrayFromMiddleToMiddle() {
        byte[] array = new byte[]{1, 2, 3, 4, 5, 6};
        byte[] subarray = Bytes.subarray(array, 1, 4);
        Assertions.assertArrayEquals(new byte[]{2,3,4}, subarray);
    }

    @Test
    void subArrayOverflow() {
        byte[] array = new byte[]{1, 2, 3, 4, 5, 6};
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> Bytes.subarray(array, 2, array.length + 1));
    }

    //endregion
}
