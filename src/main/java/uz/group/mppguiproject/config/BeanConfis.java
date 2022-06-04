package uz.group.mppguiproject.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfis {

    @Bean(destroyMethod = "destroySession")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Session createSession(){
        return Session.createInstance();
    }
}
