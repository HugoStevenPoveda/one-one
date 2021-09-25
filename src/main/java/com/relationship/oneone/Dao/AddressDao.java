package com.relationship.oneone.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relationship.oneone.entitys.Address;

public interface AddressDao extends JpaRepository<Address, Long> {

}
