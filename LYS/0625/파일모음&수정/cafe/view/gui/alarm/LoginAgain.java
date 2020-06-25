package com.kh.project.mini.cafe.view.gui.alarm;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.project.mini.cafa.controller.MemberController;
import com.kh.project.mini.cafa.model.vo.Member;

public class LoginAgain extends JPanel {
	// ���� CafeView�� �ʱ�ȭ - ��Ʈ�����̶� ������.
	private MemberController mc = new MemberController();
	private MainFrame mf;
	private JTextField idText;
	private JPasswordField pwdText;
	private String menuName;
	private int menuIdx;

	// ������
	// �α����� �Է��ؾ��Ѵ�.
	public LoginAgain(MainFrame mf, String menuName, int menuIdx) {

//		//�ʿ� root�� �����ϴ��� Ȯ��
//		//�ؽø�
//		HashMap<String, Member> map=mc.enrolledMembers();
//		System.out.print("result: "+map.containsKey("root")  );
		mf.setTitle("Ŀ�Ǳ� - �α���");
		this.mf = mf; // ���������� �ʱ�ȭ

		this.menuName=menuName;
		this.menuIdx=menuIdx;
		
		// �α��� ȭ���� ���̾ƿ� ����.
		setLayout(new GridLayout(0, 1));

		JLabel label1 = new JLabel("���̵�� ��й�ȣ�� �Է����ּ���.");
		add(label1);
		label1.setHorizontalAlignment(JLabel.CENTER);

		JLabel idLabel = new JLabel("ID");
		add(idLabel);

		idText = new JTextField(10);
		idText.setBounds(100, 10, 160, 25);
		add(idText);

		JLabel pwdLabel = new JLabel("PW");
		add(pwdLabel);
		pwdText = new JPasswordField(20);
		add(pwdText);

		JButton submitButton = new JButton("�α���");
		submitButton.setPreferredSize(new Dimension(45, 28));
		add(submitButton, "Center");
		add(submitButton);

		// �α��� ��ư�� ������ ����Ǵ� �̺�Ʈ ������
		// �Է��� ���̵�� �н����尡, ��ϵ� ���̵����� Ȯ���Ѵ�.
		// �״����� MemberController�� �ؽøʿ� ��ϵ� ���̵�� �н������ ��ġ���� Ȯ��.
		submitButton.addActionListener(new GoEditPage());
		
		// ���� �г��� ���������� ����(ȭ�麯��)
		mf.add(this);
	}
	
	
	// ����Ŭ���� - ���������� public�ȵ�
	// submitButton�� ������ ��ưŬ�� �̺�Ʈ ������.
	class GoEditPage implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// yourID, yourPW���� �Է��� id�� ��й�ȣ �ؽ�Ʈ�� �ҷ�����
			String inputID = idText.getText();
			String inputPW = mc.getPassWordToText(pwdText.getPassword());

			// �Է��� ���̵� ��ϵǾ����� ���� ���̵���
			if (!mc.isDuplicatedMember(inputID)) {
				// �����޽��� Dialog�� ������.
				JOptionPane.showMessageDialog(null, "��ϵǾ� ���� ���� ���̵��Դϴ�!", "�α��� ����", JOptionPane.ERROR_MESSAGE);
			} else {

				// �Է��� ���̵� ��ϵǾ��ִ� ���̵���
				// �ؽøʿ� ����� ���̵�� �н������
				// �Է��� ���̵�� �н����尡 ��ġ���� Ȯ���Ѵ�.
				Member me = mc.logIn(inputID, inputPW);
				if (me != null) {
					// �α��� ����
					String userName = me.getName();

					// Dialog�� ����- �α��� �����޽���
					JOptionPane.showMessageDialog(null, userName+"�� ���� ���� �߽��ϴ�!", "�α��� ����", JOptionPane.PLAIN_MESSAGE);

					// menuIdx: ����Ʈ���� Ŭ���� �޴��� �ε�����ȣ
					// menuName: �������������� ������ �޴��̸�
					System.out.println(menuIdx);
					System.out.println(menuName);

					// menuIdx�� ���� ������ �ҷ��� �������� �ٸ���.
					// menuIdx : 2~6

					switch (menuIdx) {
					case 2: // ��й�ȣ ����
						changePanel(new UpdatePassword(mf, inputID, me));
						break;

					case 3: // �̸�����
						changePanel(new UpdateName(mf, inputID, me));
						break;

					case 4:// ���Ϻ���
						changePanel(new UpdateBirthDay(mf, inputID, me));
						break;

					case 5: // �ּҺ���
						changePanel(new UpdateAddress(mf, inputID ,me));
						break;

					case 6: // ȸ��Ż��
						//JDialog �� �ҷ��ͼ� ȸ��Ż�� �Ұ������� Ȯ��.
						//�ű⼭ ���� ���� ���� Ż��ó���� �Ѵ�.
						break;
					}

				} else {
					// �α��� ����
					JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�!\n�ٽ��Է����ּ���!", "�α��� ����",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	//�޼ҵ� - �г� ����
	public void changePanel(JPanel panel) {
		// �������� �����г��� ����
		mf.remove(this);
		mf.add(panel);

		mf.revalidate();
		mf.repaint();
	}
}
