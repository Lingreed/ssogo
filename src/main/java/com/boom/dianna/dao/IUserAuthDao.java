package com.boom.dianna.dao;

import com.boom.dianna.dto.AuthDto;
import com.boom.dianna.model.Auth;
import com.boom.dianna.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: lin.xj
 * Date: 2016-10-31
 * Description:
 */
public interface IUserAuthDao extends JpaRepository<UserAuth, Long> {
    @Transactional
    @Modifying
    @Query(value = "delete from UserAuth u where u.userId=:userId")
    int deleteByUserId(@Param("userId") long userId);

    @Query("select new com.boom.dianna.dto.AuthDto(a.id,a.authName) from UserAuth ua,Auth a where ua.authId = a.id and ua.userId = :userId")
    List<AuthDto> findUserAuthsByUserId(@Param("userId") long userId);
}
