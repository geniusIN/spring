package com.yedam.app.di;

public class DefaultMain {
    public static void main(String[] args) {
        SonySpeaker speaker = new SonySpeaker();
//        SamsungTV tv = new SamsungTV();
        SamsungTV tv = new SamsungTV(speaker);
        tv.setSpeaker(speaker);
        tv.powerOn();
    }
}