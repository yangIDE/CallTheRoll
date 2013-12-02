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
				System.out.println("欢迎再次使用！");
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
					System.out.println("还没有学生，5秒后回到首页去添加吧");
				} else {
					System.out.println('\n' + "执行结束，5秒后回到首页！");
				}
				Thread.sleep(5000);
			} else if (s.equals("2")) {
				System.out.println("请输入学生姓名：");
				String name = sc.next();
				Util.insertStudent(name);
				System.out.println('\n' + "执行结束，2秒后回到首页！");
				Thread.sleep(2000);
			} else if (s.equals("3")) {
				collTheRoll();
				System.out.println('\n' + "执行结束，5秒后回到首页！");
				Thread.sleep(5000);
			} else if (s.equals("4")) {
				System.out.println("请输入需要删除学生的姓名");
				Util.deleteByName(sc.next());
				System.out.println('\n' + "执行结束，2秒后回到首页！");
				Thread.sleep(2000);
			} else if (s.equals("5")) {
				Util.deleteAll();
				Thread.sleep(5000);
			} else if (s.equals("6")) {
				System.out.println("请把TXT文件放入TXT目录中");
				System.out.println("TXT文本格式为");
				System.out.println("张三");
				System.out.println("李四");
				System.out.println("王五");
				Thread.sleep(1000);
				System.out.println("请输入的你文件名(无需加文件拓展名)");
				String url = sc.next();
				Util.insertStudents("TXT\\"+url+".txt");
				System.out.println("正在插入，请稍候·····");
				Thread.sleep(3000);
				System.out.println('\n' + "执行结束，2秒后回到首页！");
				Thread.sleep(2000);
			} else {
				System.out.println("输入有误，请重新输入！");
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
		System.out.println('\n' + "请根据提示操作：");
		System.out.println("1：查看所有学生");
		System.out.println("2：添加一个新学生");
		System.out.println("3：随机点名(已点名的不会再出现)");
		System.out.println("4：删除一个学生");
		System.out.println("5：删除所有学生");
		System.out.println("6：TXT批量导入学生");
		System.out.println("7：退出");
		System.out.println("请根据提示输入序号即可！");
	}
}
