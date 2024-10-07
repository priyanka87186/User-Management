package com.usersmanagementsystem.app.repository;

import com.usersmanagementsystem.app.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
/*
 *author: Priyanka Jadhav
 *
 */
public interface PageableRepo extends PagingAndSortingRepository<Users, Integer> {
    Page<Users> findAll(Pageable pageable);
}
