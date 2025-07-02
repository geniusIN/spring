package com.yedam.app.aop.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.mapper.AopMapper;
import com.yedam.app.aop.service.AopService;

import lombok.RequiredArgsConstructor;

@Service // AOP(관심분리) 기능을 적용할 수 있는 대상.
@RequiredArgsConstructor
public class AopServiceImpl implements AopService {
	// 생성자 주입방식 이면서 Lombok을 활용한 생성자 주입방식
	private final AopMapper aopMap;
	
	@Transactional // 메서드에 사용될경우 메서드 안에서 몇개쿼리가 실행되든 하나의 트랜잭션 로직 으로 묶여짐 ( 1개라도 실행안되면 전체가 롤백 )
	@Override
	public void insert() {
		aopMap.insert("101"); // commit
		aopMap.insert("a101"); // error 로 인해서 rollback
	}
	
}
