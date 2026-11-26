package week10;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.*;

public class ServerEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = null;				//클라이언트로부터 오는 입력 읽을 스캐너 (바이트 -> 문자열)
		PrintWriter out = null;			//서버로부터 나가는 문자열 출력기 (문자열 -> 바이트)
		ServerSocket listener = null;	//서버 소켓, 클라이언트와의 연결 담당
		Socket socket = null;			//클라이언트 소켓
		Scanner scanner = new Scanner(System.in); //키보드에서 읽을 scanner 객체 생성
		
		try {
			listener = new ServerSocket(50023); //서버 소켓 생성
			System.out.println("연결을 기다리고 있습니다...");
			socket = listener.accept(); //클라이언트로부터 연결 요청 대기
			System.out.println("연결되었습니다.");
			
			in = new Scanner(socket.getInputStream(), "utf-8");		//입력 통로 생성, 바이트 -> 문자열 변환기 감싸줌
			out = new PrintWriter(socket.getOutputStream(), true, Charset.forName("utf-8"));	//출력 통로 생성, 문자열 -> 바이트 변환기 감싸줌
			
			while (true) {
				
				System.out.print("보내기>>"); // 프롬프트
				String outputMessage = scanner.nextLine(); //서버의 키보드에서 한 행 읽기
				out.println(outputMessage); //키보드에서 읽은 문자열 전달
				
				String inputMessage = in.nextLine(); //클라이언트로부터 한 행 읽기
				System.out.println("클라이언트: " + inputMessage);
				
					
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
