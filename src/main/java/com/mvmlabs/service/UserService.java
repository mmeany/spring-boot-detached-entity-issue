package com.mvmlabs.service;

import com.mvmlabs.domain.User;

public interface UserService {

    User save(User user);
    
    User loadUser(Long id);
    
    User registerVisit(User user);
}
