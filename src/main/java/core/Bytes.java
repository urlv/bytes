package core;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bytes {
    public static byte[] concat(byte[] array, byte[]... arrays) {
        byte[] dst = Arrays.copyOf(array, array.length);

        for (int i = 0; i < arrays.length; i++) {
            dst = Bytes.concat(dst, arrays[i]);
        }

        return dst;
    }

    private static byte[] concat(byte[] a, byte[] b) {
        byte[] dst = new byte[a.length + b.length];

        System.arraycopy(a, 0, dst, 0, a.length);
        System.arraycopy(b, 0, dst, a.length, b.length);

        return dst;
    }

    public static byte[] copy(byte[] array) {
        return Arrays.copyOf(array, array.length);
    }

    public static boolean equals(byte[] a, byte[] b) {
        return Arrays.equals(a, b);
    }

    public static byte[] subarray(byte[] array, int beginIndex) {
        return Bytes.subarray(array, beginIndex, array.length);
    }

    public static byte[] subarray(byte[] array, int beginIndex, int endIndex) {
        if (beginIndex < 0 || endIndex > array.length) {
            throw new IndexOutOfBoundsException();
        }
        return Arrays.copyOfRange(array, beginIndex, endIndex);
    }

    public static int indexOf(byte[] array, byte[] value) {
        if (array.length < value.length || value.length == 0) {
            return -1;
        }

        for (int i = 0; i <= (array.length - value.length); ++i) {
            boolean isFound = true;

            for (int j = 0; j < value.length && isFound; ++j) {
                if (array[i + j] != value[j]) {
                    isFound = false;
                }
            }

            if (isFound) {
                return i;
            }
        }

        return -1;
    }

    private static int indexOf(byte[] array, byte[] value, int fromIndex) {
        if (array.length - fromIndex < value.length || value.length == 0) {
            return -1;
        }

        for (int i = 0; i <= (array.length - fromIndex - value.length); ++i) {
            boolean isFound = true;

            for (int j = 0; j < value.length && isFound; ++j) {
                if (array[i + fromIndex + j] != value[j]) {
                    isFound = false;
                }
            }

            if (isFound) {
                return i + fromIndex;
            }
        }

        return -1;
    }

    public static int lastIndexOf(byte[] array, byte[] value) {
        if (array.length < value.length || value.length == 0) {
            return -1;
        }

        for (int i = 0; i <= (array.length - value.length); ++i) {
            boolean isFound = true;

            for (int j = 0; j < value.length && isFound; ++j) {
                if (array[array.length - i - 1 - j] != value[value.length - 1 - j]) {
                    isFound = false;
                }
            }

            if (isFound) {
                return array.length - value.length - i;
            }
        }

        return -1;
    }

    public static boolean startWith(byte[] array, byte[] value) {
        if (array.length < value.length || array.length == 0 || value.length == 0) {
            return false;
        }

        for (int i = 0; i < value.length; ++i) {
            if (array[i] != value[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean endWith(byte[] array, byte[] value) {
        if (array.length < value.length || array.length == 0 || value.length == 0) {
            return false;
        }

        for (int i = 0; i < value.length; ++i) {
            if (array[array.length - i - 1] != value[value.length - i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static boolean contains(byte[] array, byte[] value) {
        return Bytes.indexOf(array, value) != -1;
    }

    public static byte[][] split(byte[] array, byte[] delimiter) {
        List<byte[]> result = new ArrayList<>();

        int prevPos = 0;
        int pos = indexOf(array, delimiter, prevPos);

        while (pos != -1) {
            if (pos != prevPos) {
                result.add(subarray(array, prevPos, pos));
            }

            prevPos = pos + delimiter.length;
            pos = indexOf(array, delimiter, prevPos);
        }

        if (prevPos < array.length) {
            result.add(subarray(array, prevPos));
        }

        return prevPos == 0 ? new byte[][]{Bytes.copy(array)} : convert(result);
    }

    public static byte[] replaceFirst(byte[] array, byte[] search, byte[] replace) {
        int pos = Bytes.indexOf(array, search);
        return pos == -1 ? Bytes.copy(array) :
                Bytes.concat(Bytes.subarray(array, 0, pos), replace, Bytes.subarray(array, pos + search.length));
    }

    public static byte[] replaceAll(byte[] array, byte[] search, byte[] replace) {
        byte[][] split = Bytes.split(array, search);
        byte[] result = split[0];

        for (int i = 1; i < split.length; ++i) {
            result = Bytes.concat(result, replace, split[i]);
        }

        return result;
    }

    public static byte[] convert(Byte[] bytes) {
        byte[] result = new byte[bytes.length];

        for (int i = 0; i < bytes.length; ++i) {
            result[i] = bytes[i];
        }

        return result;
    }

    private static byte[][] convert(List<byte[]> bytes) {
        byte[][] result = new byte[bytes.size()][];

        for (int i = 0; i < bytes.size(); ++i) {
            result[i] = bytes.get(i);
        }

        return result;
    }

    public static String toString(byte[] bytes) {
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public static byte[] toByte(String str) {
        return str.getBytes(StandardCharsets.UTF_8);
    }
}
