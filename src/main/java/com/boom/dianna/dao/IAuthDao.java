package com.boom.dianna.dao;

import com.boom.dianna.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;

/**
 * Author: lin.xj
 * Date: 2016-10-31
 * Description:
 */
@Entity
public interface IAuthDao extends JpaRepository<Auth,Long> {
}
