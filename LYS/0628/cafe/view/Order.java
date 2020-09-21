package com.kh.project.mini.cafe.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.kh.project.mini.cafe.controller.MemberController;
import com.kh.project.mini.cafe.model.vo.Member;

public class Order extends JPanel {

	private MemberController mc = new MemberController();
	private MainFrame mf;
	private Member me;
	private String temp; 
	
	public Order(MainFrame mf, Member me) {
		this.mf = mf;
		this.me = me;
		mf.setTitle("�ֹ��ϱ�");
		setLayout(new GridLayout(5, 5, 20, 20));

		String name = me.getName();
		JLabel label = new JLabel( name +  " �� ������ �ֹ��Ͻðڽ��ϱ�?");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);

		String[] drinks = { 
				"�Ƹ޸�ī��", "ī���", "ī���ī", "�ٴҶ��", "ī��Ḷ���ƶ�", 
				"��׷���", "ĳ����", "���۹�Ʈ", "����" 
		};

		JList<String> drinksList = new JList<String>(drinks);

		JPanel resultPanel = new JPanel();
		JLabel choicelabel = new JLabel("�����Ͻ� �޴�");
		JTextArea textArea = new JTextArea(20, 25);
		textArea.setLineWrap(true);
		textArea.setEditable(false);

		drinksList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				List<String> l = drinksList.getSelectedValuesList();
				String result = " ";
				for (int i = 0; i < l.size(); i++) {
					result += l.get(i) + " ";
				}
				temp = result;
				textArea.setText(result);
				
			}
		});

		resultPanel.add(choicelabel);
		resultPanel.add(textArea);
		add(resultPanel, "Center");

		JScrollPane scroller = new JScrollPane(drinksList);
		scroller.setPreferredSize(new Dimension(200, 100));
		add(scroller, "North");

		drinksList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		JButton deliveryBnt = new JButton("�ֹ��ϱ�");
		add(deliveryBnt, "South");
		deliveryBnt.addActionListener(new GoDeliveryPageListener());

		JButton logoutBtn = new JButton("������������ ���ư���");
		add(logoutBtn, "South");
		logoutBtn.addActionListener(new GoLogoutPageListener());

		mf.add(this);

	}

	class GoDeliveryPageListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "�����Ͻ� �޴��� �ֹ��Ͻðڽ��ϱ�?", "�ֹ��ϱ�", JOptionPane.YES_NO_OPTION);
			// �� ������ �ֹ��� �Ϸ�Ǿ����ϴ� �˸�â �߱�
			
			if (result == JOptionPane.YES_OPTION) { 
                JOptionPane.showMessageDialog(null, "�ֹ��� �Ϸ�Ǿ����ϴ� ! ���� ~ ", "Order", JOptionPane.INFORMATION_MESSAGE);
                String orderHistory = me.getOrderHistory();
               
                //�ֹ����� �ð� ����ϱ�
                SimpleDateFormat date = new SimpleDateFormat ("yyyy�� MM��dd�� HH��mm��ss��");
                Date time = new Date();		
                String ordetTime = date.format(time);
                
               //�ֹ�����Ȯ���ϱ�
                if(orderHistory == null) {
                	me.setOrderHistory( ordetTime + " : "+ temp);
                }else {
                	System.out.println();
                	me.setOrderHistory(orderHistory+ "\n" + date + " : "+ temp);
                }
                System.out.println("temp: " + me.getOrderHistory());
				setVisible(false);
				changePanel(new LoginAfter(mf, me));
				setVisible(true);
			} else { // if(result == JOptionPane.NO_OPTION)
				JOptionPane.showMessageDialog(null, "�ֹ��� ����ϼ̽��ϴ�. ", "Cancle", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	// �α׾ƿ� ��ư Ŭ���� �̺�Ʈ ����
	class GoLogoutPageListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "���ư��ðڽ��ϱ�?", "�ڷΰ���", JOptionPane.YES_NO_OPTION);
			// â �ݱ�, ��, �ƴϿ� ��ư Ŭ���� �̺�Ʈ ����
			if (result == JOptionPane.CLOSED_OPTION) {
				System.exit(0);
			} else if (result == JOptionPane.YES_OPTION) {
				// Yes ��ư�� ������ �α��� ���� ȭ������ ���ư���
				setVisible(false);
				changePanel(new LoginAfter(mf,me));
			}
		}
	}

	public void changePanel(JPanel panel) {
		mf.remove(this);
		mf.add(panel);
		mf.revalidate();
		mf.repaint();

	}

	public static String choicelabel() {
		// TODO Auto-generated method stub
		return null;
	}
}