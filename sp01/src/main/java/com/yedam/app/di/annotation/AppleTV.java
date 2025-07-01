package com.yedam.app.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import lombok.Getter;
//import lombok.NoArgsConstructor ;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
//@Setter
@Getter
@ToString
@EqualsAndHashCode
//@NoArgsConstructor 
@RequiredArgsConstructor // final로 선언된 필드로 생성자 구성
public class AppleTV {
    @Setter(onMethod_ = {@Autowired})
    private MarshallSpeaker speaker;
    
    public void powerOn() {
        speaker.on();
    }
    public void powerOff() {
        speaker.off();
    }
}