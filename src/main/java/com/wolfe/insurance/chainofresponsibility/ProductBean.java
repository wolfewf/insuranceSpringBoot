package com.wolfe.insurance.chainofresponsibility;

import lombok.Data;

import java.util.Date;
/**
 * @author Wilbur
 * @classname ProductBean
 * @description 产品实体类
 * @date 2020/9/7
 * @since 1.0.0
 */
@Data
public class ProductBean {
    private String name;
    private String product;
    private Date startDate;
    private String productStatus;

    public ProductBean(String name, String product, Date startDate, String productStatus) {
        this.name = name;
        this.product = product;
        this.startDate = startDate;
        this.productStatus = productStatus;
    }
}
