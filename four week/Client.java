package ReceiveSend;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket socket= null;
        OutputStream os=null;
        try {
            InetAddress serveIP=InetAddress.getByName("127.0.0.1");
            int port=9999;
            socket=new Socket(serveIP,port);
             os= socket.getOutputStream();
            Scanner in=new  Scanner(System.in);
            String ha=in.next();
            os.write(ha.getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (os!=null){
                try{os.close();}
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
           try {
            socket.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
            }
        }
    }
}
