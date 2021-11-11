package com.spring.travelbook.service.impl;

import com.spring.travelbook.entity.UserEntity;
import com.spring.travelbook.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity userEntity =
        userRepository
            .findByUserName(username)
            .orElseThrow(
                () -> new UsernameNotFoundException("User not found with username " + username));
    return UserDetailsImpl.build(userEntity);
  }
}
