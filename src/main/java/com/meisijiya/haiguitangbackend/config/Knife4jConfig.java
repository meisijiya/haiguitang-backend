package com.meisijiya.haiguitangbackend.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")  // 仅在dev环境下生效
public class Knife4jConfig {
    // 配置文档信息
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(new Info()
                .title("海龟汤小游 API文档")
                .version("1.0")
                .description("海龟汤小游 API文档，提供用户登录、注销、Token信息查询等功能")
        );
    }

    // 配置功能分组，路由可以有多个
    @Bean
    public GroupedOpenApi typeAPI(){
        return GroupedOpenApi.builder().group("类型分组")
                .pathsToMatch("/controller/**")
                .build();
    }
}
