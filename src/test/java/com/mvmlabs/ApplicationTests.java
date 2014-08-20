package com.mvmlabs;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mvmlabs.domain.User;
import com.mvmlabs.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests {

    @Autowired
    UserService userService;
        
    @Test
    public void versionNullCausesAnExceptionOnUpdate() throws Exception {
        User user = new User();
        user.setUsername("Version Null");
        user.setNumberOfVisits(0);
        user.setVersion(null);
        user = userService.save(user);
        
        user = userService.registerVisit(user);
        
        Assert.assertEquals(new Integer(1), user.getNumberOfVisits());
        Assert.assertEquals(new Long(1), user.getVersion());
    }
    
    @Test
    public void versionZeroCausesExceptionOnUpdate() throws Exception {
        User user = new User();
        user.setUsername("Version Zero");
        user.setNumberOfVisits(0);
        user.setVersion(0L);
        user = userService.save(user);
        
        user = userService.registerVisit(user);
        
        Assert.assertEquals(new Integer(1), user.getNumberOfVisits());
        Assert.assertEquals(new Long(1), user.getVersion());
    }
    
    @Test
    public void versionOneDoesNotCausesExceptionOnUpdate() throws Exception {
        User user = new User();
        user.setUsername("Version One");
        user.setNumberOfVisits(0);
        user.setVersion(1L);
        user = userService.save(user);
        
        user = userService.registerVisit(user);
        
        Assert.assertEquals(new Integer(1), user.getNumberOfVisits());
        Assert.assertEquals(new Long(2), user.getVersion());
    }
    
    @Test
    public void versionOneDoesNotCausesExceptionWithMultipleUpdates() throws Exception {
        User user = new User();
        user.setUsername("Version One Multiple");
        user.setNumberOfVisits(0);
        user.setVersion(1L);
        user = userService.save(user);
        
        user = userService.registerVisit(user);
        user = userService.registerVisit(user);
        user = userService.registerVisit(user);
        
        Assert.assertEquals(new Integer(3), user.getNumberOfVisits());
        Assert.assertEquals(new Long(4), user.getVersion());
    }
    
}
