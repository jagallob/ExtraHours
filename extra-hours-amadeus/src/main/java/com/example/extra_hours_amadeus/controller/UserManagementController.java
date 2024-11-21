package com.example.extra_hours_amadeus.controller;

import com.example.extra_hours_amadeus.dto.ChangePasswordRequest;
import com.example.extra_hours_amadeus.dto.ReqRes;
import com.example.extra_hours_amadeus.entity.Users;
import com.example.extra_hours_amadeus.service.UsersManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api")
public class UserManagementController {

    @Autowired
    private UsersManagementService usersManagementService;

    @PostMapping("/auth/register")
    public ResponseEntity<ReqRes> register(@RequestBody ReqRes reg) {
        return ResponseEntity.ok(usersManagementService.register(reg));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<ReqRes> login(@RequestBody ReqRes req) {
        return ResponseEntity.ok(usersManagementService.login(req));
    }

    @PutMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestParam Long id,  @RequestParam String newPassword) {

        try {
            usersManagementService.changePassword(id, newPassword);
            return ResponseEntity.ok("Contraseña cambiada exitosamente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/auth/refresh")
    public ResponseEntity<ReqRes> refreshToken(@RequestBody ReqRes req) {
        return ResponseEntity.ok(usersManagementService.refreshToken(req));
    }

    @GetMapping("/superusuario/get-all-users")
    public ResponseEntity<ReqRes> getAllUsers() {
        return ResponseEntity.ok(usersManagementService.getAllUsers());
    }

    @GetMapping("/superusuario/get-user/{userId}")
    public ResponseEntity<ReqRes> getUserById(@PathVariable Integer userId) {
        return ResponseEntity.ok(usersManagementService.getUsersById(userId));
    }

    @PutMapping("/superusuario/update/{userId}")
    public ResponseEntity<ReqRes> updateUser(@PathVariable Integer userId, @RequestBody Users reqres) {
        return ResponseEntity.ok(usersManagementService.updateUser(userId, reqres));
    }

    @GetMapping("/superusuario/get-profile")
    public ResponseEntity<ReqRes> getMyProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        ReqRes response = usersManagementService.getMyInfo(email);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @DeleteMapping("/superusuario/delete/{userId}")
    public ResponseEntity<ReqRes> deleteUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(usersManagementService.deleteUser(userId));
    }
}
