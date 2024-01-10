package com.boot.jersey.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.jersey.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
