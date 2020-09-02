package com.wolfe.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wolfe
 * @classname RedisDemo1Controller
 * @description 测试高并发扣库存，redis中存有订单总量key: stock=99,
 * 同时启动两个服务RedisDemo1Controller，端口为8080，8081，使用jmeter测试200并发，
 * 结果发现两个服务出现了多次扣除同一个库存的情况，产生了超卖的情况
 * @date 2020/9/2 3:44 下午
 * @since 1.0.0
 */
@RestController
@RequestMapping("/redisDemo1")
public class RedisDemo1Controller {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@RequestMapping("/reduce_stack")
	public String reduceOrder() {
		synchronized (this) {
			//获取redis存储
			int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
			if (stock > 0) {
				int temp = stock - 1;
				stringRedisTemplate.opsForValue().set("stock", String.valueOf(temp));
				System.out.println("扣减成功，剩余库存：" + temp);
			} else {
				System.out.println("扣减失败，库存不足");
			}
		}
		return "end";
	}
}
