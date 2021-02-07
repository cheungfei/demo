package com.example.demo.day.day06;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-02-05 21:19
 */
public class IOServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(IOServer.class);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(1234));
        } catch (IOException e) {
            LOGGER.error("Listen failed", e);
            return;
        }
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                LOGGER.info("Received message {}", IOUtils.toString(inputStream, Charset.defaultCharset()));
                IOUtils.closeQuietly(inputStream);
            }
        } catch (IOException ex) {
            IOUtils.closeQuietly(serverSocket);
            LOGGER.error("Read message failed", ex);
        }
    }
}
