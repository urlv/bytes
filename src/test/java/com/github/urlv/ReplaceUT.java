package com.github.urlv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReplaceUT {
    //region replaceFirst
    @Test
    void replaceFirst() {
        byte[] array = new byte[]{1,4,5,6,4,5,8};
        byte[] search = new byte[]{4,5};
        byte[] replacement = new byte[]{0,2,8};

        Assertions.assertArrayEquals(new byte[]{1,0,2,8,6,4,5,8}, Bytes.replaceFirst(array, search, replacement));
    }

    @Test
    void replaceFirstNotFound() {
        byte[] array = new byte[]{1,4,5,6,4,5,8};
        byte[] search = new byte[]{4,7};
        byte[] replacement = new byte[]{0,2,8};

        Assertions.assertArrayEquals(array, Bytes.replaceFirst(array, search, replacement));
    }

    //endregion

    //region replaceAll
    @Test
    void replaceAll() {
        byte[] array = new byte[]{1,4,5,6,4,5,8};
        byte[] search = new byte[]{4,5};
        byte[] replacement = new byte[]{0,2,8};

        Assertions.assertArrayEquals(new byte[]{1,0,2,8,6,0,2,8,8}, Bytes.replaceAll(array, search, replacement));
    }

    @Test
    void replaceAllNotFound() {
        byte[] array = new byte[]{1,4,5,6,4,5,8};
        byte[] search = new byte[]{4,7};
        byte[] replacement = new byte[]{0,2,8};

        Assertions.assertArrayEquals(array, Bytes.replaceAll(array, search, replacement));
    }

    //endregion
}
