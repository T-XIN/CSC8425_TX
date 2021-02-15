import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CSC8425_Client_TX {

    /*0. The entry point of your program*/
    public static void main(String[] args) throws IOException{

        /*1. choose IP and port number to connect*/
        if(args.length !=2){
            System.err.println("Need IP (localhost) and port (54321)");
            return;
        }
        String ipAddress = args[0];
        int port = Integer.parseInt(args[1]);

        String runningMeg = "Client is attempting to connect to " + ipAddress + " on port " + port;
        String serverResponseMeg = "Server responses: ";

        System.out.println(runningMeg);

        /*2. Create a socket works on the client side*/
        Socket socket = new Socket(ipAddress, port);

        /*3. How user input will be received and processed*/
        System.out.println("Enter lines of text then Ctrl+D to quit");
        Scanner scanner = new Scanner(System.in);
        Scanner in = new Scanner(socket.getInputStream());
        /*4. send data to the server*/
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        while (scanner.hasNext()){
            /*5. take user input, send it to server*/
            out.println(scanner.nextLine());
            /*6. show the response from the server*/
            System.out.println(in.nextLine());
        }

    }
}
