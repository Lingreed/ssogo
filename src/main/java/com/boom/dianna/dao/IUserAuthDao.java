package com.boom.dianna.dao;

import com.boom.dianna.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: lin.xj
 * Date: 2016-10-31
 * Description:
 */
public interface IUserAuthDao extends JpaRepository<UserAuth, Long> {

}
