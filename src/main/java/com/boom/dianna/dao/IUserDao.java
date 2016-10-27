package com.boom.dianna.dao;

import com.boom.dianna.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: lin.xj
 * Date: 2016-10-27
 * Description:
 */
public interface IUserDao extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
