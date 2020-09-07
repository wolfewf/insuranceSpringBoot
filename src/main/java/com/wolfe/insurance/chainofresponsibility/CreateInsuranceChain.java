package com.wolfe.insurance.chainofresponsibility;

/**
 * @author Wilbur
 * @classname CreateInsuranceChain
 * @description 责任链模式中 节点：创建
 * @date 2020/9/7
 * @since 1.0.0
 */
public class CreateInsuranceChain extends AbstractProductChain {


    public CreateInsuranceChain(int level , ProductBean productBean){
        this.level = level;
        this.productBean = productBean;
    }

    @Override
    protected void write(ProductBean productBean) {
        System.out.println("流程开始");
        System.out.println("创建: " + productBean.toString());
    }
}
