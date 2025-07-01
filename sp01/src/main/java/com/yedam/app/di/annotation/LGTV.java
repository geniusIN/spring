package com.yedam.app.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class LGTV {
    private MarshallSpeaker speaker;

    // 1) 생성자 주입 방식
//    @Autowired // 생성자가 하나만 있을 때는 @Autowired 생략 가능
    public LGTV(MarshallSpeaker speaker) {
        this.speaker = speaker;
    }


    // 2) setter 주입 방식
    public LGTV() { }
    @Autowired
    public void setSpeaker(MarshallSpeaker speaker) {
        this.speaker = speaker;
    }
    public void powerOn() {
        speaker.on();
    }
    public void powerOff() {
        speaker.off();
    }
}