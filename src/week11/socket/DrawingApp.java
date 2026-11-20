package week11.socket;


import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//View
public class DrawingApp {
    public static void main(String[] args) throws Exception {
    	Scanner input = new Scanner(System.in);
    	
    	DatagramSocket udpSocket = new DatagramSocket(); // 자동 포트 할당
    	System.out.print("서버 IP : ");  //
    	String ip=input.nextLine();
    	InetAddress serverAddress = InetAddress.getByName(ip);
    	int serverPort = 50023;  //서버측 수신port는 50023으로 고정함. 서버역할을 하는 PC라면 방화벽에서 열어두세요

    	
    	//연결정보 확인용
    	String register = "register";
    	byte[] data = register.getBytes();
    	DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, serverPort);
    	udpSocket.send(packet);

    	
        JFrame frame = new JFrame("CatchMind ver1 : 그림판 공유!");
        DrawingPanel panel = new DrawingPanel(udpSocket, serverAddress, serverPort);
        
        
        JButton clearBtn = new JButton("지우기");
        clearBtn.addActionListener(e -> panel.clearAndSend());

        JPanel toolbar = new JPanel();
        toolbar.add(clearBtn);

        frame.add(toolbar, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    byte[] bye = "LEAVE".getBytes(StandardCharsets.UTF_8);
                    udpSocket.send(new DatagramPacket(bye, bye.length, serverAddress, serverPort));
                } catch (Exception ex) { /* 종료 중이므로 무시 */ }
            }
        });

        new UdpReceiverThread(udpSocket, panel).start();
    }
}
