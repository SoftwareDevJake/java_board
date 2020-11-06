package java_board;

import java.util.Scanner;

public class test_class {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int currentPage = sc.nextInt();
		
		int totalCountOfItems = 20; // 전체 게시물 갯수
		int startPage = 1; // 시작 페이지 번호
		int itemsCountPerPage = 3; // 페이지당 출력 게시물 갯수
		int pageCountPerBlock = 5; // 한 페이지 블럭 당 페이지 개수
		int endPage = (int)Math.ceil((double)totalCountOfItems / itemsCountPerPage); // 마지막 페이지 번호 (남은 소수점 올림)
		int currentPageBlock = pageCountPerBlock / currentPage; // 현재 페이지 블록
//		System.out.println("currentPageBlock : " + currentPageBlock);
		
		int startPageNumberInBlock = (currentPage - 1) * pageCountPerBlock + 1;
//		System.out.println("startPageNumberInBlock : " + startPageNumberInBlock);
		
		int endPageNumberInBlock = startPageNumberInBlock + pageCountPerBlock - 1;
		
		for(int i = startPageNumberInBlock; i <= endPageNumberInBlock; i++)
		{
			
			if(i == currentPage)
			{
				System.out.print("[" + i + "] ");
			}
			else
			{
				System.out.print(i + " ");
			}
		}
		
		
//		ArrayList<Integer> list = new ArrayList<>();
//		ArrayList<Num> nlist = new ArrayList<Num>();
//
//		list.add(4);
//		list.add(1);
//		list.add(2);
//		list.add(5);
//		list.add(3);
//
//		printList(list);
//		Collections.sort(list); // 오름차순
//		
//		printList(list);
//		Collections.sort(list, Collections.reverseOrder()); // 내림차순
//		
//		printList(list);
//		
//		nlist.add(new Num(4, 5));
//		nlist.add(new Num(1, 1));
//		nlist.add(new Num(2, 4));
//		nlist.add(new Num(5, 3));
//		nlist.add(new Num(3, 2));
//
//		MyComparator comp = new MyComparator();
////		Collections.sort(nlist, comp);
//		
//		for (int i = 0; i < nlist.size(); i++) {
//			System.out.println(nlist.get(i).n1);
//		}
//
//		
//		for (int i = 0; i < nlist.size(); i++) {
//			System.out.println(nlist.get(i).n2);
//		}
//	}
//
//	public static void printList(ArrayList<Integer> list)
//	{
//		for(int i = 0; i < list.size(); i++)
//		{
//			System.out.println(list.get(i));
//		}
//	}
//	
	}
//
//class Num {
//
//	int n1;
//	int n2;
//
//	Num(int a, int b) {
//		n1 = a;
//		n2 = b;
//	}
//
}
