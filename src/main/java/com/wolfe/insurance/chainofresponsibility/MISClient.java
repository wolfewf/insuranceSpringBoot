package com.wolfe.insurance.chainofresponsibility;

import java.util.Date;

/**
 * 测试MIS用户创建产品过程
 * */
public class MISClient {

    private static AbstractProductChain getChainOfProduct() {
        ProductBean productBean = new ProductBean("鸿福保险","赌场得意发发发",new Date(),"1");
        AbstractProductChain createInsuranceChain = new CreateInsuranceChain(AbstractProductChain.CreateInsuranceChain,productBean);
        AbstractProductChain releaseOnlineChain = new ReleaseOnlineChain(AbstractProductChain.ReleaseOnlineChain,productBean);
        AbstractProductChain productReviewChain = new ProductReviewChain(AbstractProductChain.ProductReviewChain,productBean);
        AbstractProductChain productShelvesChain = new ProductShelvesChain(AbstractProductChain.ProductShelvesChain,productBean);


        createInsuranceChain.setNextProductChain(releaseOnlineChain);
        releaseOnlineChain.setNextProductChain(productReviewChain);
        productReviewChain.setNextProductChain(productShelvesChain);

        return createInsuranceChain;
    }

    public static void main(String[] args) {
        AbstractProductChain productChain = getChainOfProduct();

        productChain.logMessage(AbstractProductChain.ProductShelvesChain);

       // productChain.logMessage(AbstractProductChain.ProductReviewChain);
    }
}
