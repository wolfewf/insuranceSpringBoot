package com.wolfe.insurance.redisson;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wolfe
 * @classname RedissonProperties
 * @description redisson配置
 * @date 2020/9/3 5:37 下午
 * @since 1.0.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "redisson")
public class RedissonProperties {
	private int timeout = 3000;

	private String address;

	private String password;

	private int connectionPoolSize = 64;

	private int connectionMinimumIdleSize = 10;

	private int slaveConnectionPoolSize = 250;

	private int masterConnectionPoolSize = 250;

	private String[] sentinelAddresses;

	private String masterName;
}
