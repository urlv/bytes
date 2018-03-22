package main;

import core.Bytes;

public class Main {
    public static void main(String[] args) {
        byte[] array = new byte[]{103,20,4,34,4,0,2};
        byte[] valaa = new byte[]{4,0,2};

        int pos = Bytes.indexOf(array, valaa);
    }
}
