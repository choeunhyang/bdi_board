package com.board.bdi.vo;

public class PageInfo {
	private Integer page = 1;
	private Integer rowCnt = 10;
	private Integer bloctCnt = 10;
	private Integer totalCnt;
	private Integer limitFNum = 0;
	private Integer limitLNum = 10;
	private Integer totalPage;
	private Integer totalBlock;
	private Integer sBlock;
	private Integer eBlock;
	
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(Integer totalBlock) {
		this.totalBlock = totalBlock;
	}
	public Integer getsBlock() {
		return sBlock;
	}
	public void setsBlock(Integer sBlock) {
		this.sBlock = sBlock;
	}
	public Integer geteBlock() {
		return eBlock;
	}
	public void seteBlock(Integer eBlock) {
		this.eBlock = eBlock;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRowCnt() {
		return rowCnt;
	}
	public void setRowCnt(Integer rowCnt) {
		this.rowCnt = rowCnt;
	}
	public Integer getBloctCnt() {
		return bloctCnt;
	}
	public void setBloctCnt(Integer bloctCnt) {
		this.bloctCnt = bloctCnt;
	}
	public Integer getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(Integer totalCnt) {
		this.totalCnt = totalCnt;
	}
	public Integer getLimitFNum() {
		return limitFNum;
	}
	public void setLimitFNum(Integer limitFNum) {
		this.limitFNum = limitFNum;
	}
	public Integer getLimitLNum() {
		return limitLNum;
	}
	public void setLimitLNum(Integer limitLNum) {
		this.limitLNum = limitLNum;
	}
	
	public void pageCount() {
		if(totalCnt == null) {
			// TODO 에러 처리 필요
		}
		totalPage = (int)(Math.ceil((double)totalCnt/rowCnt));
		totalBlock = (int)(Math.ceil((double)totalPage/bloctCnt));
		limitFNum = (page-1) * rowCnt;		
		sBlock = ((int)(Math.ceil((double)page/bloctCnt))-1) * 10 +1;
		eBlock = sBlock+bloctCnt-1;
		if(eBlock>totalPage) {
			eBlock = totalPage;
		}
	}
	
	/*public static void main(String[] args) {
		PageInfo pi = new PageInfo();
		pi.setTotalCnt(1005);
		pi.setPage(1);
		pi.pageCount();
	}*/
	
	
}
