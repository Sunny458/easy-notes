package cn.zealon.notes;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;


@Component
public class NoteSwagger {

  @Bean
  public Docket draftRestApi(ApiInfo apiInfo, SecurityContext security, ApiKey apiKey, List<Parameter> parameters) {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo)
        .groupName("简笔记接口管理")
        .select()
        .apis(RequestHandlerSelectors.basePackage("cn.zealon.notes"))
        .paths(PathSelectors.any())
        .build()
        .securityContexts(Lists.newArrayList(security))
        .securitySchemes(Lists.<SecurityScheme>newArrayList(apiKey))
        .globalOperationParameters(parameters)
        ;
  }


}
