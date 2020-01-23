package com.qfzz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2//开启Swagger2
public class SwaggerConfig {

    //配置Swagger的Bean实例
    @Bean
    public Docket createDocket(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(createApiInfo())
                .groupName("空之律者")
                .enable(true)//enable表示是否开启Swagger
                .select()
                //RequestHandlerSelectors指定扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.qf.controller"))
                .build();
    }

    public ApiInfo createApiInfo(){

        //结束前都不加 ; 表示还没结束
        return new ApiInfoBuilder()
                .title("测试标题")
                .description("测试描述")
                .termsOfServiceUrl("http://www.bilibili.com")
                .build();
    }

//    @Bean
//    public Docket createDocket1(){
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(createApiInfo())
//                .groupName("彼岸双生")
//                .enable(true)//enable表示是否开启Swagger
//                .select()
//                //RequestHandlerSelectors指定扫描的包
//                .apis(RequestHandlerSelectors.basePackage("com.qf.controller"))
//                .build();
//    }
//
//    public ApiInfo createApiInfo1(){
//
//        //结束前都不加 ; 表示还没结束
//        return new ApiInfoBuilder()
//                .title("项目测试")
//                .description("接口描述")
//                .termsOfServiceUrl("https://www.bilibili.com/")
//                .build();
//    }

}
