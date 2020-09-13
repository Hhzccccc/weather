package com.shawnliang.web.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shawnLiang
 *
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {

    /**
     * 环境标识符
     */
    @Value("${spring.profiles.active}")
    private String env;

    /**
     * 项目资源加载
     *
     * @param registry 资源注册
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    public Set<String> getConsumes() {
        Set<String> consumer = new HashSet<>();
        consumer.add("application/json");
        return consumer;
    }

    public Set<String> getProduces() {
        Set<String> consumer = new HashSet<>();
        consumer.add("application/json");
        return consumer;
    }

    /**
     * 认证信息
     *
     * @return .
     */
    @Bean
    public List<ApiKey> securitySchemes() {
        return Lists.newArrayList(
                new ApiKey("用户验证信息", "Authorization", "header")
        );
    }

    /**
     * 认证配置上下文
     *
     * @return .
     */
    private List<SecurityContext> securityContexts() {
        List<SecurityContext> list = new ArrayList<>();
        list.add(SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build());
        return list;
    }

    /**
     * 默认认证信息配置
     *
     * @return .
     */
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("BearerToken", authorizationScopes));
    }

    /**
     * Api 接口文档信息
     *
     * @return Api 接口文档信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("market weather文档")
                .description("market weather文档")
                .version("2.0")
                .build();
    }

    /**
     * Api 接口
     *
     * @return .
     */
    @Bean
    @Order(value = 1)
    public Docket apiApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .useDefaultResponseMessages(false)
                .groupName("Api 接口")
                .consumes(getConsumes())
                .produces(getProduces())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.shawnliang.web.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

}
