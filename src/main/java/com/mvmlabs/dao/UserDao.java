package com.mvmlabs.dao;

import org.springframework.data.repository.CrudRepository;

import com.mvmlabs.domain.User;

public interface UserDao extends CrudRepository<User, Long>{

}
