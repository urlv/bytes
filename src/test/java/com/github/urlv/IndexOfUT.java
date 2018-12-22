package com.github.urlv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IndexOfUT {
    //region indexOf

    @Test
    void emptyArrayAndValue() {
        Assertions.assertEquals(-1, Bytes.indexOf(new byte[]{}, new byte[]{}));
    }

    @Test
    void emptyArray() {
        Assertions.assertEquals(-1, Bytes.indexOf(new byte[]{}, new byte[]{1,2,3}));
    }

    @Test
    void emptyValue() {
        Assertions.assertEquals(-1, Bytes.indexOf(new byte[]{1,2,3}, new byte[]{}));
    }

    @Test
    void arrayAndValueSameSize() {
        Assertions.assertEquals(-1, Bytes.indexOf(new byte[]{1,2,3}, new byte[]{1,2,4}));
    }

    @Test
    void equalArrays() {
        Assertions.assertEquals(0, Bytes.indexOf(new byte[]{1,2,3}, new byte[]{1,2,3}));
    }

    @Test
    void foundAtStart() {
        Assertions.assertEquals(0, Bytes.indexOf(new byte[]{1,2,3}, new byte[]{1,2}));
    }

    @Test
    void foundAtEnd() {
        Assertions.assertEquals(1, Bytes.indexOf(new byte[]{1,2,3}, new byte[]{2,3}));
    }

    @Test
    void foundAtMiddle() {
        Assertions.assertEquals(2, Bytes.indexOf(new byte[]{1,2,3,4,5}, new byte[]{3,4}));
    }

    @Test
    void multiple() {
        Assertions.assertEquals(4, Bytes.indexOf(new byte[]{1,2,10,1,2,3,1,2,3,10}, new byte[]{2,3}));
    }

    @Test
    void notFound1() {
        Assertions.assertEquals(-1, Bytes.indexOf(new byte[]{1,2,3,4,5}, new byte[]{4,5,6}));
    }

    @Test
    void notFound2() {
        Assertions.assertEquals(-1, Bytes.indexOf(new byte[]{1,2,3,4,5}, new byte[]{11,12}));
    }

    @Test
    void notFound3() {
        Assertions.assertEquals(-1, Bytes.indexOf(new byte[]{1,2,3,4,5}, new byte[]{3,2}));
    }

    //endregion

    //region lastIndexOf

    @Test
    void lastEmptyArrayAndValue() {
        Assertions.assertEquals(-1, Bytes.lastIndexOf(new byte[]{}, new byte[]{}));
    }

    @Test
    void lastEmptyArray() {
        Assertions.assertEquals(-1, Bytes.lastIndexOf(new byte[]{}, new byte[]{1,2,3}));
    }

    @Test
    void lastEmptyValue() {
        Assertions.assertEquals(-1, Bytes.lastIndexOf(new byte[]{1,2,3}, new byte[]{}));
    }

    @Test
    void lastArrayAndValueSameSize() {
        Assertions.assertEquals(-1, Bytes.lastIndexOf(new byte[]{1,2,3}, new byte[]{1,2,4}));
    }

    @Test
    void lastEqualArrays() {
        Assertions.assertEquals(0, Bytes.lastIndexOf(new byte[]{1,2,3}, new byte[]{1,2,3}));
    }

    @Test
    void lastFoundAtStart() {
        Assertions.assertEquals(0, Bytes.lastIndexOf(new byte[]{1,2,3}, new byte[]{1,2}));
    }

    @Test
    void lastFoundAtEnd() {
        Assertions.assertEquals(1, Bytes.lastIndexOf(new byte[]{1,2,3}, new byte[]{2,3}));
    }

    @Test
    void lastFoundAtMiddle() {
        Assertions.assertEquals(2, Bytes.lastIndexOf(new byte[]{1,2,3,4,5}, new byte[]{3,4}));
    }

    @Test
    void lastMultiple() {
        Assertions.assertEquals(7, Bytes.lastIndexOf(new byte[]{1,2,10,1,2,3,1,2,3,10}, new byte[]{2,3}));
    }

    @Test
    void lastNotFound1() {
        Assertions.assertEquals(-1, Bytes.lastIndexOf(new byte[]{1,2,3,4,5}, new byte[]{4,5,6}));
    }

    @Test
    void lastNotFound2() {
        Assertions.assertEquals(-1, Bytes.lastIndexOf(new byte[]{1,2,3,4,5}, new byte[]{11,12}));
    }

    @Test
    void lastNotFound3() {
        Assertions.assertEquals(-1, Bytes.lastIndexOf(new byte[]{1,2,3,4,5}, new byte[]{3,2}));
    }

    //endregion
}
