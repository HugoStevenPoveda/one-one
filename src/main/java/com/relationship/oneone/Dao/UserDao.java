package com.relationship.oneone.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relationship.oneone.entitys.User;

public interface UserDao extends JpaRepository<User, Long> {

}
