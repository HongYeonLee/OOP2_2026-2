package week11.socket;


import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
    private final List<int[]> lines = new ArrayList<>();   // 그린 선 저장 (EDT에서만 접근)
    private Point lastPoint = null;
    private final DatagramSocket udpSocket;
    private final InetAddress peerAddress;
    private final int peerPort;

    public DrawingPanel(DatagramSocket socket, InetAddress address, int port) {
        this.udpSocket = socket;
        this.peerAddress = address;
        this.peerPort = port;

        setBackground(Color.WHITE);

        MouseAdapter mouse = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastPoint = e.getPoint();              // 누른 지점부터 선이 시작되도록
            }
            @Override
            public void mouseDragged(MouseEvent e) {
                Point current = e.getPoint();
                if (lastPoint != null) {
                    sendDrawData(lastPoint, current);
                    addLine(lastPoint, current);
                }
                lastPoint = current;
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                lastPoint = null;
            }
        };
        addMouseListener(mouse);
        addMouseMotionListener(mouse);   // MouseAdapter 하나로 둘 다 처리
    }

    // 선을 저장하고 다시 그리기 요청 (반드시 EDT에서 호출)
    void addLine(Point p1, Point p2) {
        lines.add(new int[] { p1.x, p1.y, p2.x, p2.y });
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.BLACK);
        for (int[] l : lines) {
            g2.drawLine(l[0], l[1], l[2], l[3]);
        }
    }

 // 내 화면만 지움 (EDT에서 호출)
    void clearCanvas() {
        lines.clear();
        lastPoint = null;
        repaint();
    }

    // 버튼용: 내 화면을 지우고 다른 사람에게도 알림
    void clearAndSend() {
        clearCanvas();
        sendMessage("clear");
    }

    private void sendDrawData(Point p1, Point p2) {
        sendMessage("draw:" + p1.x + "," + p1.y + "," + p2.x + "," + p2.y);
    }

    // 문자열 하나를 서버로 전송 (draw, clear 등 공통)
    private void sendMessage(String message) {
        byte[] data = message.getBytes(StandardCharsets.UTF_8);
        try {
            udpSocket.send(new DatagramPacket(data, data.length, peerAddress, peerPort));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

	/** 출제자일 때만 그릴 수 있다. */
	protected boolean canDraw() {
		// TODO Auto-generated method stub
		return false;
	}
}