package com.spring.web.myproject;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

//Clase que sirve para configurar todos nuestros archivos .properites (mensajes...)
@Configuration
@PropertySources({
        @PropertySource("classpath:textos.properties")
})
public class MessagePropertiesConfig {
}
