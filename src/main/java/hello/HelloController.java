package hello;

import hello.entity.User;
import hello.service.UserService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    private final UserService userService;

    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public User index() {
        return userService.getUserById(1);
    }
}
