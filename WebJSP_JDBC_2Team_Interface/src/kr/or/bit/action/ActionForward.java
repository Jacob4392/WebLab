package kr.or.bit.action;

public class ActionForward {
	private boolean isRedirect = false; //화면 or 로직제어
	private String path = null; //이동경로(뷰의 주소)
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
