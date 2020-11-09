package java_board;

public class Page {
	
	private int page;
	private int prev;
	private int next;
	private int go;
	private int back;
	private int currentPage;
	
	
	Page()
	{
		
	}
	
	Page(int page, int prev, int next, int go, int back, int currentPage)
	{
		this.page = page;
		this.prev = prev;
		this.next = next;
		this.go = go;
		this.back = back;
		this.currentPage = currentPage;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPrev() {
		return prev;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getGo() {
		return go;
	}
	public void setGo(int go) {
		this.go = go;
	}
	public int getBack() {
		return back;
	}
	public void setBack(int back) {
		this.back = back;
	}
	
	
	
}
