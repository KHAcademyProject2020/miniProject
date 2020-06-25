package com.kh.project.mini.cafe.view.gui.alarm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.project.mini.cafa.model.vo.Member;
import com.kh.project.mini.cafe.view.gui.alarm.UpdatePassword.GoMyPageListener;

//�ּҺ��� GUI
public class UpdateAddress extends JPanel {
	// �ʵ�//
	private MainFrame mf;
	private Member me;
	private String id;

	private JComboBox<String> mcityOption;
	private JComboBox<String> cityOption;
	private String[] matchedCities;

	// id: LoginAgain���� �Է��� ������� ���̵�
	// me: id�� ��ġ�� �ؽø��� value(��� ����)
	// mf: ����������
	public UpdateAddress(MainFrame mf, String id, Member me) {
		this.mf = mf;
		mf.setTitle("�ּҺ���");
		this.id = id;
		this.me = me;

		// BorderLayout���� �Ѵ�.
		// Ÿ��Ʋ �� (��)
		JLabel title = new JLabel("�ּ� ����");
		title.setHorizontalAlignment(JLabel.CENTER); // �������
		add(title, "North");

		// �ּ� ���� �Է¶�(�߾�)
		JPanel changeAddressPanel = new JPanel();
		changeAddressPanel.setLayout(new GridLayout(4, 1));

		// 1. �� �Է�
		JPanel inputMcityPanel=new JPanel();
		JLabel mcityLabel = new JLabel("����");
		inputMcityPanel.add(mcityLabel);
		
		// �޺��ڽ� (�ߺ����� �Ұ�/ �����Ұ�)
		String mcities[] = { "����Ư����", // 0
				"�λ걤����", // 1
				"�뱸������", // 2
				"��õ������", // 3
				"���ֱ�����", // 4
				"����������", // 5
				"��걤����", // 6
				"����Ư����ġ��", // 7
				"��⵵", // 8
				"������", // 9
				"��û�ϵ�", // 10
				"��û����", // 11
				"����ϵ�", // 12
				"���󳲵�", // 13
				"���ϵ�", // 14
				"��󳲵�", // 15
				"����Ư����ġ��"// 16
		};

		mcityOption = new JComboBox<String>(mcities);
		inputMcityPanel.add(mcityOption);
		changeAddressPanel.add(inputMcityPanel);
		
		
		// 2. ��/��
		JPanel inputCityPanel= new JPanel();
		JLabel cityLabel = new JLabel("��/��");
		inputCityPanel.add(cityLabel);
		
		cityOption = new JComboBox<String>(new String[] { "��/�� ����" });
		inputCityPanel.add(cityOption);
		changeAddressPanel.add(inputCityPanel);
		
		// 3. ���ּ� �Է�
		JLabel detailedAddressLabel = new JLabel("�� �ּҸ� �Է����ּ���.");
		detailedAddressLabel.setHorizontalAlignment(JLabel.CENTER);
		changeAddressPanel.add(detailedAddressLabel);
		
		// JTextField ������Ʈ
		JTextField detailedAddress = new JTextField(25);		
		changeAddressPanel.add(detailedAddress);
		
		
		add(changeAddressPanel, "Center");

		// (��)
		JButton submitButton = new JButton("�ּ� �����ϱ�");
		submitButton.addActionListener(new GoUpdateAddressListener());
		add(submitButton, "Center");
		mf.add(this); // �����ӿ� �����г��� ����
		
		//���ư����ư���� => MyPage�޴� â����
		JButton backButton = new JButton("������������ ���ư���");
		add(backButton, "Center");
		backButton.addActionListener(new GoMyPageListener());
		
		
		// ������ġ (��) �����Ҷ� -> ��/�� �޺��ڽ� ������ �޶���.
		mcityOption.addActionListener(new ActionListener() {
			// �ø� �����ϸ�, ������ġ�ÿ� ���ϴ� ���� cityOption�� ��Ÿ����.

			@Override
			public void actionPerformed(ActionEvent e) {
				// mcityOption���� ������ ������ġ ��
				JComboBox cb = (JComboBox) e.getSource(); // ������ ��� ���� �̺�Ʈ������ ����´�.
				// ������ ������ġ�� �ε��� ������ ����´�.

				int selectMcityIndex = cb.getSelectedIndex();
				
				System.out.println(selectMcityIndex);

				// �׿� ���� ��/�� �ٸ����Ѵ�.
				switch (selectMcityIndex) {
				case 0: // ���� Ư����
					matchedCities = new String[] { "���α�", "�߱�", "��걸", "������", "������", "���빮��", "�߶���", "���ϱ�", "���ϱ�", "������",
							"�����", "����", "���빮��", "������", "��õ��", "������", "���α�", "��õ��", "��������", "���۱�", "���Ǳ�", "���ʱ�", "������",
							"���ı�", "������" };
					break;

				case 1: // �λ걤����
					matchedCities = new String[] { "�߱�", "����", "����", "������", "�λ�����", "������", "����", "�ϱ�", "�ؿ�뱸", "���ϱ�",
							"������", "������", "������", "������", "���", "���屺" };
					break;

				case 2:// �뱸������
					matchedCities = new String[] {
							"�߱�", "����", "����", "����", "�ϱ�", "������", "�޼���", "�޼���"
					};
					break;

				case 3:// ��õ������
					matchedCities = new String[] {
							"�߱�", "����", "����", "������", "������","����", "��籸", "����", "��ȭ��", "������", "����Ȧ��"
					};
					break;

				case 4:// ���ֱ�����
					matchedCities = new String[] {
							"����", "����", "����", "�ϱ�", "���걸"
					};
					break;

				case 5:// ����������
					matchedCities = new String[] {
							"����", "�߱�", "����", "������", "�����"
					};
					break;

				case 6:// ��걤����
					matchedCities = new String[] {
							"�߱�", "����", "����", "�ϱ�", "���ֱ�"
					};
					break;

				case 7:// ����Ư����ġ�� - ���� �Ф�
					matchedCities = new String[] {
							""
					};
					break;

				case 8: // ��⵵
					matchedCities = new String[] {
							"������", "������", "�����ν�", "�Ⱦ��", "��õ��", "�����",
							"���ý�", "����õ��", "�Ȼ��", "����", "��õ��", "������",
							"�����ֽ�", "�����", "�����", "������", "�ǿս�", "�ϳ���",
							"���ν�", "���ֽ�", "��õ��", "�ȼ���", "������", "ȭ����",
							"���ֽ�", "���ֽ�", "��õ��", "���ֽ�", "���ֱ�", "��õ��",
							"����", "����"
					};
					break;

				case 9:// ������
					matchedCities = new String[] {
							"��õ��", "���ֽ�", "������", "���ؽ�", "�¹��", "���ʽ�",
							"��ô��", "ȫõ��", "Ⱦ����", "������", "��â��", "������",
							"ö����", "ȭõ��", "�籸��", "������", "����", "��籺"
					};
					break;

				case 10:// ��û�ϵ�
					matchedCities = new String[] {
							"û�ֽ�", "���ֽ�", "��õ��", "û����", "������", "��õ��",
							"������", "��õ��", "���걺", "������", "�ܾ籺", "����"
					};
					break;

				case 11:// ��û����
					matchedCities = new String[] {
							"õ�Ƚ�", "���ֽ�", "���ɽ�", "�ƻ��", "�����", "����",
							"����", "������", "�ݻ걺", "���ⱺ", "�ο���", "��õ��",
							"û�籺", "ȫ����", "���걺", "�¾ȱ�", "������"
					};
					break;

				case 12:// ����ϵ�
					matchedCities = new String[] {
							"���ֽ�", "�����", "�ͻ��", "������", "������", "������",
							"���ֱ�", "���ȱ�", "���ֱ�", "�����", "�ӽǱ�", "��â��",
							"��â��", "�ξȱ�"
					};
					break;

				case 13:// ���󳲵�
					matchedCities = new String[] {
							"������", "������", "��õ��", "���ֽ�", "�����", "��籺",
							"���", "���ʱ�", "���ﱺ", "������", "ȭ����", "���ﱺ",
							"������", "�س���", "���ϱ�", "���ȱ�", "����", "������",
							"�强��", "�ϵ���", "������", "�žȱ�"
					};
					break;

				case 14:// ���ϵ�
					matchedCities = new String[] {
							"���׽�", "���ֽ�", "��õ��", "�ȵ���", "���̽�", "���ֽ�",
							"��õ��", "���ֽ�", "�����", "����", "������", "�Ǽ���",
							"û�۱�", "���籺", "������", "û����", "��ɱ�", "���ֱ�",
							"ĥ�", "��õ��", "��ȭ��", "������", "�︪��"
					};
					break;

				case 15:// ��󳲵�
					matchedCities = new String[] {
							"â����", "�����", "���ֽ�", "���ؽ�", "�뿵��", "��õ��",
							"���ؽ�", "�о��", "������", "����", "�Ƿɱ�", "�Ծȱ�",
							"â�籺", "����", "���ر�", "�ϵ���", "��û��", "�Ծ籺",
							"��â��", "��õ��"
					};
					break;

				case 16:// ����Ư����ġ��
					matchedCities = new String[] {
							"���ֽ�", "��������"
					};
					break;
				}
				
				
				System.out.println(Arrays.toString(matchedCities));
				cityOption = new JComboBox<String>(matchedCities);
				System.out.println(cityOption.toString());

			}
		});
	}
	
	//���ư��� ��ư ������  MyPage�� �Ѿ��
		class GoMyPageListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(new MyPage(mf, me));
				
			}
		}
		
		
	// submitButton ��ư�� ������ ����
	// 3���� �Է¶��� ��� �Էµ� ���¶��?
	class GoUpdateAddressListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}

	// �г� ���� - �ּ� ������ ���������� �̷����� LoginAfter�������� �̵�
	public void changePanel(JPanel panel) {
		mf.remove(this); // ���� �г��� �����
		mf.add(panel);// ���ο� �гη� �ٲ۴�.
		mf.revalidate();
		mf.repaint();
	}
}
