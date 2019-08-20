package config;
/**
 * @Author: zhangzhiguo
 * @Date: 2019/8/20 15:36
 * @Version 1.0
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName MyWebAppConfigurer
 * @Desccription TODO
 * @Author ZhangZhiGuo
 * @Date 2019/8/20 15:36
 * @Version 1.0
 **/
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/**").addResourceLocations("classpath:/resources");
        super.addResourceHandlers(registry);
    }
}

