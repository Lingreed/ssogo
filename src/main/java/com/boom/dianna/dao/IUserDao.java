package com.boom.dianna.dao;

import com.boom.dianna.dto.UserDto;
import com.boom.dianna.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Author: lin.xj
 * Date: 2016-10-27
 * Description:
 */
public interface IUserDao extends JpaRepository<User, Long> {
    User findByUserName(String userName);

    @Query(value = "select new com.boom.dianna.dto.UserDto(u.id,u.userName,u.enabled,u.info,u.addTime,ui.age,ui.sex,ui.province,ui.city,ui.area,ui.phone,ui.qq,ui.yy) from User u,UserInfo ui where u.id=ui.userId")
    List<UserDto> getAllUsers();
}
