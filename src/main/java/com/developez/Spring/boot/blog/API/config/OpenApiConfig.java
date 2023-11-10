package com.developez.Spring.boot.blog.API.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    //todo: da scoprire se anche su https si può commentare (probabilmente si)
//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//                // Aggiungi il tuo server HTTPS qui
////                .addServersItem(new Server().url("https://developezapiblog.com"))
////                .addServersItem(new Server().url("http://developezapiblog.com"))
////                .addServersItem( new Server().url( "http://localhost:8080" ) );
//    }
}
