package week11.socket;


import java.awt.Point;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
import javax.swing.SwingUtilities;

public class UdpReceiverThread extends Thread {
    private final DatagramSocket socket;
    private final DrawingPanel panel;

    public UdpReceiverThread(DatagramSocket socket, DrawingPanel panel) {
        this.socket = socket;
        this.panel = panel;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[1024];
        while (!socket.isClosed()) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            try {
                socket.receive(packet);
                String msg = new String(packet.getData(), 0, packet.getLength(), StandardCharsets.UTF_8);
                if (msg.startsWith("draw:")) {
                    String[] c = msg.substring(5).split(",");
                    Point p1 = new Point(Integer.parseInt(c[0]), Integer.parseInt(c[1]));
                    Point p2 = new Point(Integer.parseInt(c[2]), Integer.parseInt(c[3]));
                    SwingUtilities.invokeLater(() -> panel.addLine(p1, p2));  // 화면은 EDT에서
                }
                else if (msg.equals("clear")) {
                    SwingUtilities.invokeLater(() -> panel.clearCanvas());   // 받은 쪽은 전송하지 않고 지우기만
                }
                
                
            } catch (IOException e) {
                if (socket.isClosed()) break;
                System.err.println("수신 오류: " + e.getMessage());
            } catch (RuntimeException e) {             // 잘못된 형식의 패킷은 무시
                System.err.println("잘못된 패킷 무시: " + e);
            }
        }
    }
}