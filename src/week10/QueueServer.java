package week10;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueServer {
	public static BlockingQueue<String> messageQ = new LinkedBlockingQueue<>();
	public static List<PrintWriter> listWriters = Collections.synchronizedList(new ArrayList<PrintWriter>());
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(50023);
			
			//브로드캐스팅 전담 스레드
			new BroadcastThread().start();
			
			while (true) {
				
				System.out.println("연결을 기다립니다");
				Socket socket = serverSocket.accept();
				System.out.println("연결되었습니다");
				System.out.println("=================");
				new QServerThread(socket).start();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
