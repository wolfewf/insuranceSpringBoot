package com.wolfe.insurance.chainofresponsibility;

/**
 * @author Wilbur
 * @classname ProductShelvesChain
 * @description 责任链模式中 节点：产品上架
 * @date 2020/9/7
 * @since 1.0.0
 */
public class ProductShelvesChain extends ProductChain {
	@Override
	public void deploy(ProductBean productBean) {
		//产品状态必须是2已经发布，才能上架
		if (2 == productBean.getProductStatus()) {
			System.out.println("产品上架: " + productBean.toString());
			productBean.setProductStatus(3);
			if (productChain != null) {
				productChain.deploy(productBean);
			}
		} else {
			System.out.println("产品上架失败: " + productBean.toString());
			return;
		}
	}
}
