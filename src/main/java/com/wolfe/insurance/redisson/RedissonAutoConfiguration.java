package com.wolfe.insurance.redisson;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wolfe
 * @classname RedissonAutoConfiguration
 * @description redisson自动配置类
 * @date 2020/9/3 5:41 下午
 * @since 1.0.0
 */
@Configuration
@ConditionalOnClass(Config.class)
@EnableConfigurationProperties(RedissonProperties.class)
public class RedissonAutoConfiguration {

	@Autowired
	private RedissonProperties redissonProperties;

	/**
	 * 单机模式自动装配
	 *
	 * @return
	 */
	@Bean
	@ConditionalOnProperty(name = "redisson.address")
	RedissonClient redissonSingle() {
		Config config = new Config();
		SingleServerConfig serverConfig = config.useSingleServer()
				.setAddress(redissonProperties.getAddress())
				.setTimeout(redissonProperties.getTimeout())
				.setConnectionPoolSize(redissonProperties.getConnectionPoolSize())
				.setConnectionMinimumIdleSize(redissonProperties.getConnectionMinimumIdleSize());

		if (StringUtils.isNotBlank(redissonProperties.getPassword())) {
			serverConfig.setPassword(redissonProperties.getPassword());
		}
		return Redisson.create(config);
	}
}
