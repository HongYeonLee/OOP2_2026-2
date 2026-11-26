package week10;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ServerThread extends Thread{
	private String ID = null; 		//클라이언트의 ID
	private Socket socket = null;	//클라이언트 소켓
	List<PrintWriter> lw = null;	//모든 클라이언트로의 출력 통로
	private PrintWriter out; 		
	
	public ServerThread(Socket socket, List<PrintWriter> lw) {
		this.socket = socket;
		this.lw = lw;
	}
	
	@Override
	public void run() {
		try {
			//클라이언트로의 입력/출력 통로 뚫기
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8), true);
			//모든 클라이언트로의 출력 통로에 지금 새로 만든 통로 추가
			addWriter(out);
			
			while(true) {
				//클라이언트에게 입력 받기
				String msg = in.readLine();
				//다른 클라이언트에게 뿌려주기
				send(msg); 
			}
		
		} catch(IOException e) {
			
		}
	}
	public void addWriter(PrintWriter out) {
		synchronized(lw) {
			lw.add(out);
		}
	}
	
	public void send(String msg) {
		synchronized(lw){
			for(PrintWriter pw: lw) {
				if(this.out == pw) continue;
				pw.println(msg);
			}
		}
	}

}
