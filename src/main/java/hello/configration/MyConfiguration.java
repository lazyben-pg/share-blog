package hello.configration;

import hello.mapper.UserMapper;
import hello.service.OrderService;
import hello.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public OrderService orderService(UserService userService) {
		return new OrderService(userService);
	}

	@Bean
    public UserService userService(UserMapper userMapper){
        return new UserService(userMapper);
    }
	
}
