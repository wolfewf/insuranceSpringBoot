package com.wolfe.insurance.chainofresponsibility;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wilbur
 * @classname ProductBean
 * @description 产品实体类
 * @date 2020/9/7
 * @since 1.0.0
 */
@Data
public class ProductBean {
	/**
	 * 产品名称
	 */
	private String product;
	/**
	 * 险种责任，每款产品必须至少要有一种
	 */
	private List<String> duties = new ArrayList<>(0);
	/**
	 * 产品状态(0:新建，1：发布，2：上线，3：上架)
	 */
	private Integer productStatus;

}
