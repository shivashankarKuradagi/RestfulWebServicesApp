package com.shiv.restfill.app.RestFullWebServiceApp;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig
{

    private static final ApiInfo API_DETAILS = new ApiInfo( "Shiva Api", "Shiva Api", "1.1", "", "Shivashankar", "", "URL" );
    private static final Set<String> PRODUCES_CONSUMES = new HashSet<>( java.util.Arrays.asList( "application/json",
                                                                                                 "application/xml" ) );

    @Bean
    public Docket getApi()
    {
        return new Docket( DocumentationType.SWAGGER_2 ).apiInfo( API_DETAILS ).produces( PRODUCES_CONSUMES );

    }

}
