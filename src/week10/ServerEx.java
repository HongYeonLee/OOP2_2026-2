package week10;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.*;

public class ServerEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = null;
		PrintWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in); //키보드에서 읽을 scanner 객체 생성
		
		try {
			listener = new ServerSocket(50023); //서버 소켓 생성
			System.out.println("연결을 기다리고 있습니다...");
			socket = listener.accept(); //클라이언트로부터 연결 요청 대기
			System.out.println("연결되었습니다.");
			
			in = new Scanner(socket.getInputStream(), "utf-8");
			out = new PrintWriter(socket.getOutputStream(), true, Charset.forName("utf-8"));
			
			while (true) {
				String inputMessage = in.nextLine(); //클라이언트로부터 한 행 읽기
				if (inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트에서 bye로 연결을 종료하였음");
					break; //bye를 받으면 연결 종료
				}
				System.out.println("클라이언트: " + inputMessage);
				System.out.print("보내기>>"); // 프롬프트
				String outputMessage = scanner.nextLine(); //키보드에서 한 행 읽기
				out.println(outputMessage); //키보드에서 읽은 문자열 종료
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
