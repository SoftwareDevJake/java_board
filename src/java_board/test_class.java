package java_board;

import java.util.ArrayList;
import java.util.Scanner;

public class test_class {
	public static void main(String[] args) {
		
		ArrayList<Article> articles = new ArrayList<>();
		
		for(int i = 1; i <= 50; i++)
		{
			Article a1 = new Article();
			a1.setId(i);
			a1.setTitle("제목 : " + i);
			a1.setBody("내용 : " + i);
			
			articles.add(a1);
		}
		
		Scanner sc = new Scanner(System.in);
		int currentPage = Integer.parseInt(sc.nextLine());
		
		int totalCountOfItems = 50; // 전체 게시물 갯수
		int startPage = 1; // 시작 페이지 번호
		int itemsCountPerPage = 3; // 페이지당 출력 게시물 갯수
		int pageCountPerBlock = 5; // 한 페이지 블럭 당 페이지 개수
		int endPage = (int)Math.ceil((double)totalCountOfItems / itemsCountPerPage); // 마지막 페이지 번호 (남은 소수점 올림)
		int currentPageBlock = (int)Math.ceil((double)currentPage / pageCountPerBlock); // 현재 페이지 블록
//		System.out.println("currentPageBlock : " + currentPageBlock);
		
		int startPageNumberInBlock = ((currentPageBlock - 1) * pageCountPerBlock) + 1;
//		System.out.println("startPageNumberInBlock : " + startPageNumberInBlock);
		
		int endPageNumberInBlock = startPageNumberInBlock + pageCountPerBlock - 1;
		
		if(startPageNumberInBlock < startPage)
		{
			startPageNumberInBlock = startPage;
		}
		
		if(endPageNumberInBlock > endPage)
		{
			endPageNumberInBlock = endPage;
		}
		
		int startIndex = (currentPage - 1) * itemsCountPerPage;
		int endIndex = startIndex + itemsCountPerPage;
		
		if(endIndex > totalCountOfItems)
		{
			endIndex = totalCountOfItems;
		}
		
		for(int i = startIndex; i < endIndex; i++)
		{
			System.out.println("번호 : " + articles.get(i).getId());
			System.out.println("제목 : " + articles.get(i).getTitle());
			System.out.println("내용 : " + articles.get(i).getBody());
			System.out.println("============================");
		}
		
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
