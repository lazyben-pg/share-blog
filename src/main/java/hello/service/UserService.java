package hello.service;

import hello.entity.User;
import hello.mapper.UserMapper;

import javax.inject.Inject;

public class UserService {
    private final UserMapper userMapper;

    @Inject
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUserById(int id) {
        return userMapper.findUserById(id);
    }
}
