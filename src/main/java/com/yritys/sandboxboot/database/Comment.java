/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yritys.sandboxboot.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author Tommi
 */
@Entity
public class Comment extends AbstractPersistable<Long> {

    @Id
    private Long id;
    private String comment;

    public Comment() {

    }

    public Comment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
