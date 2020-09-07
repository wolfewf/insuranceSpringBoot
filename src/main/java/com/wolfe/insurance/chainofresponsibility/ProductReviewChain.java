package com.wolfe.insurance.chainofresponsibility;
/**
 * @author Wilbur
 * @classname ProductShelvesChain
 * @description 责任链模式中 节点：产品审核
 * @date 2020/9/7
 * @since 1.0.0
 */
public class ProductReviewChain extends AbstractProductChain {


    public ProductReviewChain(int level , ProductBean productBean){
        this.level = level;
        this.productBean = productBean;
    }

    @Override
    protected void write(ProductBean productBean) {
        System.out.println("产品审核: " + productBean.toString());
    }
}
