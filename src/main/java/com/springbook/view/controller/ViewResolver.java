package com.springbook.view.controller;

import org.springframework.web.servlet.mvc.method.annotation.ViewNameMethodReturnValueHandler;

//컨트롤가 리턴한 뷰이름에 접두사와 접두사와 접미사를 결합 최종적으로 실행됨 View경로와 파일명 완성
public class ViewResolver {
	
	public String prefix;
	public String suffix;
	
	
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	
	public String getView(String viewName){
		System.out.println("jsp까지 붙여서 "+prefix + viewName + suffix);
		return prefix + viewName + suffix;
	}
	
}
