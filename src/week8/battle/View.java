package week8.battle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel p1Img;
	private JProgressBar p1Bar;
	private JLabel p2Img;
	private JProgressBar p2Bar;
	private JButton p2Attack;
	private JButton p1Attack;
	
	Player p1, p2;
	private JButton p2Heal;
	private JButton p1Heal;
	
	public View(Player p1, Player p2) {
		this();
		this.p1 = p1;
		this.p2 = p2;
		System.out.println(p1.name + "과(와) " + p2.name + " 연결");
		
		p1Img.setIcon(new ImageIcon(View.class.getResource("/week8/img/"+p1.img)));
		p2Img.setIcon(new ImageIcon(View.class.getResource("/week8/img/"+p2.img)));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
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
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(255, 128, 64));
		panel1.setBounds(31, 20, 264, 362);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		p1Img = new JLabel("");
		//p1Img.setIcon(new ImageIcon(View.class.getResource("/week8/img/블위.png")));
		p1Img.setBounds(40, 10, 188, 225);
		panel1.add(p1Img);
		
		p1Bar = new JProgressBar();
		p1Bar.setForeground(new Color(255, 0, 0));
		p1Bar.setValue(100);
		p1Bar.setBounds(27, 322, 213, 30);
		panel1.add(p1Bar);
		
		p1Attack = new JButton("공격하기");
		p1Attack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//p2의 hp를 깎는다
				//p2의 bar의 value를 갱신한다
				p1.attack(p2);
				p2Bar.setValue(p2.hp);
				
				if(p2.hp < 0) {
					p2Img.setIcon(new ImageIcon(View.class.getResource("/week8/img/"+p2.img2)));
				}
			}
		});
		p1Attack.setBounds(87, 249, 90, 22);
		panel1.add(p1Attack);
		
		p1Heal = new JButton("치유하기");
		p1Heal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//p1의 hp를 채운다
				//p1의 bar의 value를 갱신한다
				p1.heal();
				p1Bar.setValue(p1.hp);
			}
		});
		p1Heal.setBounds(87, 281, 90, 22);
		panel1.add(p1Heal);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(new Color(255, 128, 64));
		panel2.setBounds(492, 20, 264, 362);
		contentPane.add(panel2);
		
		p2Img = new JLabel("");
		//p2Img.setIcon(new ImageIcon(View.class.getResource("/week8/img/헐크.png")));
		p2Img.setBounds(48, 10, 188, 225);
		panel2.add(p2Img);
		
		p2Bar = new JProgressBar();
		p2Bar.setForeground(new Color(255, 0, 0));
		p2Bar.setValue(100);
		p2Bar.setBounds(25, 322, 213, 30);
		panel2.add(p2Bar);
		
		p2Attack = new JButton("공격하기");
		p2Attack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//p2의 hp를 깎는다
				//p2의 bar의 value를 갱신한다
				attack(p2, p1);
				
				if(p1.hp < 0) {
					p1Img.setIcon(new ImageIcon(View.class.getResource("/week8/img/"+p1.img2)));
				}
			}
		});
		p2Attack.setBounds(78, 249, 90, 22);
		panel2.add(p2Attack);
		
		p2Heal = new JButton("치유하기");
		p2Heal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//p2의 hp를 채운다
				//p2의 bar의 value를 갱신한다
				attack(p2, p1);
				
				if(p1.hp < 0) {
					p1Img.setIcon(new ImageIcon(View.class.getResource("/week8/img/"+p1.img2)));
				}
			}
		});
		p2Heal.setBounds(78, 281, 90, 22);
		panel2.add(p2Heal);

	}
	
	//공통 부분 함수로 빼기
	public void attack(Player p1, Player p2) {
		p1.attack(p2);
		p2Bar.setValue(p2.hp);
	}
}
