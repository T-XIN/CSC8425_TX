/* A server class which receives and sends data*/

import java.io.IOException;
import java.io.PrintWriter;

import java.net.ServerSocket;
import java.net.Socket;

public class CSC8425_Server_TX {

    /*0. the entry point of your program*/
    public static void main(String[] args) throws IOException{
        final int DEFAULT_PORT = 5000;
        int port = args.length > 0? Integer.parseInt(args[0]) : DEFAULT_PORT;

        String runningMeg = "This server is running on port " + port;
        String toClientMeg = "Hello, here is a message from me, your server!";

        /*1. we need a Socket works on the server side, which is called "ServerSocket"*/
        try(ServerSocket listener = new ServerSocket(port)){
            System.out.println(runningMeg);
            while (true){
                /*2. connect our server Socket to client Socket*/
                try(Socket socket = listener.accept()){
                    /*3. send our Hello message from server to client*/
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(toClientMeg);
                }
            }
        }
    }

}
