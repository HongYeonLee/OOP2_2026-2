package week10;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientEx {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = null;			//서버로부터 오는 입력을 읽을 스캐너 (바이트 -> 문자열)
		PrintWriter out = null;		//클라이언트로부터 나가는 문자열 출력기
		Socket socket = null;		//클라이언트 소켓
		Scanner scanner = new Scanner(System.in); //클라이언트 키보드에서 읽을 scanner 객체 생성
		
		try {
			socket = new Socket("127.0.0.1", 50023); //클라이언트 소켓 생성, 서버에 연결
			in = new Scanner(socket.getInputStream());	//입력 통로 생성, 바이트 -> 문자열 변환기 감싸줌
			out = new PrintWriter(socket.getOutputStream(), true);	//출력 통로 생성, 문자열 -> 바이트 변환기 감싸줌
			
			while (true) {
				
				System.out.print("보내기>>"); //프롬프트
				String outputMessage = scanner.nextLine(); //클라이언트 키보드에서 한 행 읽기
				out.println(outputMessage);
				
				String inputMessage = in.nextLine(); //서버로부터 한 행 수신
				System.out.println("서버: " + inputMessage);
			}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
			socket.close();
		}
	}

