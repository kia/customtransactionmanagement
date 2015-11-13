package de.cologneintelligence.sandbox.customtxm;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by kmussawisade on 06.11.15.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(value = {"de.cologneintelligence.sandbox.customtxm"})
public class Config {
    @Bean
    public ServiceInTransation serviceInTransation() {
        return new ServiceInTransation();
    }

    @Bean
    public TransactionAspect transactionAspect() {
        return new TransactionAspect();
    }

    @Bean
    public TransactionManager transactionManager() {
        return new ConcreteTransactionManager();
    }
}
