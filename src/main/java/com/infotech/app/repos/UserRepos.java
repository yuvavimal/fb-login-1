package com.infotech.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infotech.app.model.User;

@Repository("userRepos")
public interface UserRepos extends JpaRepository<User, Integer> {

}
