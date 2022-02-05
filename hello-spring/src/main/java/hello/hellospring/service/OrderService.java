package hello.hellospring.service;


import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

public class OrderService {

	private final MemberRepository memberRepository;
	
	public OrderService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	/* ȸ������ */
	public Long join(Member member) {
		//���� �̸��� �ִ� �ߺ� ȸ�� X
		
		 memberRepository.findByName(member.getName())
												.ifPresent(a->{
													throw new IllegalStateException("�̹� �����ϴ� ȸ���Դϴ�.");
												});
		
		memberRepository.save(member);
		return member.getId();
		
	}
	
	/*
	List<PromomVO> couponList = new ArrayList<PromomVO>();
	List<PromomVO> finalCouponList = new ArrayList<PromomVO>();

	//contents.getPurchase().getOrderList().size
	for(int j = 0; j<(10); j++){

		String goodsCode = cg.getGoodsCode();
		String goodsDtCode = cg.getGoodsdtCode();
		String goodsSeq = cg.getGoodsSeq();

		if (goods.getPromoCouponDc() != null && goods.getPromoCouponDc().size() > 0) {
			int goodsQty = cg.getOrderQty();

			for (PromomVO promom : goods.getPromoCouponDc()) {

				long limitCouponQty = promom.getLimitGoodsQty();

				if (limitCouponQty > 0 && goodsQty > limitCouponQty) {
					continue;
				}

				if ("0".equals(ComUtil.objToStr(promom.getCartCouponYn(), "0"))) {
					if ("0".equals(ComUtil.objToStr(promom.getDoubleCouponYn(), "0"))) {

						double dcAmtGoods = 0;
						if (goods.getPromoDc() == null) {
							dcAmtGoods = goods.getArsDcAmt();
						} else {
							dcAmtGoods = goods.getPromoDc().getDoAmt() + goods.getArsDcAmt();
						}

						if ("30".equals(promom.getDoType()) && promom.getAmtRateFlag().equals("2")) {
							promom.setDoAmt(ComUtil.modAmtRemoveWon((goods.getSalePrice() - dcAmtGoods) * promom.getDoRate() / 100));

							if (promom.getLimitAmt() > 0) {
							
								if (promom.getDoAmt() > promom.getLimitAmt()) {
									promom.setDoAmt(ComUtil.modAmtRemoveWon(promom.getLimitAmt()));
								}
							}
						}

						if (maxDcRateCheck(dcAmtGoods, promom.getDoAmt(),goods.getSalePrice()) < Constants.MAX_DC_RATE) {
							PromomVO pm = new PromomVO();
							pm.setPromoNo(promom.getPromoNo());
							pm.setDoAmt(promom.getDoAmt() * cg.getOrderQty());
							pm.setDoRate(promom.getDoRate());
							pm.setGoodsCode(goodsCode);
							pm.setCouponCnt(promom.getCouponCnt());
							couponList.add(pm);
						}
					}
				}
			}
		}

		Collections.sort(couponList, new Comparator<PromomVO>() {
			public int compare(PromomVO pv1, PromomVO pv2) {
				if (pv1.getDoAmt() > pv2.getDoAmt()) {
					return -1;
				} else if (pv1.getDoAmt() < pv2.getDoAmt()) {
					return 1;
				} else {
					if (pv1.getDoRate() < pv2.getDoRate()) {
						return -1;
					} else if (pv1.getDoRate() > pv2.getDoRate()) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		});


		//������� couponList < --- ���� ���˿��� ���� doAmt()�� ������ ù������ �ȴ�.
		for (int k = 0; k < couponList.size(); k++) {
		
		
			//���θ�� ��ü�� ����� ���������� �����Ѵ�.
			PromomVO pm = couponList.get(k);
			
			
			//���� ī��Ʈ�� ���� �޾Ƽ� ������ üũ�Ѵ�.
			long couponCnt = couponList.get(k).getCouponCnt();
			
			
			int goodsCheck = 0;

			//�ϴ� ó�� ���θ�� ī��Ʈ�� �����ϱ� ��ȸ�Ǿ��ڰ� 0���� ���� ���̴�.
			if (couponCnt > 0) {
			
			
			
				// ó���� �����ϸ� ������ �ƹ��͵� �ȵ����� ? 
				for (int x = 0; x < finalCouponList.size(); x++) {
					if (pm.getGoodsCode() == finalCouponList.get(x).getGoodsCode()) {
						goodsCheck++;
						break;
					}
				}
				//�׷� ���� FOR���� �۵����� �ʴ´�.
				
				
				//���� GOODSCHECK�� 0�� �˴ϴ�.
				if (goodsCheck == 0) {
				
					finalCouponList.add(pm);
					
					
					for (int y = 0; y < couponList.size(); y++) {
					
						PromomVO pm2 = couponList.get(y);
						
						for (int l = 0; l < finalCouponList.size(); l++) {
						
							if (pm2.getPromoNo().equals(finalCouponList.get(l).getPromoNo())) {
							
								pm2.setCouponCnt(couponCnt - 1);
								
							}
							
						}
						
					}
					
					
				} else {
					continue;
				}
			} else {
				continue;
			}
		}

		if (finalCouponList != null && 0 < finalCouponList.size()) {
				// getPromoCouponList - > getPromoCouponDc
				if (goods.getPromoCouponDc() != null) {
					for (int z = 0; z < goods.getPromoCouponDc().size(); z++) {
						PromomVO promom = goods.getPromoCouponDc().get(z);

						for (int k = 0; k < finalCouponList.size(); k++) {
							if (goodsCode.equals(finalCouponList.get(k).getGoodsCode())
									&& promom.getPromoNo().equals(finalCouponList.get(k).getPromoNo())) {
								promom.setSelectYn("1");
							}
						}
					}
				}
		}

	}
}
*/
}