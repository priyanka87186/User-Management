package com.usersmanagementsystem.app.repository;


import com.usersmanagementsystem.app.entity.Users;
import com.usersmanagementsystem.app.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
/*
 *author: Priyanka Jadhav
 *
 */
public interface UsersRepo extends JpaRepository<Users, Integer> {

    Optional<Users> findByEmail(String email);


    boolean existsByRole(Role adminRole);

    <T> Optional<T> findByRole(Role role);
}
