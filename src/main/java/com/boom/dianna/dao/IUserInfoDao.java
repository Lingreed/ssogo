package com.boom.dianna.dao;

import com.boom.dianna.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: lin.xj
 * Date: 2016-10-27
 * Description:
 */
public interface IUserInfoDao extends JpaRepository<UserInfo, Long> {
    UserInfo findByUserId(long userId);
}
