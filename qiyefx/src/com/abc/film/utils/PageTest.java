/**
 * 
 */
package com.abc.film.utils;

/**
 * @author joeyang ong
 *
 */
public class PageTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Page page=new Page();
		
		page.setTotalRecNum(102L);
		page.setPageSize(10);
		
		System.out.println(page.getTotalPageNum());

		page.setPageNo(11);
		
		System.out.println(page.getStartIndex()+"-"+page.getEndIndex());
		
		System.out.println(page.getNextPage());
		System.out.println(page.getPrePage());		

	}

}
