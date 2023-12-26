package kiosk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class IceCreamKiosk extends JPanel {
	
	// �Ҹ�
	public void Play(String file) throws Exception
	{
	    AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(file));
	    Clip clip = AudioSystem.getClip();
	    clip.open(inputStream);
	    clip.start();
	}
	
	// 27�� �޴��̸� ��Ʈ 
	Font menu_font = new Font("DX�Ʊ���B", Font.PLAIN, 15);
	
	// ���̺� ��� ��Ʈ
    Font tbh_font = new Font("DX�Ʊ���B", Font.PLAIN, 18);
    
    // ���̺� �޴� ��Ʈ
    Font tbm_font = new Font("������ϴ�152", Font.PLAIN, 15);
    
    // �޴� ���� ��Ʈ
    Font price_font = new Font("�����м���132", Font.BOLD, 16);
    
    int count; int total=0; int col=0; int row=0; String contents = "";
	
    
    // Ű����ũ
	public IceCreamKiosk() {
		
		JFrame frame = new JFrame("IceCreamkiock");
		
		// ����,���� �г� ���� (r,g,b)
		Color northpanel_Color = new Color(180,210,230);
		
		// ���� �г� �޴���ư ���� (r,g,b)
		Color button_Color = new Color(204,255,204);
		
		// �߾� �г� ���� (r,g,b)
		Color center_Color = new Color(204,229,255);
		
		// ���� ǥ�� ����  ����) 3000 -> 3,000
		DecimalFormat df = new DecimalFormat("#,###");
        
        Panel NorthPanel = new Panel();
        NorthPanel.setBackground(northpanel_Color);
        NorthPanel.setLayout(null);
        NorthPanel.setBounds(0, 0, 520, 100);
        
        // ���θ޴� ��ư 3��
		JButton menu_bt1 = new JButton(new ImageIcon("./img/icecream.png"));
		menu_bt1.setBackground(Color.WHITE);
		menu_bt1.setBounds(75, 16, 89, 67);
		
		JButton menu_bt2 = new JButton(new ImageIcon("./img/cake.png"));
		menu_bt2.setBackground(Color.WHITE);
		menu_bt2.setBounds(223, 16, 89, 67);
		
		JButton menu_bt3 = new JButton(new ImageIcon("./img/drink.png"));
		menu_bt3.setBackground(Color.WHITE);
		menu_bt3.setBounds(370, 16, 89, 67);
		
		Panel CenterPanel = new Panel();
		CenterPanel.setLayout(null);
		CenterPanel.setBackground(center_Color);
		
		// ����Ų �ΰ� ȭ��
		JLabel br = new JLabel(new ImageIcon("./img/logo.png"));
		br.setBounds(0, 0, 534, 642);
				
		CenterPanel.add(br);
		
		// ���̽�ũ�� �޴� (������)
		String menu1[] = {"����ġ������ũ", "���κ������Ʈ", "��Ʈ���ݸ�Ĩ", 
						  "�������������", "���ý�Ÿ", "�Ƹ�����", 
						  "�����¿ܰ���","��������Ű","ü�������"};
		// ���̽�ũ�� �޴� ����
		int price1[] = {3000, 3500, 3500, 
						3700, 3700, 3700, 
						3500, 3500, 3500};
				
		// ���̽�ũ�� ����ũ �޴� (������)
		String menu2[] = {"Ǫ�� ����ũ", "���ݸ� ����ũ", "�ǽ����� ����ũ", 
						  "�䳢 ����ũ", "�͸���! ����ũ","���Ծ� ����ũ", 
						  "���� �� ����ũ","�ܸ����� ����ũ","�������� ����ũ"};
		
		// ���̽�ũ�� ����ũ �޴� ����
		int price2[] = {20000, 25000, 25000, 
						27000, 27000, 27000, 
						30000, 25000, 25000};
		
		// ���� �޴� (������)
		String menu3[] = {"�Ƹ޸�ī��(ice)", "�ݵ��� ��Ʈ", "�ٴҶ�� ��", 
						  "��Ƽũ����", "��Ƽũ�����г�","������(ice)", 
						  "����������ũ","��ũ����ũ","���⿬����"};
		
		// ���� �޴� ����
		int price3[] = {3000, 3500, 3500, 
						3700, 3700, 3700, 
						3500, 3500, 3500};
		
		JButton bt_menu1[] = new JButton[menu1.length];
		JButton bt_menu2[] = new JButton[menu2.length];
		JButton bt_menu3[] = new JButton[menu3.length];
		
        TextField num1[] = new TextField[menu1.length];
        TextField num2[] = new TextField[menu2.length];
        TextField num3[] = new TextField[menu3.length];
        
        JButton minus1[] = new JButton[menu1.length];
        JButton minus2[] = new JButton[menu2.length];
        JButton minus3[] = new JButton[menu3.length];
        
        JButton plus1[] = new JButton[menu1.length];
        JButton plus2[] = new JButton[menu2.length];
        JButton plus3[] = new JButton[menu3.length];
        
        JButton ok1[] = new JButton[menu1.length];
        JButton ok2[] = new JButton[menu2.length];
        JButton ok3[] = new JButton[menu3.length];
        
        JLabel won1[] = new JLabel[menu1.length];
        JLabel won2[] = new JLabel[menu2.length];
        JLabel won3[] = new JLabel[menu3.length];
        
        JLabel name1[] = new JLabel[menu1.length];
        JLabel name2[] = new JLabel[menu2.length];
        JLabel name3[] = new JLabel[menu3.length];
        
        // ���̽�ũ�� �޴� �̹��� (������)
        bt_menu1[0] = new JButton(new ImageIcon("./img/����ġ������ũ.png"));
        bt_menu1[1] = new JButton(new ImageIcon("./img/���κ������Ʈ.png"));
        bt_menu1[2] = new JButton(new ImageIcon("./img/��Ʈ���ݸ�Ĩ.png"));
        bt_menu1[3] = new JButton(new ImageIcon("./img/����� ���� ����.png"));
        bt_menu1[4] = new JButton(new ImageIcon("./img/���ý�Ÿ.png"));
        bt_menu1[5] = new JButton(new ImageIcon("./img/�Ƹ�����.png"));
        bt_menu1[6] = new JButton(new ImageIcon("./img/�����¿ܰ���.png"));
        bt_menu1[7] = new JButton(new ImageIcon("./img/��������Ű.png"));
        bt_menu1[8] = new JButton(new ImageIcon("./img/ü�������.png"));
        
        for (int i = 0; i < bt_menu1.length; i++) {
        	bt_menu1[i].setBackground(Color.WHITE);
        	bt_menu1[i].setBorderPainted(false);
        }
        
        // ���̽�ũ�� ����ũ �޴� �̹��� (������)
        bt_menu2[0] = new JButton(new ImageIcon("./img/Ǫ������ũ1.png"));
        bt_menu2[1] = new JButton(new ImageIcon("./img/���ݸ�����ũ1.png"));
        bt_menu2[2] = new JButton(new ImageIcon("./img/����������ũ1.png"));
        bt_menu2[3] = new JButton(new ImageIcon("./img/�䳢����ũ1.png"));
        bt_menu2[4] = new JButton(new ImageIcon("./img/�͸�������ũ1.png"));
        bt_menu2[5] = new JButton(new ImageIcon("./img/���Ծ�����ũ1.png"));
        bt_menu2[6] = new JButton(new ImageIcon("./img/���ڽ�����ũ1.png"));
        bt_menu2[7] = new JButton(new ImageIcon("./img/�ܸ���������ũ1.png"));
        bt_menu2[8] = new JButton(new ImageIcon("./img/������������ũ3.png"));
        
        for (int i = 0; i < bt_menu1.length; i++) {
        	bt_menu2[i].setBackground(Color.WHITE);
        	bt_menu2[i].setBorderPainted(false);
        }
        
        // ���� �޴� �̹��� (������)
        bt_menu3[0] = new JButton(new ImageIcon("./img/���̽��Ƹ޸�ī��.png"));
        bt_menu3[1] = new JButton(new ImageIcon("./img/�ݵ����Ʈ.png"));
        bt_menu3[2] = new JButton(new ImageIcon("./img/�ٴҶ���.png"));
        bt_menu3[3] = new JButton(new ImageIcon("./img/��Ƽũ����.png"));
        bt_menu3[4] = new JButton(new ImageIcon("./img/��Ƽũ�����г�.png"));
        bt_menu3[5] = new JButton(new ImageIcon("./img/���̽�������.png"));
        bt_menu3[6] = new JButton(new ImageIcon("./img/����������ũ.png"));
        bt_menu3[7] = new JButton(new ImageIcon("./img/��ũ����ũ.png"));
        bt_menu3[8] = new JButton(new ImageIcon("./img/���⿬����.png"));
        
        for (int i = 0; i < bt_menu1.length; i++) {
        	bt_menu3[i].setBackground(Color.WHITE);
        	bt_menu3[i].setBorderPainted(false);
        }
        
		Panel SouthPanel = new Panel();
		SouthPanel.setLayout(null);
		SouthPanel.setBounds(0,0,190,220);
		SouthPanel.setBackground(northpanel_Color);
		
		TextArea txt = new TextArea("");
		
        String[] [] data = new String[0][0];
        String[] title = {"��ǰ��","����","����","�հ�", "�� �ݾ�"};
        DefaultTableModel model = new DefaultTableModel(data, title);
        JTable table = new JTable(model);        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(7,5,520,150);
        
        // ���̺� �ȿ� ���� �� ��� ����
        DefaultTableCellRenderer tableCell = new DefaultTableCellRenderer();
        tableCell.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel CellModel = table.getColumnModel();
        for(int i = 0; i < CellModel.getColumnCount(); i++) {
        	CellModel.getColumn(i).setCellRenderer(tableCell);
        }
        
        // ���� ���̺� ���� ����
        table.getColumn("����").setPreferredWidth(10);
        table.setRowHeight(21);
       
        // ���̺� ���� ����
        table.getParent().setBackground(Color.WHITE);
        
        // ���̺� ��� ������ ����
        table.getTableHeader().setBackground(northpanel_Color);
        
        // ���̺� ��� ���ڻ� ����
        table.getTableHeader().setForeground(Color.BLACK);
        
        // ���̺� ��� ��Ʈ ����
        table.getTableHeader().setFont(tbh_font);
        
        // ���̺� ���� ��Ʈ ����
        table.setFont(tbm_font);
        
        // ���̺� �÷� �̵� �Ұ�
        table.getTableHeader().setReorderingAllowed(false);
        
        // ���̺� ũ�� ���� �Ұ�
        table.getTableHeader().setResizingAllowed(false);
              
        // ���̺� ���� ���� �Ұ�
        table.setEnabled(false);
             
        SouthPanel.add(scrollPane);
        
        // �ֹ�, �ʱ�ȭ(���̺����), ���ư��� ��ư �̹���
        JButton buy_bt = new JButton(new ImageIcon("./img/buy.png"));
        buy_bt.setBounds(7,160,160,55);
             
        JButton reset_bt = new JButton(new ImageIcon("./img/reset.png"));
        reset_bt.setBounds(187,160,160,55);
              
        JButton back_bt = new JButton(new ImageIcon("./img/back.png"));
        back_bt.setBounds(365,160,160,55);
        
 		// �޽��� â �ؽ�Ʈ ��� ����
 		JLabel buy_label = new JLabel("�ֹ��Ͻðڽ��ϱ�?");
 		buy_label.setHorizontalAlignment(SwingConstants.CENTER);
 		buy_label.setFont(tbh_font);
  
        // �ֹ���ư
        buy_bt.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int answer = JOptionPane.showConfirmDialog(CenterPanel, buy_label, "Order",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
            	if(answer == JOptionPane.YES_OPTION) {
            		if(total==0) {
            			try {
							Play("sound/error.wav");
						} catch (Exception e1) {
							e1.printStackTrace();
						}
            			JOptionPane.showMessageDialog(CenterPanel, "���� �׸��� �������� �ʽ��ϴ�");
            		} else {
                		for(int i=0; i<table.getRowCount(); i++) {
                			txt.append(table.getValueAt(i, 0)+" "+table.getValueAt(i, 1)+" X "+table.getValueAt(i, 2)+"��\n");
                		}     		
                		contents = txt.toString();
                		try {
							Play("sound/order.wav");
						} catch (Exception e1) {
							e1.printStackTrace();
						}
            			JOptionPane.showMessageDialog(CenterPanel, txt.getText()+"�� �ݾ� : "+total+"��\n"+"�ֹ��Ǿ����ϴ�. \n�̿����ּż� �����մϴ�.");
            			total=0; txt.setText(""); model.setNumRows(0);
                	}
            	} else {
            		JOptionPane.showMessageDialog(CenterPanel, "�޴� ���� �ܰ�� ���ư��ϴ�.\n");
            	}
            }
        });
        
        // �ʱ�ȭ(���̺����) ��ư
        reset_bt.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					Play("sound/reset.wav");
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
            	model.setNumRows(0); //�ֹ� ���� �ʱ�ȭ
            	txt.setText("");
            	total=0;
            }
        });
        
        // ���ư��� ��ư
        back_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Play("sound/back.wav");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();
				IceCreamChoice ic = new IceCreamChoice();
				ic.setVisible(true);
			}
	    });
		
        // ���̽�ũ�� ��ư
        menu_bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ư ������ �ʷϻ����� ����
				menu_bt1.setBackground(button_Color);
				menu_bt2.setBackground(Color.WHITE);
				menu_bt3.setBackground(Color.WHITE);
				
				CenterPanel.removeAll();
				CenterPanel.repaint();
				for (int i = 0; i < bt_menu1.length; i++) {
		        	if(i<3) {
		        		bt_menu1[i].setBounds(45 + i * 170, 30, 100, 100);
		        	} else if(i<6) {
		        		bt_menu1[i].setBounds(45 + (i - 3) * 170, 240, 100, 100);	
		        	} else {
		        		bt_menu1[i].setBounds(45 + (i - 6) * 170, 450, 100, 100);
		        	}
		        	
		        	name1[i] = new JLabel(menu1[i]);
		        	name1[i].setFont(menu_font);
		        	name1[i].setBounds(bt_menu1[i].getX() - 7, bt_menu1[i].getY() - 20, 115, 20);
		        	name1[i].setHorizontalAlignment(JLabel.CENTER);
		        	
		        	num1[i] = new TextField("0");
		            num1[i].setBackground(Color.WHITE);
		            num1[i].setEditable(false);
		            num1[i].setBounds(bt_menu1[i].getX() + 30, bt_menu1[i].getY() + 130, 40, 20);
		            
		            minus1[i] = new JButton(new ImageIcon("./img/minus.png"));
		            minus1[i].setBounds(bt_menu1[i].getX(), num1[i].getY(), 20, 20);
		            minus1[i].setEnabled(false);
		            
		            plus1[i] = new JButton(new ImageIcon("./img/plus.png"));
		            plus1[i].setBounds(bt_menu1[i].getX() + (100 - 20), num1[i].getY(), 20, 20);
		            plus1[i].setEnabled(true);
		            
		            // ���� ǥ�� ����
		            won1[i] = new JLabel("�� " + df.format(price1[i]));
		            won1[i].setBounds(bt_menu1[i].getX() + 20, num1[i].getY() - 27, 100, 20);
		            won1[i].setFont(price_font);
		            
		            ok1[i] = new JButton("���");
		            ok1[i].setFont(tbm_font);
		            ok1[i].setBounds(bt_menu1[i].getX(), num1[i].getY() + 30, 100, 20);
		            ok1[i].setEnabled(false);
		            
		            CenterPanel.add(name1[i]);
		            CenterPanel.add(bt_menu1[i]);
		            CenterPanel.add(num1[i]);
		            CenterPanel.add(minus1[i]);
		            CenterPanel.add(plus1[i]);
		            CenterPanel.add(won1[i]);
		            CenterPanel.add(ok1[i]);
		            
				}
				
		        for (int i = 0; i < menu1.length; i++) {
		            int j = i;		 
		 
		            minus1[i].addActionListener(new ActionListener() {
		            	
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                	minus1[j].setEnabled(false);
		                	int minus_count = Integer.parseInt(num1[j].getText());
		                	minus_count--;
		                	num1[j].setText(minus_count + "");              	
		                	if (minus_count > 0) {
		                		ok1[j].setEnabled(true);
		                    	minus1[j].setEnabled(true);		                		
		                	} else {
		                    	ok1[j].setEnabled(false);
		                    	minus1[j].setEnabled(false);
		                	}
		                	count = minus_count;
		                }
		            });
		            
		            plus1[i].addActionListener(new ActionListener() {
		 
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                	int plus_count = Integer.parseInt(num1[j].getText());		                	
		                	plus_count++;
		                    num1[j].setText(plus_count + "");
		                    ok1[j].setEnabled(true);
		                    if (plus_count > 0) {
		                        minus1[j].setEnabled(true);
		                    }
		                    count = plus_count;
		                }
		            });
		            
		            ok1[i].addActionListener(new ActionListener() {
		 
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                	count = Integer.parseInt(num1[j].getText());
		                	total = total + price1[j] * count;
		                	
		                	String inputStr[] = new String [5];
		                	
		                	inputStr[0] = menu1[j];
		                	inputStr[1] = "�� " + df.format(price1[j]);
		                	inputStr[2] = "" + count;
		                	inputStr[3] = "�� " + df.format(price1[j] * count);
		                	inputStr[4] = "�� " + df.format(total);
		                	model.addRow(inputStr);
		                	
		                	// �ڵ� ��ũ��
		                	table.requestFocus();
		                	table.changeSelection(model.getRowCount(),model.getColumnCount(), false, false);
		                   
		                	num1[j].setText("0");
		                	ok1[j].setEnabled(false);
		                	minus1[j].setEnabled(false);
		                }
		            });
		        }				
			}
		});
        
        // ���̽�ũ�� ����ũ ��ư
        menu_bt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ư ������ �ʷϻ����� ����
				menu_bt2.setBackground(button_Color);
				menu_bt1.setBackground(Color.WHITE);
				menu_bt3.setBackground(Color.WHITE);
				CenterPanel.removeAll();
				CenterPanel.repaint();
				for (int i = 0; i < 9; i++) {
		        	if(i<3) {
		        		bt_menu2[i].setBounds(45 + i * 170, 30, 100, 100);
		        	} else if(i<6) {
		        		bt_menu2[i].setBounds(45 + (i - 3) * 170, 240, 100, 100);		        		
		        	} else {
		        		bt_menu2[i].setBounds(45 + (i - 6) * 170, 450, 100, 100);
		        	}
		        	
		        	name2[i] = new JLabel(menu2[i]);
		        	name2[i].setFont(menu_font);
		        	name2[i].setBounds(bt_menu2[i].getX() - 7, bt_menu2[i].getY() - 20, 115, 20);
		        	name2[i].setHorizontalAlignment(JLabel.CENTER);
		        	
		        	num2[i] = new TextField("0");
		            num2[i].setBackground(Color.WHITE);
		            num2[i].setEditable(false);
		            num2[i].setBounds(bt_menu2[i].getX() + 30, bt_menu2[i].getY() + 130, 40, 20);
		            
		            minus2[i] = new JButton(new ImageIcon("./img/minus.png"));
		            minus2[i].setBounds(bt_menu2[i].getX(), num2[i].getY(), 20, 20);
		            minus2[i].setEnabled(false);
		            
		            plus2[i] = new JButton(new ImageIcon("./img/plus.png"));
		            plus2[i].setBounds(bt_menu2[i].getX() + (100 - 20), num2[i].getY(), 20, 20);
		            plus2[i].setEnabled(true);
		            
		            // ���� ǥ�� ����
		            won2[i] = new JLabel("�� " + df.format(price2[i]));
		            won2[i].setBounds(bt_menu2[i].getX() + 18, num2[i].getY() - 27, 100, 20);
		            won2[i].setFont(price_font);
		            
		            ok2[i] = new JButton("���");
		            ok2[i].setFont(tbm_font);
		            ok2[i].setBounds(bt_menu2[i].getX(), num2[i].getY() + 30, 100, 20);
		            ok2[i].setEnabled(false);
		            
		            CenterPanel.add(name2[i]);
		            CenterPanel.add(bt_menu2[i]);
		            CenterPanel.add(num2[i]);
		            CenterPanel.add(minus2[i]);
		            CenterPanel.add(plus2[i]);
		            CenterPanel.add(won2[i]);
		            CenterPanel.add(ok2[i]);
		            
				}
				
		        for (int i = 0; i < menu2.length; i++) {
		            int j = i;
		 
		            minus2[i].addActionListener(new ActionListener() {
		 
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                	minus2[j].setEnabled(false);
		                	int minus_count = Integer.parseInt(num2[j].getText());
		                	minus_count--;
		                	num2[j].setText(minus_count + "");              	
		                	if (minus_count > 0) {
		                		ok2[j].setEnabled(true);
		                    	minus2[j].setEnabled(true);		                		
		                	} else {
		                    	ok2[j].setEnabled(false);
		                    	minus2[j].setEnabled(false);
		                	}
		                	count = minus_count;
		                	
		                }
		            });
		            
		            plus2[i].addActionListener(new ActionListener() {
		 
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                	int plus_count = Integer.parseInt(num2[j].getText());		                	
		                	plus_count++;
		                    num2[j].setText(plus_count + "");
		                    ok2[j].setEnabled(true);
		                    if (plus_count > 0) {
		                        minus2[j].setEnabled(true);
		                    }
		                    count = plus_count;
		                }
		            });
		            
		            ok2[i].addActionListener(new ActionListener() {
		 
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                	count = Integer.parseInt(num2[j].getText());
		                	total = total + price2[j] * count;
		                	
		                	String inputStr[] = new String [5];
		                	
		                	inputStr[0] = menu2[j];
		                	inputStr[1] = "�� " + df.format(price2[j]);
		                	inputStr[2] = "" + count;
		                	inputStr[3] = "�� " + df.format(price2[j] * count);
		                	inputStr[4] = "�� " + df.format(total);
		                	model.addRow(inputStr);
		                	
		                	// �ڵ� ��ũ��
		                	table.requestFocus();
		                	table.changeSelection(model.getRowCount(),model.getColumnCount(), false, false);
		                   
		                	num2[j].setText("0");
		                	ok2[j].setEnabled(false);
		                	minus2[j].setEnabled(false);
		                }
		            });
		        }
			}
		});
        
        // ���� ��ư
        menu_bt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ư ������ �ʷϻ����� ����
				menu_bt3.setBackground(button_Color);
				menu_bt1.setBackground(Color.WHITE);
				menu_bt2.setBackground(Color.WHITE);
				CenterPanel.removeAll();
				CenterPanel.repaint();
				for (int i = 0; i < 9; i++) {
		        	if(i<3) {
		        		bt_menu3[i].setBounds(45 + i * 170, 30, 100, 100);
		        	} else if(i<6) {
		        		bt_menu3[i].setBounds(45 + (i - 3) * 170, 240, 100, 100);		        		
		        	} else {
		        		bt_menu3[i].setBounds(45 + (i - 6) * 170, 450, 100, 100);
		        	}
		        	
		        	name3[i] = new JLabel(menu3[i]);
		        	name3[i].setFont(menu_font);
		        	name3[i].setBounds(bt_menu3[i].getX() - 7, bt_menu3[i].getY() - 20, 115, 20);
		        	name3[i].setHorizontalAlignment(JLabel.CENTER);
		        	
		        	num3[i] = new TextField("0");
		            num3[i].setBackground(Color.WHITE);
		            num3[i].setEditable(false);
		            num3[i].setBounds(bt_menu3[i].getX() + 30, bt_menu3[i].getY() + 130, 40, 20);
		            
		            minus3[i] = new JButton(new ImageIcon("./img/minus.png"));
		            minus3[i].setBounds(bt_menu3[i].getX(), num3[i].getY(), 20, 20);
		            minus3[i].setEnabled(false);
		            
		            plus3[i] = new JButton(new ImageIcon("./img/plus.png"));
		            plus3[i].setBounds(bt_menu3[i].getX() + (100 - 20), num3[i].getY(), 20, 20);
		            plus3[i].setEnabled(true);
		            
		            // ���� ǥ�� ����
		            won3[i] = new JLabel("�� " + df.format(price3[i]));
		            won3[i].setBounds(bt_menu3[i].getX() + 20, num3[i].getY() - 27, 100, 20);
		            won3[i].setFont(price_font);
		            
		            ok3[i] = new JButton("���");
		            ok3[i].setFont(tbm_font);
		            ok3[i].setBounds(bt_menu3[i].getX(), num3[i].getY() + 30, 100, 20);
		            ok3[i].setEnabled(false);
		            
		            CenterPanel.add(name3[i]);
		            CenterPanel.add(bt_menu3[i]);
		            CenterPanel.add(num3[i]);
		            CenterPanel.add(minus3[i]);
		            CenterPanel.add(plus3[i]);
		            CenterPanel.add(won3[i]);
		            CenterPanel.add(ok3[i]);
		            
				}
				
		        for (int i = 0; i < menu3.length; i++) {
		            int j = i;
		 
		            minus3[i].addActionListener(new ActionListener() {
		 
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                	minus3[j].setEnabled(false);
		                	int minus_count = Integer.parseInt(num3[j].getText());
		                	minus_count--;
		                	num3[j].setText(minus_count + "");
		                	if (minus_count > 0) {
		                		ok3[j].setEnabled(true);
		                    	minus3[j].setEnabled(true);
		                	} else {
		                    	ok3[j].setEnabled(false);
		                    	minus3[j].setEnabled(false);
		                	}
		                	count = minus_count;
		                }
		            });
		            
		            plus3[i].addActionListener(new ActionListener() {
		 
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                	int plus_count = Integer.parseInt(num3[j].getText());
		                	plus_count++;
		                    num3[j].setText(plus_count + "");
		                    ok3[j].setEnabled(true);
		                    if (plus_count > 0) {
		                        minus3[j].setEnabled(true);
		                    }
		                    count = plus_count;
		                }
		            });
		            
		            ok3[i].addActionListener(new ActionListener() {
		 
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                	count = Integer.parseInt(num3[j].getText());
		                	total = total + price3[j] * count;
		                	
		                	String inputStr[] = new String [5];
		                	
		                	inputStr[0] = menu3[j];
		                	inputStr[1] = "�� " + df.format(price3[j]);
		                	inputStr[2] = "" + count;
		                	inputStr[3] = "�� " + df.format(price3[j] * count);
		                	inputStr[4] = "�� " + df.format(total);
		                	model.addRow(inputStr);
		                	
		                	// �ڵ� ��ũ��
		                	table.requestFocus();
		                	table.changeSelection(model.getRowCount(),model.getColumnCount(), false, false);
		                   
		                	num3[j].setText("0");
		                	ok3[j].setEnabled(false);
		                	minus3[j].setEnabled(false);
		                }
		            });
		        }
			}
		});

        SouthPanel.add(back_bt);
        SouthPanel.add(reset_bt);
        SouthPanel.add(buy_bt);
	    
		NorthPanel.add(menu_bt1);
		NorthPanel.add(menu_bt2);
		NorthPanel.add(menu_bt3);
		
		frame.setBounds(500, 20, 550, 1000);
        frame.add(NorthPanel, BorderLayout.NORTH);
        frame.add(CenterPanel, BorderLayout.CENTER);
        frame.add(SouthPanel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		// ������ ũ������ �Ұ�
		frame.setResizable(false);
	}

}
