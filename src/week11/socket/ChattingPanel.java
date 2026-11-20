package week11.socket;

import java.awt.BorderLayout;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/** 그림판(DrawingPanel)에 역할(출제자/맞히는 사람)과 채팅창을 더한 패널 */
public class ChattingPanel extends DrawingPanel {
    private final JLabel status = new JLabel("대기 중...");
    private final JButton clearButton = new JButton("지우기");
    private final JTextArea chatLog = new JTextArea(6, 20);
    private final JTextField chatInput = new JTextField();
    private boolean drawer = false;

    public ChattingPanel(DatagramSocket socket, InetAddress address, int port, Consumer<String> chatSender) {
        super(socket, address, port);

        clearButton.setEnabled(false);
        clearButton.addActionListener(e -> clearAndSend());
        chatInput.addActionListener(e -> sendChat(chatSender));

        setLayout(new BorderLayout());
        add(createTopBar(), BorderLayout.NORTH);
        add(createChatBox(), BorderLayout.SOUTH);
    }

    /** 출제자일 때만 그릴 수 있다. */
    @Override
    protected boolean canDraw() {
        return drawer;
    }

    /** 서버(TCP)에서 받은 한 줄을 처리한다. 반드시 EDT에서 호출할 것. */
    public void handleServerMessage(String line) {
        String[] parts = line.split(" ", 2);
        String command = parts[0];
        String content = parts.length > 1 ? parts[1] : "";

        switch (command) {
            case "DRAWER":  startAsDrawer(content);  break;
            case "GUESSER": startAsGuesser(content); break;
            case "CLEAR":   clearCanvas();           break;
            case "CHAT":    appendChat(content);     break;
            default:        break;
        }
    }

    private void startAsDrawer(String word) {
        setRole(true, "제시어: " + word + "  (그려 주세요!)");
    }

    private void startAsGuesser(String wordLength) {
        setRole(false, "맞혀 보세요! (" + wordLength + "글자)");
    }

    private void setRole(boolean isDrawer, String message) {
        drawer = isDrawer;
        clearButton.setEnabled(isDrawer);
        chatInput.setEnabled(!isDrawer);
        status.setText(message);
    }

    private void sendChat(Consumer<String> chatSender) {
        String text = chatInput.getText().trim();
        chatInput.setText("");
        if (!text.isEmpty()) {
            chatSender.accept(text);
        }
    }

    private void appendChat(String text) {
        chatLog.append(text + "\n");
        chatLog.setCaretPosition(chatLog.getDocument().getLength());   // 항상 마지막 줄이 보이게
    }

    private JPanel createTopBar() {
        JPanel bar = new JPanel();
        bar.add(status);
        bar.add(clearButton);
        return bar;
    }

    private JPanel createChatBox() {
        chatLog.setEditable(false);
        JPanel box = new JPanel(new BorderLayout());
        box.add(new JScrollPane(chatLog), BorderLayout.CENTER);
        box.add(chatInput, BorderLayout.SOUTH);
        return box;
    }
}