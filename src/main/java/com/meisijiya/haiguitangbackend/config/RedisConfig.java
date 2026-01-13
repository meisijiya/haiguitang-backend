//package com.meisijiya.haiguitangbackend.config;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.JsonTypeInfo;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * Redis 配置
// */
//@Configuration
//@ConditionalOnProperty(name = "spring.redis.enabled", havingValue = "true", matchIfMissing = false)
//public class RedisConfig {
//
//	/**
//	 * 配置 RedisTemplate 实例，用于操作 Redis 数据库。
//	 * 设置了键和值的序列化方式，其中键使用字符串序列化，值使用 JSON 序列化。
//	 *
//	 * @param redisConnectionFactory Redis 连接工厂，由 Spring 自动注入
//	 * @return 配置完成的 RedisTemplate 实例
//	 */
//	@Bean
//	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//		redisTemplate.setConnectionFactory(redisConnectionFactory);
//
//		// 配置 ObjectMapper 以支持对象的序列化与反序列化
//		ObjectMapper objectMapper = new ObjectMapper();
//		// 设置所有属性均可访问，便于序列化
//		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//		// 启用默认类型信息，以便在反序列化时能正确还原对象类型
//		objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,
//				ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
//
//		// 使用 Jackson 的 JSON 序列化器处理对象类型的值
//		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer =
//				new Jackson2JsonRedisSerializer<>(objectMapper, Object.class);
//
//		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//		// key采用String的序列化方式
//		redisTemplate.setKeySerializer(stringRedisSerializer);
//		// value序列化方式采用jackson
//		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//
//		// hash的key也采用String的序列化方式
//		redisTemplate.setHashKeySerializer(stringRedisSerializer);
//		// hash的value序列化方式采用jackson
//		redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
//
//		redisTemplate.afterPropertiesSet();
//
//		return redisTemplate;
//	}
//}
