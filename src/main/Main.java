package main;

import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import util.Util;
import bean.Student;

public class Main {
	static {
		File file = new File("TXT");
		if (!file.exists()) {
			file.mkdir();
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (;;) {
			prompt();
			String s = sc.next();
			if (s.equals("7")) {
				System.out.println("��ӭ�ٴ�ʹ�ã�");
				Thread.sleep(2000);
				return;
			} else if (s.equals("1")) {
				int tmp = 0;
				System.out.println(1);
				for (File file : Util.getFiles()) {
					if (tmp % 3 == 0)
						System.out.println();
					tmp++;
					System.out.print(file.getName() + '\t');
				}
				if (tmp == 0) {
					System.out.println("��û��ѧ����5���ص���ҳȥ��Ӱ�");
				} else {
					System.out.println('\n' + "ִ�н�����5���ص���ҳ��");
				}
				Thread.sleep(5000);
			} else if (s.equals("2")) {
				System.out.println("������ѧ��������");
				String name = sc.next();
				Util.insertStudent(name);
				System.out.println('\n' + "ִ�н�����2���ص���ҳ��");
				Thread.sleep(2000);
			} else if (s.equals("3")) {
				collTheRoll();
				System.out.println('\n' + "ִ�н�����5���ص���ҳ��");
				Thread.sleep(5000);
			} else if (s.equals("4")) {
				System.out.println("��������Ҫɾ��ѧ��������");
				Util.deleteByName(sc.next());
				System.out.println('\n' + "ִ�н�����2���ص���ҳ��");
				Thread.sleep(2000);
			} else if (s.equals("5")) {
				Util.deleteAll();
				Thread.sleep(5000);
			} else if (s.equals("6")) {
				System.out.println("���TXT�ļ�����TXTĿ¼��");
				System.out.println("TXT�ı���ʽΪ");
				System.out.println("����");
				System.out.println("����");
				System.out.println("����");
				Thread.sleep(1000);
				System.out.println("����������ļ���(������ļ���չ��)");
				String url = sc.next();
				Util.insertStudents("TXT\\"+url+".txt");
				System.out.println("���ڲ��룬���Ժ򡤡�������");
				Thread.sleep(3000);
				System.out.println('\n' + "ִ�н�����2���ص���ҳ��");
				Thread.sleep(2000);
			} else {
				System.out.println("�����������������룡");
				Thread.sleep(2000);
			}
		}
	}

	public static void collTheRoll() throws Exception {
		List<Student> ss = Util.findStudent();
		Student s = ss.get(new Random().nextInt(ss.size()));
		s.setFlag(false);
		Util.updateStudent(s);
		System.out.println(s);
	}

	public static void prompt() {
		System.out.println('\n' + "�������ʾ������");
		System.out.println("1���鿴����ѧ��");
		System.out.println("2�����һ����ѧ��");
		System.out.println("3���������(�ѵ����Ĳ����ٳ���)");
		System.out.println("4��ɾ��һ��ѧ��");
		System.out.println("5��ɾ������ѧ��");
		System.out.println("6��TXT��������ѧ��");
		System.out.println("7���˳�");
		System.out.println("�������ʾ������ż��ɣ�");
	}
}
