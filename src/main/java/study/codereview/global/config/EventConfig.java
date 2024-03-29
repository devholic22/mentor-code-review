package study.codereview.global.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.codereview.global.event.Events;

@RequiredArgsConstructor
@Configuration
public class EventConfig {

    private final ApplicationContext applicationContext;

    @Bean
    public InitializingBean eventInitializer() {
        return () -> Events.setPublisher(applicationContext);
    }
}
