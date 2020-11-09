package java_board;

public class Test {

	public static void main(String[] args) {
<<<<<<< HEAD

		Scanner sc = new Scanner(System.in);
		ArrayList titles = new ArrayList();
		ArrayList bodies = new ArrayList();
		boolean loop = true;
		Add a = new Add();

		while (loop) {
			System.out.print("명령어 입력 : ");

			String s = sc.next(); // 입력

			if (s.equals("add")) {
				a.add(titles, bodies);
			}

			else if (s.equals("list")) {
				for (int i = 0; i < titles.size(); i++) {
					System.out.println("제목 : " + titles.get(i));
					System.out.println("내용 : " + bodies.get(i));
				}
			}

			else if (s.equals("exit")) {
				Exit e = new Exit();
				loop = e.exit(s, loop); // 종료
			}

		}

	}

}

class Exit {
	boolean exit(String s, boolean loop) {
		if (s.equals("exit")) {
			System.out.println("종료");
			loop = false;
		}
		return loop;
	}
}

class Add {
	Scanner sc2 = new Scanner(System.in);

	void add(ArrayList titles, ArrayList bodies) {
		System.out.print("게시물 제목을 입력해주세요 : ");
		titles.add(sc2.next());

		System.out.print("게시물 내용을 입력해주세요 : ");
		bodies.add(sc2.next());

		System.out.println("게시물이 등록 되었습니다.");
	}
}

class List {

	void show_list() {

=======

		App app = new App();
		
		app.start();
>>>>>>> a77e2e033cad69a9198cabadb387b20d753a2689
	}
}