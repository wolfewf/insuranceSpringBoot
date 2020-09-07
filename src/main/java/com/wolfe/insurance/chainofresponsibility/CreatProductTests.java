package com.wolfe.insurance.chainofresponsibility;

import java.util.ArrayList;

/**
 * 测试用户创建产品过程
 */
public class CreatProductTests {

	public static void main(String[] args) {
		ProductChain productReleaseChain = new ProductReleaseChain();
		ProductChain releaseOnlineChain = new ReleaseOnlineChain();
		ProductChain productShelvesChain = new ProductShelvesChain();

		ProductBean productBean = new ProductBean();
		productBean.setProduct("鸿福保险");
		ArrayList<String> duties = new ArrayList<>();
		//增加责任
		duties.add("赌场得意发发发");
		productBean.setDuties(duties);
		//创建产品,设置初始状态0
		productBean.setProductStatus(0);

		productReleaseChain.setNextProductChain(releaseOnlineChain);
		releaseOnlineChain.setNextProductChain(productShelvesChain);

		productReleaseChain.deploy(productBean);
	}
}
