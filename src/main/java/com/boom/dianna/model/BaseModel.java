package com.boom.dianna.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Author: lin.xj
 * Date: 2016-10-26
 * Description:
 */
@MappedSuperclass
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
