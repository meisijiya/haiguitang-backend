//package com.meisijiya.haiguitangbackend.config.redisson;
//
//import lombok.Data;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Component;
//
///**
// * Redisson 属性
// */
//@Data
//@Component
//@ConfigurationProperties(prefix = "redisson")
//public class RedissonProperties {
//
//	/**
//	 * 是否启用 Redisson
//	 */
//	private String enable;
//
//	/**
//	 * Redisson 客户端地址
//	 */
//	private String client;
//
//	/**
//	 * Redis 数据库索引
//	 */
//	private Integer database;
//
//	/**
//	 * Redis 密码
//	 */
//	private String password;
//
//	/**
//	 * 等待节点回复命令的时间。该时间从命令发送成功时开始计时。
//	 */
//	private Integer timeout;
//}
