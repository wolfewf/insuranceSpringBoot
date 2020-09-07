package com.wolfe.insurance.chainofresponsibility;

/**
 * @author Wilbur
 * @classname ReleaseOnlineChain
 * @description 责任链模式中 节点：产品上线
 * @date 2020/9/7
 * @since 1.0.0
 */
public class ReleaseOnlineChain extends ProductChain {
	@Override
	public void deploy(ProductBean productBean) {
		//产品状态必须是1已经发布和产品必须选择duty责任，才能上线
		if (1 == productBean.getProductStatus() && productBean.getDuties().size() > 0) {
			System.out.println("产品上线: " + productBean.toString());
			productBean.setProductStatus(2);
			//继续调用下一个流程,产品上架
			if (productChain != null) {
				productChain.deploy(productBean);
			}
		} else {
			System.out.println("产品上线失败: " + productBean.toString());
			return;
		}
	}
}
