package com.wolfe.insurance.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author wolfe
 * @classname SystemConfiguration
 * @description 加载系统配置文件
 * @date 2020/8/27 5:11 下午
 * @since 1.0.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "system.config")
@Scope("singleton")
public class SystemConfiguration {
	private SystemConfiguration(){}
	private String test;
}
