package ReceiveSend;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serve {
    public static void main(String[] args) throws IOException {
        ServerSocket serveSocket=null;
        Socket socket=null;
        InputStream is=null;
        ByteArrayOutputStream na=null;
        try{serveSocket=new ServerSocket(9999);
        socket= serveSocket.accept();
        is= socket.getInputStream();
        na=new ByteArrayOutputStream();
        byte[] buf=new byte[1000];
        int lon;
        while((lon= is.read(buf))!=-1)
        {na.write(buf,0,lon);}
        System.out.println(na.toString());}
        catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (na!=null){
                try{na.close();}catch (IOException e) {
                    e.printStackTrace();
                }}
                if (is!=null){
                    try{is.close();}catch (IOException e) {
                        e.printStackTrace();
                    }}
                    if (socket!=null){
                        try{socket.close();}catch (IOException e) {
                            e.printStackTrace();
                        }}
                        if (serveSocket!=null){
                            try{serveSocket.close();}catch (IOException e) {
                                e.printStackTrace();
                            }}
            }
        }
    }

