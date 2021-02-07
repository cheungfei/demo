package com.example.demo.day.day05;

import org.springframework.util.ResourceUtils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-02-02 17:39
 */
public class NioChannelTest {
    public static void main(String[] args) throws IOException {
//        FileInputStream fin = new FileInputStream("readandshow.txt");
//        FileChannel fc = fin.getChannel();
//        ByteBuffer buffer = ByteBuffer.allocate(1024);
//        fc.read(buffer);
//
//        FileOutputStream fout = new FileOutputStream("writesomebytes.txt");
//        FileChannel channel = fout.getChannel();

//        method2();

        method3();
    }

    public static void method2() throws IOException {
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(ResourceUtils.getFile("classpath:test.txt")));
            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.println((char) buf[i]);
                }
                bytesRead = in.read(buf);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void method3() throws FileNotFoundException {
        RandomAccessFile afile = null;
        try {
            afile = new RandomAccessFile(ResourceUtils.getFile("classpath:test.txt"), "rw");
            FileChannel fileChannel = afile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int bytesRead = fileChannel.read(buffer);
            System.out.println(bytesRead);
            while (bytesRead != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.println((char) buffer.get());
                }
                buffer.compact();
                bytesRead = fileChannel.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (afile != null) {
                    afile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
