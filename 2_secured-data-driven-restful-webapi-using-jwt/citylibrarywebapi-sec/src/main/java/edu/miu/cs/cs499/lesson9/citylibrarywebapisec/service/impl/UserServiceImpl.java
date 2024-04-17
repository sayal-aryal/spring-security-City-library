package edu.miu.cs.cs499.lesson9.citylibrarywebapisec.service.impl;

import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.model.User;
import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.repository.UserRepository;
import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElse(null);
    }

    @Override
    public User registerNewUser(User user) {
        return null;
    }
}
