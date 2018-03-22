package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SplitUT {
    @Test
    void test(){
        byte[] a = new byte[]{1,2,3,4,5,2,3};
        byte[] b = Bytes.replaceAll(a, new byte[]{2,3}, new byte[]{0,2,0});
        int x = 3;
    }

    @Test
    void emptyArguments(){
        byte[][] result = Bytes.split(new byte[]{}, new byte[]{});
        Assertions.assertEquals(1, result.length);
        Assertions.assertEquals(0, result[0].length);
    }

    @Test
    void emptyArray(){
        byte[][] result = Bytes.split(new byte[]{}, new byte[]{1, 2, 3});
        Assertions.assertEquals(1, result.length);
        Assertions.assertEquals(0, result[0].length);
    }

    @Test
    void emptyDelimiter(){
        byte[] array = new byte[]{1,2,3};
        byte[][] result = Bytes.split(array, new byte[]{});
        Assertions.assertEquals(1, result.length);
        Assertions.assertArrayEquals(array, result[0]);
    }

    @Test
    void delimiterLongThanArray(){
        byte[] array = new byte[]{1,2,3};
        byte[][] result = Bytes.split(array, new byte[]{1,2,3,4});
        Assertions.assertEquals(1, result.length);
        Assertions.assertArrayEquals(array, result[0]);
    }

    @Test
    void delimiterNotFound(){
        byte[] array = new byte[]{1,2,3};
        byte[][] result = Bytes.split(array, new byte[]{5,6});
        Assertions.assertEquals(1, result.length);
        Assertions.assertArrayEquals(array, result[0]);
    }

    @Test
    void delimiterFoundAtStart(){
        byte[] array = new byte[]{1,2,3,4,5};
        byte[][] result = Bytes.split(array, new byte[]{1,2});
        Assertions.assertEquals(1, result.length);
        Assertions.assertArrayEquals(new byte[]{3,4,5}, result[0]);
    }

    @Test
    void delimiterFoundAtEnd(){
        byte[] array = new byte[]{1,2,3,4,5};
        byte[][] result = Bytes.split(array, new byte[]{4,5});
        Assertions.assertEquals(1, result.length);
        Assertions.assertArrayEquals(new byte[]{1,2,3}, result[0]);
    }

    @Test
    void delimiterFoundAtMiddle(){
        byte[] array = new byte[]{1,2,3,4,5,6,7};
        byte[][] result = Bytes.split(array, new byte[]{4,5});
        Assertions.assertEquals(2, result.length);
        Assertions.assertArrayEquals(new byte[]{1,2,3}, result[0]);
        Assertions.assertArrayEquals(new byte[]{6,7}, result[1]);
    }

    @Test
    void delimiterFoundMultiple(){
        byte[] array = new byte[]{1,2,3,4,5,6,7,4,5,8,9,10,4,5,11};
        byte[][] result = Bytes.split(array, new byte[]{4,5});
        Assertions.assertEquals(4, result.length);
        Assertions.assertArrayEquals(new byte[]{1,2,3}, result[0]);
        Assertions.assertArrayEquals(new byte[]{6,7}, result[1]);
        Assertions.assertArrayEquals(new byte[]{8,9,10}, result[2]);
        Assertions.assertArrayEquals(new byte[]{11}, result[3]);
    }

    @Test
    void delimiterFoundMultiple2(){
        byte[] array = new byte[]{1,2,3,4,5,4,5,6,7,4,5,8,9,10,4,5,11};
        byte[][] result = Bytes.split(array, new byte[]{4,5});
        Assertions.assertEquals(4, result.length);
        Assertions.assertArrayEquals(new byte[]{1,2,3}, result[0]);
        Assertions.assertArrayEquals(new byte[]{6,7}, result[1]);
        Assertions.assertArrayEquals(new byte[]{8,9,10}, result[2]);
        Assertions.assertArrayEquals(new byte[]{11}, result[3]);
    }

    @Test
    void delimiterFoundMultipleIncludeEnd(){
        byte[] array = new byte[]{1,2,3,4,5,6,7,4,5,8,9,10,4,5,11,4,5};
        byte[][] result = Bytes.split(array, new byte[]{4,5});
        Assertions.assertEquals(4, result.length);
        Assertions.assertArrayEquals(new byte[]{1,2,3}, result[0]);
        Assertions.assertArrayEquals(new byte[]{6,7}, result[1]);
        Assertions.assertArrayEquals(new byte[]{8,9,10}, result[2]);
        Assertions.assertArrayEquals(new byte[]{11}, result[3]);
    }

    @Test
    void delimiterAllTheWay(){
        byte[] array = new byte[]{4,5,4,5,4,5,4,5};
        byte[][] result = Bytes.split(array, new byte[]{4,5});
        Assertions.assertEquals(0, result.length);
    }
}
