package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StartWithEndWithContainsUT {
    //region startWith
    @Test
    void startWith() {
        Assertions.assertTrue(Bytes.startWith(new byte[]{1,2,3,4,5}, new byte[]{1,2}));
    }

    @Test
    void noStartWth() {
        Assertions.assertFalse(Bytes.startWith(new byte[]{1,2,3,4,5}, new byte[]{2,1}));
    }

    @Test
    void StartWthEmpty() {
        Assertions.assertFalse(Bytes.startWith(new byte[]{1,2,3,4,5}, new byte[]{}));
    }

    // endregion

    //region endWith
    @Test
    void endWith() {
        Assertions.assertTrue(Bytes.endWith(new byte[]{1,2,3,4,5}, new byte[]{4,5}));
    }

    @Test
    void noEndWth() {
        Assertions.assertFalse(Bytes.endWith(new byte[]{1,2,3,4,5}, new byte[]{4,5,6}));
    }

    @Test
    void endWthEmpty() {
        Assertions.assertFalse(Bytes.endWith(new byte[]{1,2,3,4,5}, new byte[]{}));
    }

    //endregion

    //region contains
    @Test
    void contains() {
        Assertions.assertTrue(Bytes.contains(new byte[]{6,5,3,1,0}, new byte[]{5,3}));
    }

    @Test
    void containsEnd() {
        Assertions.assertTrue(Bytes.contains(new byte[]{6,5,3,1,0}, new byte[]{1,0}));
    }

    @Test
    void noContains() {
        Assertions.assertFalse(Bytes.contains(new byte[]{6,5,3,1,0}, new byte[]{1,1}));
    }

    //endregion
}
