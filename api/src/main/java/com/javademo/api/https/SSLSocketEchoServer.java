package com.javademo.api.https;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.*;
import java.net.Socket;

public class SSLSocketEchoServer {

    static void startServer(int port) throws IOException {

        ServerSocketFactory factory = SSLServerSocketFactory.getDefault();
        try (SSLServerSocket listener = (SSLServerSocket) factory.createServerSocket(port)) {
            listener.setNeedClientAuth(true);
            listener.setEnabledCipherSuites(new String[] { "TLS_AES_128_GCM_SHA256" });
            listener.setEnabledProtocols(new String[] { "TLSv1.3" });
            System.out.println("listening for messages...");
            try (Socket socket = listener.accept()) {


                InputStream is = new BufferedInputStream(socket.getInputStream());
                byte[] data = new byte[2048];
                int len = is.read(data);

                String message = new String(data, 0, len);
                OutputStream os = new BufferedOutputStream(socket.getOutputStream());
                System.out.printf("server received %d bytes: %s%n", len, message);
                String response = message + " processed by server";
                os.write(response.getBytes(), 0, response.getBytes().length);
                os.flush();
            }
        }
    }
}