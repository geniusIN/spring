package com.yedam.app.di.annotation;

import org.springframework.stereotype.Component;

@Component
public class MarshallSpeaker {
	public void on() {
		System.out.println("마샬 스피커 ON");
	}
	
	public void off() {
		System.out.println("마샬 스피커 OFF");
	}
}
