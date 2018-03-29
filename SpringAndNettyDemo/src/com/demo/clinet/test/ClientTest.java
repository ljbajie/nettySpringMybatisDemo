package com.demo.clinet.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.message.Header;
import com.demo.message.Message;
import com.demo.userService.IUserServise;

public class ClientTest {
	@Autowired
	IUserServise userServise;
	public static void main(String[] args)  {
		Socket socket=null;
		try {
			socket=new Socket("127.0.0.1", 8888);	
			OutputStream out=socket.getOutputStream();
			Scanner scanner = new Scanner(System.in);
			while(true) {
				String send=scanner.nextLine();
				System.out.println("客户端："+send);
				byte[] by=send.getBytes("UTF-8");
				Header header=new Header((byte)1,(byte)1, (byte)1, (byte)1, (byte)1, "713f17ca614361fb257dc6741332caf2", by.length, 2);
				Message message=new Message(header, send);
				out.write(message.toByte());
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
