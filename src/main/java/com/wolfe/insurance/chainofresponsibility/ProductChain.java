package com.wolfe.insurance.chainofresponsibility;

/**
 * @author Wilbur
 * @classname AbstractProductChain
 * @description 抽象 产品发布流程 使用责任链模式实现
 * 责任链由多个节点（处理器）组成。在行为模式中有两种：一种是遍历链条上的节点，直到找到对应节点，然后处理为止。
 * 第二种是由各个节点依次处理，共享负担责任的一部分。
 * 本功能采用责任链模式的第二种
 * @date 2020/9/7
 * @since 1.0.0
 */
public abstract class ProductChain {
	protected ProductChain productChain;

	public void setNextProductChain(ProductChain productChain) {
		this.productChain = productChain;
	}
	/**
	 * 产品发布、上线、上架
	 * @param productBean
	 */
	public abstract void deploy(ProductBean productBean);


}
