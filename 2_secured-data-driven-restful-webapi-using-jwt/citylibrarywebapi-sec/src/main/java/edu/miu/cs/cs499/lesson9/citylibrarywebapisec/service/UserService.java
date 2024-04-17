package edu.miu.cs.cs499.lesson9.citylibrarywebapisec.service;

import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.model.User;

public interface UserService {

    User getUserByUsername(String username);

    User registerNewUser(User user);
}
