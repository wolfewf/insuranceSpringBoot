package com.wolfe.insurance.chainofresponsibility;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Wilbur
 * @classname ProductReleaseChain
 * @description 责任链模式中 节点：产品发布
 * @date 2020/9/7
 * @since 1.0.0
 */
public class ProductReleaseChain extends ProductChain {

    @Override
    public void deploy(ProductBean productBean) {
        if (StringUtils.isNotBlank(productBean.getProduct())) {
            System.out.println("产品发布: " + productBean.toString());
            productBean.setProductStatus(1);
            //继续调用下一个流程,产品上线
            if (productChain != null) {
                productChain.deploy(productBean);
            }
        } else {
            System.out.println("产品发布失败: " + productBean.toString());
            return;
        }
    }
}
