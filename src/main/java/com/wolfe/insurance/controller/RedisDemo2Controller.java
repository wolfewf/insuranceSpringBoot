package com.wolfe.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author wolfe
 * @classname RedisDemo1Controller
 * @description 测试高并发扣库存，redis中存有订单总量key: stock=99,
 * 同时启动两个服务RedisDemo1Controller，端口为8080，8081（启动参数配置：-Dserver.port=8081），使用jmeter测试200并发，
 * 结果发现两个服务出现了扣除多次同一个库存的情况，产生了超卖的情况问题处理
 * @date 2020/9/2 3:44 下午
 * @since 1.0.0
 */
@RestController
@RequestMapping("/redisDemo2")
public class RedisDemo2Controller {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@RequestMapping("/reduce_stack")
	public String reduceOrder() {
		String lockKey = "lockKey";
		String clientId = UUID.randomUUID().toString();

		try {
			//如果redis中不存在就创建，设置30s自动过期时间
			Boolean aBoolean = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, clientId, 30, TimeUnit.SECONDS);
			if (!aBoolean) {
				System.out.println("扣减操作已锁");
				return "lock";
			}
			//获取redis存储
			int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
			if (stock > 0) {
				int temp = stock - 1;
				stringRedisTemplate.opsForValue().set("stock", String.valueOf(temp));
				System.out.println("扣减成功，剩余库存：" + temp);
			} else {
				System.out.println("扣减失败，库存不足");
			}
			return "end";
		} finally {
			//判断当前获取redis锁了客户端id是否是当前线程持有的，如果是才能删除锁，避免其他线程删除不属于当前线程的锁
			if (clientId.equals(stringRedisTemplate.opsForValue().get(lockKey))) {
				stringRedisTemplate.delete(lockKey);
			}
		}
	}
}
