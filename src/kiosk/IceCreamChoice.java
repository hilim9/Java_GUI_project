package kiosk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class IceCreamChoice extends JFrame {
	
	public void Play(String file) throws Exception
	{
	    AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(file));
	    Clip clip = AudioSystem.getClip();
	    clip.open(inputStream);
	    clip.start();
	}
	
	// 매장, 포장 버튼 폰트
	Font bt_font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	
	// 메시지 폰트
	Font msg_font = new Font("DX아기사랑B", Font.PLAIN, 18);
	
	public IceCreamChoice() {
		
		Color msg_Color = new Color(204,229,255);
		
		setTitle("선택 화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		setBounds(500, 20, 550, 980);
		
		JPanel center = new JPanel(new GridLayout());
		center.setBackground(Color.WHITE);
		c.add(center);
		
		JLabel screen = new JLabel(new ImageIcon("./img/ima.jpg"));
		center.add(screen);
		
		JPanel SouthPanel = new JPanel(new FlowLayout());
		SouthPanel.setPreferredSize(new Dimension(30, 53));
		SouthPanel.setBackground(Color.WHITE);
		c.add(SouthPanel,BorderLayout.SOUTH);
		
		JButton mejang = new JButton("매장식사");
		mejang.setFont(bt_font);
		
		// 글자 테두리 삭제
		mejang.setFocusPainted(false);
		
		// 전체 테두리 삭제
		mejang.setBorderPainted(false);
		
		JButton pojang = new JButton("포장주문");
		pojang.setFont(bt_font);
			
		// 글자 테두리 삭제
		pojang.setFocusPainted(false);
		
		// 전체 테두리 삭제
		pojang.setBorderPainted(false);

		mejang.setBackground(Color.WHITE);
		mejang.setPreferredSize(new Dimension(250, 40));
		pojang.setBackground(Color.WHITE);
		pojang.setPreferredSize(new Dimension(250, 40));
		
		SouthPanel.add(mejang);
		SouthPanel.add(pojang);
				
		// 메시지 관련 코드
		UIManager ui = new UIManager();
		ui.put("OptionPane.background", msg_Color);
		ui.put("Panel.background", msg_Color);
		ui.put("Button.background", Color.WHITE);
		ui.put("OptionPane.buttonFont", msg_font);
		ui.put("OptionPane.messageFont", msg_font);
		
		// 메시지 버튼 테두리 삭제
		ui.put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));
						
		// 가운데 정렬
		JLabel mejang_label = new JLabel("매장에서 식사하시겠습니까?");
		mejang_label.setHorizontalAlignment(SwingConstants.CENTER);
		mejang_label.setFont(msg_font);
		
		mejang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(IceCreamChoice.this, mejang_label, "mejang", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
				if(answer == JOptionPane.YES_OPTION) {
					try {
						Play("sound/mejang_pojang.wav");
					} catch (Exception e1) {
						e1.printStackTrace();						
					}
					IceCreamKiosk ic = new IceCreamKiosk();
					ic.setVisible(true);
					setVisible(false);
				}				
			}
		});
		
		// 가운데 정렬
		JLabel pojang_label = new JLabel("포장하시겠습니까?");
		pojang_label.setHorizontalAlignment(SwingConstants.CENTER);
		pojang_label.setFont(msg_font);
			
		pojang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(IceCreamChoice.this, pojang_label, "pojang", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
				if(answer == JOptionPane.YES_OPTION) {
					try {
						Play("sound/mejang_pojang.wav");
					} catch (Exception e1) {
						e1.printStackTrace(); 
					}
					IceCreamKiosk ic = new IceCreamKiosk();
					ic.setVisible(true);
					setVisible(false);
				}
			}
		});
		
		setVisible(true);
		
		// 창 크기조절 불가
		setResizable(false);;
		
	}
		
	public static void main(String[] args) {
		new IceCreamChoice();
	}
	
}
