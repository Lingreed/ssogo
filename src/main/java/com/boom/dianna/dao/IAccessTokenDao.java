package com.boom.dianna.dao;

import com.boom.dianna.model.AccessLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: lin.xj
 * Date: 2016-10-28
 * Description:
 */
public interface IAccessTokenDao extends JpaRepository<AccessLog, Long> {

}
