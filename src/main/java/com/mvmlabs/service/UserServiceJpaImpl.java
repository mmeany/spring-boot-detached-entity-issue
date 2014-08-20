package com.mvmlabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.mvmlabs.dao.UserDao;
import com.mvmlabs.domain.User;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
public class UserServiceJpaImpl implements UserService {

    @Autowired
    private UserDao userDao;
    
    @Transactional(readOnly=true)
    @Override
    public User loadUser(Long id) {
        System.out.println("############# LOAD - MVM ########### Have transaction: " + TransactionSynchronizationManager.isActualTransactionActive());
        return userDao.findOne(id);
    }

    @Override
    public User registerVisit(User user) {
        System.out.println("############# REGISTER - MVM ########### Have transaction: " + TransactionSynchronizationManager.isActualTransactionActive());
        user.setNumberOfVisits(user.getNumberOfVisits() + 1);
        return userDao.save(user);
    }

    @Override
    public User save(User user) {
        System.out.println("############# SAVE - MVM ########### Have transaction: " + TransactionSynchronizationManager.isActualTransactionActive());
        return userDao.save(user);
    }

}
