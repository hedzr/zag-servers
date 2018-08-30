package com.obsez.zag.demoprovider.repository;

import com.obsez.zag.demoprovider.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
