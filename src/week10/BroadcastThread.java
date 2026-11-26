package week10;

import java.io.PrintWriter;

public class BroadcastThread extends Thread{
	public BroadcastThread() {
		
	}
	
	public void run() {
		while(true) {
			
			try {
				//큐에서 메세지 하나를 꺼냄. 큐가 비었으면 들어올 때까지 대기
				String msg = QueueServer.messageQ.take();
				
				//모든 클라이언트에게 전송
				synchronized (QueueServer.listWriters) {
					for (PrintWriter out : QueueServer.listWriters) {
						out.println(msg);
					}
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
