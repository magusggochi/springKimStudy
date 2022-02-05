package hello.hellospring.domain;

import java.util.List;

public class OrderInfoVO {

	private String goodsCode;
	private List<PromoCoupon> promoCouponList;

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public List<PromoCoupon> getPromoCouponList() {
		return promoCouponList;
	}

	public void setPromoCouponList(List<PromoCoupon> promoCouponList) {
		this.promoCouponList = promoCouponList;
	}
	
}
