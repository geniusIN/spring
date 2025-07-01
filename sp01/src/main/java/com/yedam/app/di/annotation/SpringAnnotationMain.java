package com.yedam.app.di.annotation;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringAnnotationMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:AnnotationContext.xml");
		LGTV tv = ctx.getBean(LGTV.class);
		tv.powerOn();
		
		ctx.close();

	}

}
