package edu.miu.cs.cs499.lesson9.citylibrarywebapisec.service.impl;

import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CityLibraryUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public CityLibraryUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found for " + username));
    }
}
