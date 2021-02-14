import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class CSC8425_Client_TX {

    /*0. The entry point of your program*/
    public static void main(String[] args) throws IOException{

        if(args.length !=2){
            System.err.println("Need IP (localhost) and port (54321)");
            return;
        }

        /*1. Get IP and port number*/
        //String ipAddress = "127.0.0.1";
        String ipAddress = args[0];
        //int port = 5000;
        int port = Integer.parseInt(args[1]);

        String runningMeg = "Client is attempting to connect to " + ipAddress + " on port " + port;
        String serverResponseMeg = "Server responses: ";

        System.out.println(runningMeg);

        /*2. Create a socket works on the client side*/
        Socket socket = new Socket(ipAddress, port);

        /*3. Read message from the server*/
        Scanner in = new Scanner(socket.getInputStream());
        System.out.println(serverResponseMeg + in.nextLine());
    }
}
