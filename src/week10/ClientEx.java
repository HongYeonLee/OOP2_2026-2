package week10;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientEx {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = null;
		PrintWriter out = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in); // 키보드에서 읽을 scanner 객체 생성
		
		try {
			socket = new Socket("127.0.0.1", 50023); //클라이언트 소켓 생성, 서버에 연결
			in = new Scanner(socket.getInputStream());
			out = new PrintWriter(socket.getOutputStream(), true);
			
			while (true) {
				System.out.print("보내기>>"); //프롬프트
				String outputMessage = scanner.nextLine(); //키보드에서 한 행 읽기
				
				if (outputMessage.equalsIgnoreCase("bye")) { //bye 문자열 전송
					out.println(outputMessage);//bye 문자열 전송
					break; //사용자가 bye를 입력한 경우 서버로 전송 후 실행 종료
				}
				out.println(outputMessage); //키보드에서 읽은 문자열 전송
				String inputMessage = in.nextLine(); //서버로부터 한 행 수신
				System.out.println("서버: " + inputMessage);
			}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
			socket.close();
		}
	}

