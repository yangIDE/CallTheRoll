package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import bean.Student;

public class Util {

	static File file = new File("students");
	File[] files = null;

	public static File[] getFiles() {
		return file.listFiles();
	}

	static {
		if (!file.exists()) {
			file.mkdir();
		}
	}

	public static Student collTheRoll() throws Exception {
		List<Student> ss = findStudent();
		Student s = ss.get(new Random().nextInt(ss.size()));
		s.setFlag(false);
		updateStudent(s);
		return s;
	}

	public static String randomName() throws Exception {
		List<Student> ss = findStudent();
		return ss.get(new Random().nextInt(ss.size())).getName();
	}

	public static List<Student> findStudent() throws Exception {
		List<Student> stus = new ArrayList<Student>();
		List<Student> ss = new ArrayList<Student>();
		ObjectInputStream ois = null;
		int temp = 0;
		for (File file1 : getFiles()) {
			ois = new ObjectInputStream(new FileInputStream(file1));
			stus.add((Student) ois.readObject());
		}
		for (Student stu : stus) {
			if (stu.getFlag()) {
				ss.add(stu);
			} else {
				temp++;
			}
		}
		if (temp == stus.size()) {
			for (Student stu : stus) {
				stu.setFlag(true);
				updateStudent(stu);
			}
			ss = findStudent();
		}
		ois.close();
		return ss;
	}

	public static boolean insertStudent(String name) throws Exception {
		Student s = new Student();
		s.setFlag(true);
		s.setName(name);

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				new File("students\\" + s.getName())));
		oos.writeObject(s);
		oos.close();
		return true;
	}

	public static void updateStudent(Student stu) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				new File("students\\" + stu.getName())));
		oos.writeObject(stu);
		oos.close();
	}

	public static int deleteAll() {
		int tmp = 0;
		for (File file : getFiles()) {
			tmp++;
			file.delete();
		}
		if (tmp == 0) {
			return 0;
		} else {
			return tmp;
		}

	}

	public static void deleteByName(String name) {
		int tmp = 0;
		for (File file : getFiles()) {
			tmp++;
			if (file.getName().equals(name)) {
				file.delete();
				return;
			}
		}
		if (tmp == 0) {
			System.out.println("还没有学生，5秒后回到首页去添加吧");
			return;
		}
		System.out.println("没有这个学生请重新输入！");
		deleteByName(new Scanner(System.in).next());
	}

	public static void insertStudents(String url) throws Exception {
		File file = new File(url);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String name = null;
		while ((name = br.readLine()) != null) {
			insertStudent(name);
		}
	}
}
