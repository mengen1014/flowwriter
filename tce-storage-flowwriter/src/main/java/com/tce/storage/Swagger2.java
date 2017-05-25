package com.tce.storage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *Swagger2 API 管理开源项目
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
		@Bean
		public Docket createRestApi() {
			return new Docket(DocumentationType.SWAGGER_2)
					.apiInfo(apiInfo())
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.tce.storage"))
					.paths(PathSelectors.any())
					.build();
		}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("北京时代云英科技有限公司")
				.description("分级存储流量记录API")
				.contact("TCE-曹蒙恩")
				.version("1.0")
				.build();
	}

}
