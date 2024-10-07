package com.usersmanagementsystem.app.controller;

import com.usersmanagementsystem.app.utils.UserUtils;
import com.usersmanagementsystem.app.entity.Users;
import com.usersmanagementsystem.app.service.UsersManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/*
*author: Priyanka Jadhav
*
*/

@RestController
public class UserManagementController {
    @Autowired
    private UsersManagementService usersManagementService;


    @PostMapping("/auth/register")
    public ResponseEntity<UserUtils> register(@RequestBody UserUtils reg){
        return ResponseEntity.ok(usersManagementService.register(reg));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<UserUtils> login(@RequestBody UserUtils req){
        return ResponseEntity.ok(usersManagementService.login(req));
    }

    @PostMapping("/auth/refresh")
    public ResponseEntity<UserUtils> refreshToken(@RequestBody UserUtils req){
        return ResponseEntity.ok(usersManagementService.refreshToken(req));
    }

    @GetMapping("/admin/get-all-users")
    public ResponseEntity<UserUtils> getAllUsers(){
        return ResponseEntity.ok(usersManagementService.getAllUsers());

    }


    @GetMapping("/get-all")
    @PreAuthorize("hasRole('ADMIN')")// Makes method only accessible to ADMIN
    public ResponseEntity<Page<Users>> getAllUsers(@RequestParam(defaultValue = "1") int page,
                                                   @RequestParam(defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Users> pages = usersManagementService.getAllUsers(pageRequest);
        return ResponseEntity.ok(pages);
    }

    @GetMapping("/admin/get-users/{userId}")
    public ResponseEntity<UserUtils> getUSerByID(@PathVariable Integer userId){
        return ResponseEntity.ok(usersManagementService.getUsersById(userId));

    }

    @PutMapping("/admin/update/{userId}")
    public ResponseEntity<UserUtils> updateUser(@PathVariable Integer userId, @RequestBody Users reqres){
        return ResponseEntity.ok(usersManagementService.updateUser(userId, reqres));
    }

    @GetMapping("/adminuser/get-profile")
    public ResponseEntity<UserUtils> getMyProfile(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserUtils response = usersManagementService.getMyInfo(email);
        return  ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @DeleteMapping("/admin/delete/{userId}")
    public ResponseEntity<UserUtils> deleteUSer(@PathVariable Integer userId){
        return ResponseEntity.ok(usersManagementService.deleteUser(userId));
    }


}
