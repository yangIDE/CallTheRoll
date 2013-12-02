package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import util.Util;
import bean.Student;

public class RandomUI extends JFrame {
	public RandomUI(JFrame jFrame) {
		this.setTitle("\u70B9\u540D\u5668-\u70B9\u540D");
		this.setSize(420, 300);
		this.setVisible(true);
		this.setResizable(false);
		final JFrame jMain = jFrame;
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				jMain.setVisible(true);
			}
		});

		final JLabel lblNewLabel = new JLabel("点击开始");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		final JButton button = new JButton("开始");
		final Timer timer = new Timer();
		final TimerTask tt = new TimerTask() {
			@Override
			public void run() {
				try {
					lblNewLabel.setText(Util.randomName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button.getText().equals("开始")) {
					button.setText("停止");
					timer.schedule(tt, new Date(), 100);
				} else {
					timer.cancel();
					button.setText("开始");
					try {
						Student s = Util.collTheRoll();
						lblNewLabel.setText(s.getName());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(109)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(143)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(124, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(68))
		);
		getContentPane().setLayout(groupLayout);
		
	}
}
