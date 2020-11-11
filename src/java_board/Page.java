package java_board;

import java.util.Scanner;

public class Page {
	
	private int currentPage = 1;
	private int totalCountOfItems; // 전체 게시물 갯수
	private int startPage = 1; // 시작 페이지 번호
	private int itemsCountPerPage = 3; // 페이지당 출력 게시물 갯수
	private int pageCountPerBlock = 5; // 한 페이지 블럭 당 페이지 개수
	
	public int getStartIndex() {
		
		return (currentPage - 1) * itemsCountPerPage;
	}

	public int getEndIndex() {
		return getStartIndex() + itemsCountPerPage;
	}

	public Page()
	{
		
	}
	
	public Page(int totalCountOfItems) {
		this.totalCountOfItems = totalCountOfItems;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCountOfItems() {
		return totalCountOfItems;
	}

	public void setTotalCountOfItems(int totalCountOfItems) {
		this.totalCountOfItems = totalCountOfItems;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getItemsCountPerPage() {
		return itemsCountPerPage;
	}

	public void setItemsCountPerPage(int itemsCountPerPage) {
		this.itemsCountPerPage = itemsCountPerPage;
	}

	public int getPageCountPerBlock() {
		return pageCountPerBlock;
	}

	public void setPageCountPerBlock(int pageCountPerBlock) {
		this.pageCountPerBlock = pageCountPerBlock;
	}

	public int getEndPage() {
		return (int)Math.ceil((double)totalCountOfItems / itemsCountPerPage); // 마지막 페이지
	}

	public int getCurrentPageBlock() {
		return (int)Math.ceil((double)currentPage / pageCountPerBlock); // 현재 페이지 블록
	}

	public int getStartPageNumberInBlock() {
		return ((getCurrentPageBlock() - 1) * pageCountPerBlock) + 1; // 블럭 당 시작페이지 넘버
	}

	public int getEndPageNumberInBlock() {
		return ((getCurrentPageBlock() - 1) * pageCountPerBlock) + 1 + pageCountPerBlock - 1; // 블럭 당 앤드페이지 넘버
	}


}
