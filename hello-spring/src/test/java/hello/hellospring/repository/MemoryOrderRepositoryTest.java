package hello.hellospring.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import hello.hellospring.domain.OrderInfoVO;
import hello.hellospring.domain.Orderm;
import hello.hellospring.domain.PromoCoupon;

class MemoryOrderRepositoryTest {

	MemoryOrderRepository dataSet = new MemoryOrderRepository();
	
	
	@Test
	void 테스트1() {
		//given
		
		//���� ����
		
		List<PromoCoupon> promoInfoList = new ArrayList<>();
		PromoCoupon promoInfo1 = new PromoCoupon();
		PromoCoupon promoInfo2 = new PromoCoupon();
		
		promoInfo1.setCouponCnt(1);
		promoInfo1.setDoAmt(50);
		promoInfo1.setPromoNo("20201010");
		
		promoInfo2.setCouponCnt(1);
		promoInfo2.setDoAmt(30);
		promoInfo2.setPromoNo("20202020");
		
		promoInfoList.add(promoInfo1);
		promoInfoList.add(promoInfo2);
		
		//���� ����
		List<OrderInfoVO> orderInfoList = new ArrayList<>();
		OrderInfoVO orderinfo1 = new OrderInfoVO();
		OrderInfoVO orderinfo2 = new OrderInfoVO();
		
		orderinfo1.setGoodsCode("333333333");
		orderinfo1.setPromoCouponList(promoInfoList);

		orderinfo2.setGoodsCode("44444444");
		orderinfo2.setPromoCouponList(promoInfoList);
		
		orderInfoList.add(orderinfo1);
		orderInfoList.add(orderinfo2);
		
		//�ֻ��� ����
		Orderm orderm = new Orderm(); 
		
		orderm.setOrderList(orderInfoList);
		
		
		Orderm orderResult = dataSet.save(orderm);
		//when
		
		System.out.println(orderResult);
		//then
		
		
	}
	
}
