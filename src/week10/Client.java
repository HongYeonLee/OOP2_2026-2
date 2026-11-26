package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class clientReceiveThread extends Thread{
	private Socket socket;
	private BufferedReader in;
	
	public clientReceiveThread(Socket socket, BufferedReader in) {
		this.socket = socket;
		this.in = in;
	}
	
	public void run() {
		while(true) {
			
			try {
				//서버로부터 다른 클라이언트로의 메세지 수신
				String msg = in.readLine();
				System.out.println(msg);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

class clientSendThread extends Thread{
	private Socket socket;
	private PrintWriter out;
	private Scanner sc;
	
	public clientSendThread(Socket socket, PrintWriter out) {
		this.socket = socket;
		this.out = out;
		sc = new Scanner(System.in);
	}
	
	public void run() {
		while(true) {
			//사용자에게 입력 받고 서버에 전송
			System.out.print("메세지: ");
			String msg = sc.nextLine();
			out.println(msg);
		}
	}
}

public class Client {
    private static final int SERVER_PORT = 50023;
    private static Socket socket; // static 소켓 객체 변수
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //사용자에게 입력 받는 스캐너
		
		try {
			//서버와 연결
			socket = new Socket("127.0.0.1", SERVER_PORT); 
			
			//서버로부터의 입력/출력 통로 뚫기
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8), true);
			
			//서버로부터 메세지를 수신만 하는 스레드
			new clientReceiveThread(socket, in).start();
			
			//서버로부터 메세지를 송신만 하는 스레드
			new clientSendThread(socket, out).start();
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
