package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication // 아래 3개가 합쳐진 어노테이션 이거 1개만 써도됌
@SpringBootConfiguration // 동작기능X 설정정보를 가지고있는 클래스란 의미 동작하는시점에 
@EnableAutoConfiguration // 스타트모듈을 기반으로 해서 추가 디폴트 오토컨피그레이션 필요에따라서 커스텀마이징 가능
@ComponentScan // (경로) 없으면 현재 패키지정보를 기반으로해서 동작

@MapperScan(basePackages = "com.yedam.app.**.mapper") // 정보를 읽고 빈을만들어서 스프링의 컨테이너로 넘겨줌 매퍼가 읽는대상은 인터페이스 가 되어줘야함
public class Sp02Application {

	public static void main(String[] args) {
		SpringApplication.run(Sp02Application.class, args);
	}

}
