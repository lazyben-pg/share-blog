package hello.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.time.Instant;
import java.util.Map;

import hello.entity.User;

@Controller
public class AuthController {
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;

    public AuthController(UserDetailsService userDetailsService, AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/auth")
    @ResponseBody
    public Object auth() { return new Result("ok", false); }
    @PostMapping("/auth/login")
    @ResponseBody
    public Result login(@RequestBody Map<String, String> usernameAndPassword) {
        String username = usernameAndPassword.get("username");
        String password = usernameAndPassword.get("password");

        UserDetails userDetails = null;
        try {
            userDetails = userDetailsService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            return new Result("fail", "用户不存在");
        }
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
        try {
            authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(token);
            return new Result("ok", "登陆成功", new User(1, "hunger", "null", Instant.now(), Instant.now()));
        } catch (BadCredentialsException e) {
            return new Result("fail", "密码不正确");
        }
    }

    private static class Result {
        private final String status;
        private final String msg;
        private final User data;
        private final boolean login;

        private Result(String status, String msg, User data, Boolean login) {
            this.status = status;
            this.msg = msg;
            this.data = data;
            this.login = login;
        }

        public Result(String status, String msg) {
            this(status, msg, null);
        }

        public Result(String status, String msg, User data) {
            this(status, msg, data, false);
        }

        public Result(String status, Boolean login, User data) {
            this(status, null, data, login);
        }

        public Result(String status, Boolean login) {
            this(status, null, null, login);
        }

        public String getMsg() {
            return msg;
        }

        public User getData() {
            return data;
        }

        public boolean isLogin() {
            return login;
        }

        public String getStatus() {
            return status;
        }
    }
}
