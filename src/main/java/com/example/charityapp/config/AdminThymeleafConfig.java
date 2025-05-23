package com.example.charityapp.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AdminThymeleafConfig implements WebMvcConfigurer, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public SpringResourceTemplateResolver adminTemplateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        templateResolver.setPrefix("classpath:/templates/admin/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(true);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine adminTemplateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(adminTemplateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        // Assuming messageSource bean is available from I18nConfig
        templateEngine.setMessageSource(applicationContext.getBean(ResourceBundleMessageSource.class));
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver adminViewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(adminTemplateEngine());
        viewResolver.setOrder(0); // Set a higher order to prioritize this resolver
        viewResolver.setViewNames(new String[]{"admin/*"}); // Specify view names handled by this resolver
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }
} 