package com.queue;

import java.io.*;

public class OutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("fos.txt"));
        fos.write(97);
        fos.close();
    }
}
