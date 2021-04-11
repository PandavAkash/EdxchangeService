package com.hackathon.edexchange.edexchangeuserservice.repository;

import com.hackathon.edexchange.edexchangeuserservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity,Long> {
}
