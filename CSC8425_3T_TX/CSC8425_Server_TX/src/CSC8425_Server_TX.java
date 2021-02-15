/* A server class which receives and sends data*/

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CSC8425_Server_TX {

    //*0. the entry point of your program*//*
    public static void main(String[] args) throws IOException{
        /*pre-defined text string array*/
        String[] thoughts = {
                "To be, or not to be...",
                "For a man to conquer himself is the first and noblest of all victories...",
                "Everything we hear is an opinion, not a fact. Everything we see is a perspective, not the truth..."
        };
        /*1. set working port*/
        final int DEFAULT_PORT = 5000;
        int port = args.length > 0? Integer.parseInt(args[0]) : DEFAULT_PORT;

        //pre-defined messages
        String runningMeg = "This server is running on port " + port;
        String toClientMeg = "Hello, here is a message from me, your server!";

        /*2. we need a Socket works on the server side, which is called "ServerSocket"*/
        try(ServerSocket listener = new ServerSocket(port)){
            System.out.println(runningMeg);
            while (true){
                /*3. connect our server Socket to client Socket*/
                try(Socket socket = listener.accept()){

                    /*3.1 how the input from client will be received and processed*/
                    Scanner in = new Scanner(socket.getInputStream());
                    /*3.2 handle multiple lines of input from the client*/
                    while(in.hasNext()){
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        /*3.3 send our Hello message from server to client*/
                        out.println(thoughts[Integer.parseInt(in.nextLine())]);
                        //out.println(toClientMeg);
                    }
                }
            }
        }
    }

}
