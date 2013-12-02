package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import util.Util;

public class SeeAllStudentUI extends JFrame {
	public SeeAllStudentUI(JFrame jFrame) {
		final JFrame jMain = jFrame;
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				jMain.setVisible(true);
			}
		});
		this.setTitle("点名器-查看所有学生");
		this.setSize(420, 300);
		this.setResizable(false);
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(255, 0, 0));
		textArea.setFont(new Font("楷体_GB2312", Font.BOLD, 20));
		textArea.setBackground(new Color(204, 255, 255));

		JLabel label = new JLabel("\u663E\u793A\u5B66\u751F");
		label.setFont(new Font("楷体_GB2312", Font.PLAIN, 25));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, 414,
								Short.MAX_VALUE)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(41)
										.addComponent(textArea,
												GroupLayout.PREFERRED_SIZE,
												336, GroupLayout.PREFERRED_SIZE)
										.addGap(37)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 36,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE,
								207, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(19, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);
		int tmp = 0;
		String str = "";
		JOptionPane jp = new JOptionPane();
		for (File file : Util.getFiles()) {
			if (tmp % 4 == 0 && tmp != 0)
				str = str + '\n';
			tmp++;
			str = str + file.getName() + '\t';
		}
		if (tmp == 0) {
			jp.showMessageDialog(null, "还没有学生，去添加吧！");
			jFrame.setVisible(true);
			return;
		}
		textArea.setText(str);
		this.setVisible(true);
	}
}
