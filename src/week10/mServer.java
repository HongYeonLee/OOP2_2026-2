package week10;

import java.io.*;
import java.net.*;
import java.util.*;

public class mServer {
	public static final int PORT = 50023;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		// List<PrintWriter> listWriters = new ArrayList<PrintWriter>();
		// List<PrintWriter> listWriters = new CopyOnWriteArrayList<>();
		List<PrintWriter> listWriter = Collections.synchronizedList(new ArrayList<>());
	
		try {
			serverSocket = new ServerSocket();
			
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
			consoleLog(hostAddress + ":" + PORT);
			
			//여러 클라이언트의 요청을 수락하고 writer를 연결한다. 이 작업은 스레드로 처리해야 한다
			while(true) {
				Socket socket = serverSocket.accept();
				new ServerThread(socket, listWriter).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	private static void consoleLog(String log) {
		System.out.println("[server " + Thread.currentThread().getId() + "] " + log);
	}

}
