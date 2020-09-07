package com.wolfe.insurance.chainofresponsibility;

/**
 * @author Wilbur
 * @classname ReleaseOnlineChain
 * @description 责任链模式中 节点：产品发布，上线
 * @date 2020/9/7
 * @since 1.0.0
 */
public class ReleaseOnlineChain extends AbstractProductChain {
    public ReleaseOnlineChain(int level , ProductBean productBean){
        this.level = level;
        this.productBean = productBean;
    }

    @Override
    protected void write(ProductBean productBean) {
        System.out.println("产品发布，上线: " + productBean.toString());
    }
}
