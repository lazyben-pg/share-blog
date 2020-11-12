package hello.configration;

import hello.service.OrderService;
import hello.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public OrderService orderService() {
		return new OrderService(userService());
	}

	@Bean
    public UserService userService(){
        return new UserService();
    }
	
}
