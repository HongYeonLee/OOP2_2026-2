package week10;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server {
	public static final int PORT = 50023; //서버 포트

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//클라이언트들과의 연결을 위한 서버 소켓
		ServerSocket serverSocket = null; 
		//각 클라이언트에게 다른 클라이언트로부터 받은 입력을 뿌려주기 위한 모든 클라이언트로의 출력 통로 리스트
		//각 클라이언트를 담당하는 스레드는 이 리스트에 동시에 접근한다. 그러나 자바 리스트는 Thread-Safe 하지 않기 때문에
		//리스트에 동기화를 걸어준다. 리스트에 add(), remove(), get() 같은 메서드에 자동으로 자물쇠(synchronized 락)를 걸어
		//한번에 한 스레드만 리스트를 이용할 수 있게 한다.
		List<PrintWriter> listWriters = Collections.synchronizedList(new ArrayList<PrintWriter>());
		
		try {
			serverSocket = new ServerSocket(PORT); //서버 소켓 생성
			//클라이언트의 요청이 올 때마다 클라이언트별로 소켓과 스레드를 만든다. 그리고 writer를 연결한다. 이 작업은 쓰레드로 처리해야 한다.
			while(true) {
				System.out.println("연결을 기다립니다");
				Socket socket = serverSocket.accept();
				System.out.println("연결이 되었습니다");
				new ServerThread(socket, listWriters).start();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
