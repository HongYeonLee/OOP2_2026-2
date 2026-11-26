package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class QServerThread extends Thread{
	private Socket socket;
	
	public QServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
			addPrintWriter(out);
			
			while (true) {
				String msg = in.readLine(); 		//클라이언트에게 입력받음
				QueueServer.messageQ.offer(msg); 	//메세지큐에게 입력받은 내용을 서버의 메세지 큐에 전달
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addPrintWriter(PrintWriter out) {
		// TODO Auto-generated method stub
		synchronized(QueueServer.listWriters){ //락 걸고
			QueueServer.listWriters.add(out);
		}
	}
}
