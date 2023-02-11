package com.rost.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rost.models.Principal;

@Repository
public interface UserRepository extends JpaRepository<Principal, Long> {

}
