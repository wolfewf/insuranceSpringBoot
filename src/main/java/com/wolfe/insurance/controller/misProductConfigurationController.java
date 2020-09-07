package com.wolfe.insurance.controller;

import com.wolfe.insurance.chainofresponsibility.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Wilbur
 * @classname misProductConfigurationController
 * @description 测试mis系统中的功能
 * @date 2020/9/7
 * @since 1.0.0
 */
@RestController
@RequestMapping("/mis")
public class misProductConfigurationController {

	@RequestMapping("/creatProduct")
	public String creatProduct() {
		ProductBean productBean = new ProductBean("鸿福保险","赌场得意发发发",new Date(),"1");
		AbstractProductChain createInsuranceChain = new CreateInsuranceChain(AbstractProductChain.CreateInsuranceChain,productBean);
		AbstractProductChain releaseOnlineChain = new ReleaseOnlineChain(AbstractProductChain.ReleaseOnlineChain,productBean);
		AbstractProductChain productReviewChain = new ProductReviewChain(AbstractProductChain.ProductReviewChain,productBean);
		AbstractProductChain productShelvesChain = new ProductShelvesChain(AbstractProductChain.ProductShelvesChain,productBean);


		createInsuranceChain.setNextProductChain(releaseOnlineChain);
		releaseOnlineChain.setNextProductChain(productReviewChain);
		productReviewChain.setNextProductChain(productShelvesChain);

		createInsuranceChain.logMessage(AbstractProductChain.ProductShelvesChain);

		return "end";
	}
}
