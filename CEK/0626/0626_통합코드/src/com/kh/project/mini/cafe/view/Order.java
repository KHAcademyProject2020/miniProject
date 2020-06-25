package com.kh.project.mini.cafe.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	public Order(MainFrame mf, Member me) {
		this.mf = mf;
		this.me = me;
		mf.setTitle("주문하기");
		setBounds(700, 300, 300, 400);

		setLayout(new GridLayout(5, 5, 20, 20));

		JLabel label = new JLabel(getName() + "고객님 무엇을 주문하시겠습니까?");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);

		String[] drinks = { 
				"아메리카노", "카페라떼", "카페모카", "바닐라라떼", "카라멜마끼아또", 
				"얼그레이", "캐모마일", "페퍼민트", "녹차" 
		};

		JList<String> drinksList = new JList<String>(drinks);

		JPanel resultPanel = new JPanel();
		JLabel choicelabel = new JLabel("선택하신 메뉴");
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

		JButton deliveryBnt = new JButton("주문하기");
		add(deliveryBnt, "South");
		deliveryBnt.addActionListener(new GoDeliveryPageListener());

		JButton logoutBtn = new JButton("이전페이지로 돌아가기");
		add(logoutBtn, "South");
		logoutBtn.addActionListener(new GoLogoutPageListener());

		mf.add(this);

	}

	class GoDeliveryPageListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "선택하신 메뉴를 주문하시겠습니까?", "주문하기", JOptionPane.YES_NO_OPTION);
			// 예 누르면 주문이 완료되었습니다 알림창 뜨기
			if (result == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "주문이 완료되었습니다 ! 슝슝 ~ ", "Order", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
				changePanel(new LoginAfter(mf, me));
				setVisible(true);
			} else { // if(result == JOptionPane.NO_OPTION)
				JOptionPane.showMessageDialog(null, "주문을 취소하셨습니다. ", "Cancle", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	// 로그아웃 버튼 클릭시 이벤트 생성
	class GoLogoutPageListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "돌아가시겠습니까?", "뒤로가기", JOptionPane.YES_NO_OPTION);
			// 창 닫기, 예, 아니오 버튼 클릭시 이벤트 생성
			if (result == JOptionPane.CLOSED_OPTION) {
				System.exit(0);
			} else if (result == JOptionPane.YES_OPTION) {
				// Yes 버튼을 누르면 로그인 이후 화면으로 돌아가기
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
}
