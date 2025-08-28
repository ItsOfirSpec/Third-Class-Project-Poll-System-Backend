package com.project.pollssystem.client;


import com.project.pollssystem.Dtos.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="users-system", url="http://localhost:8081/users")
public interface UserClient {

    @GetMapping("/{id}")
    ResponseEntity<UserDto> getUserById(@PathVariable("id") Integer id);
}
