package com.obsez.zag.demostreamrmqpublisher.repository;

import com.obsez.zag.demostreamrmqpublisher.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
