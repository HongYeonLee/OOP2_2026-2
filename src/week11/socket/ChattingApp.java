package week11.socket;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/** 그림은 UDP, 채팅과 게임 규칙은 TCP로 서버와 통신하는 클라이언트 */
public class ChattingApp {
    private static final int SERVER_PORT = 50023;

    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        System.out.print("서버 IP : ");
        InetAddress serverAddress = InetAddress.getByName(console.nextLine());
        System.out.print("닉네임 : ");
        String nickname = console.nextLine();

        Socket tcp = new Socket(serverAddress, SERVER_PORT);
        PrintWriter tcpOut = new PrintWriter(tcp.getOutputStream(), true, StandardCharsets.UTF_8);
        tcpOut.println(nickname);                                   // 첫 줄은 닉네임

        DatagramSocket udp = new DatagramSocket();
        sendUdp(udp, serverAddress, "register");

        ChattingPanel panel = new ChattingPanel(udp, serverAddress, SERVER_PORT, tcpOut::println);
        showFrame(nickname, panel, () -> sendUdp(udp, serverAddress, "LEAVE"));

        new UdpReceiverThread(udp, panel).start();                  // 그림 수신
        listenToServer(tcp, panel);                                 // 채팅/게임 메시지 수신
    }

    private static void listenToServer(Socket tcp, ChattingPanel panel) throws IOException {
        Scanner in = new Scanner(tcp.getInputStream(), StandardCharsets.UTF_8);
        new Thread(() -> {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                SwingUtilities.invokeLater(() -> panel.handleServerMessage(line));
            }
        }).start();
    }

    private static void showFrame(String nickname, ChattingPanel panel, Runnable onClose) {
        JFrame frame = new JFrame("CatchMind : " + nickname);
        frame.add(panel);
        frame.setSize(800, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onClose.run();
            }
        });
        frame.setVisible(true);
    }

    private static void sendUdp(DatagramSocket udp, InetAddress address, String message) {
        byte[] data = message.getBytes(StandardCharsets.UTF_8);
        try {
            udp.send(new DatagramPacket(data, data.length, address, SERVER_PORT));
        } catch (IOException e) {
            System.err.println("UDP 전송 오류: " + e.getMessage());
        }
    }
}