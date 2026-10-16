package week7.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btn1;
	private JLabel label1;

	/**
	 * Launch the application.
	 */
	//단독 테스트할 떄 사용
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View1 frame = new View1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//생성자 기본 코드
	public View1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn1 = new JButton("New button");
		btn1.addActionListener(new ActionListener() {
			//버튼 눌렀을 때 할 행동
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼이 눌렸습니다!!");
				label1.setText("버튼이 눌렸습니다!");
			}
		});
		btn1.setBounds(37, 22, 151, 162);
		contentPane.add(btn1);
		
		label1 = new JLabel("New label");
		label1.setBounds(200, 26, 140, 162);
		contentPane.add(label1);

	}
}
