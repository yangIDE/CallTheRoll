package ui;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.HeadlessException;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

import util.Util;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;

public class MainUI {
	/**
	 * @wbp.parser.entryPoint
	 */
	public void one() {
		final JFrame jFrame = new JFrame("点名器");
		final JOptionPane jp = new JOptionPane();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(420, 300);
		jFrame.getContentPane().setForeground(Color.WHITE);
		jFrame.setResizable(false);
		JLabel label = new JLabel("请选择操作");
		label.setBackground(Color.WHITE);
		label.setForeground(Color.BLUE);
		label.setFont(new Font("黑体", Font.PLAIN, 25));
		label.setHorizontalAlignment(SwingConstants.CENTER);

		JButton button = new JButton("随机点名");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jFrame.setVisible(false);
				RandomUI r = new RandomUI(jFrame);
			}
		});

		JButton button_2 = new JButton("添加新学生");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = jp.showInputDialog("输入学生姓名：");
				try {
					if (name != null) {
						Util.insertStudent(name);
						jp.showMessageDialog(null, "学生" + name + "，添加成功！");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton button_4 = new JButton("删除所有学生");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jp.showConfirmDialog(null, "确认删除？") == 0) {
					int tmp = Util.deleteAll();
					if (tmp == 0) {
						jp.showMessageDialog(null, "现在还没有学生，去添加吧！");
					} else {
						jp.showMessageDialog(null, "删除了" + tmp + "条记录！");
					}
				}
			}
		});

		JButton button_1 = new JButton("查看所有学生");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jFrame.setVisible(false);
				SeeAllStudentUI ss = new SeeAllStudentUI(jFrame);
			}
		});

		JButton button_3 = new JButton("删除指定学生");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = jp.showInputDialog("输入学生姓名：");
				try {
					if (name != null) {
						Util.deleteByName(name);
						jp.showMessageDialog(null, "学生" + name + "，删除成功！");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnTxt = new JButton("TXT导入学生");

		JButton button_5 = new JButton("退出");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		GroupLayout groupLayout = new GroupLayout(jFrame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addComponent(label,
												GroupLayout.DEFAULT_SIZE, 414,
												Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(90)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addComponent(
																button_5,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								button_2,
																								GroupLayout.DEFAULT_SIZE,
																								105,
																								Short.MAX_VALUE)
																						.addComponent(
																								button_4,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								button,
																								GroupLayout.DEFAULT_SIZE,
																								105,
																								Short.MAX_VALUE))
																		.addGap(18)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								button_3,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								btnTxt,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								button_1))))
										.addGap(106)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING)
				.addGroup(
						groupLayout
								.createSequentialGroup()
								.addComponent(label,
										GroupLayout.PREFERRED_SIZE, 50,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										groupLayout
												.createParallelGroup(
														Alignment.BASELINE)
												.addComponent(button)
												.addComponent(button_1))
								.addGap(18)
								.addGroup(
										groupLayout
												.createParallelGroup(
														Alignment.BASELINE)
												.addComponent(button_2)
												.addComponent(button_3))
								.addGap(18)
								.addGroup(
										groupLayout
												.createParallelGroup(
														Alignment.BASELINE)
												.addComponent(button_4)
												.addComponent(btnTxt))
								.addGap(18)
								.addComponent(button_5,
										GroupLayout.PREFERRED_SIZE, 34,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(26, Short.MAX_VALUE)));
		jFrame.getContentPane().setLayout(groupLayout);

		jFrame.setVisible(true);
	}
}
