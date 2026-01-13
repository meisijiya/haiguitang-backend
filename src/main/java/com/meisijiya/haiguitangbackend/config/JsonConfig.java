package com.meisijiya.haiguitangbackend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * Jackson 序列化配置
 *
 * 该配置类用于自定义Jackson的序列化行为，主要解决Long类型精度丢失问题
 */
@JsonComponent
public class JsonConfig {

	/**
	 * 配置Jackson ObjectMapper Bean
	 *
	 * 创建并配置ObjectMapper实例，主要用于将Long类型序列化为字符串，
	 * 防止前端JavaScript处理大整数时出现精度丢失问题
	 *
	 * @param builder Jackson2ObjectMapperBuilder对象，用于构建ObjectMapper实例
	 * @return 配置好的ObjectMapper对象
	 */
	@Bean
	public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
		// 创建ObjectMapper实例，不创建XML映射器
		ObjectMapper objectMapper = builder.createXmlMapper(false).build();

		// 注册自定义序列化模块
		SimpleModule module = new SimpleModule();
		// 将Long类型序列化为字符串
		module.addSerializer(Long.class, ToStringSerializer.instance);
		// 将long基本类型序列化为字符串
		module.addSerializer(Long.TYPE, ToStringSerializer.instance);
		objectMapper.registerModule(module);

		return objectMapper;
	}
}
