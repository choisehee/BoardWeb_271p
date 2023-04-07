package com.springbook.view.controller;

import org.springframework.web.servlet.mvc.method.annotation.ViewNameMethodReturnValueHandler;

//��Ʈ�Ѱ� ������ ���̸��� ���λ�� ���λ�� ���̻縦 ���� ���������� ����� View��ο� ���ϸ� �ϼ�
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
		System.out.println("jsp���� �ٿ��� "+prefix + viewName + suffix);
		return prefix + viewName + suffix;
	}
	
}
