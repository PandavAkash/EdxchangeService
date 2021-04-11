package com.hackathon.edexchange.edexchangeuserservice.controller;

import com.hackathon.edexchange.edexchangeuserservice.entity.UserEntity;
import com.hackathon.edexchange.edexchangeuserservice.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserEntity> getUserDetailsById(@PathVariable("userId") Long userId){
        Optional<UserEntity> userEntity = usersRepository.findById(userId);
        if(userEntity.isPresent()) {
            return new ResponseEntity<>(userEntity.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    @PostMapping("/newuser")
    public ResponseEntity<UserEntity> getUserDetailsById(@RequestBody UserEntity userEntity){
//        userEntity = new UserEntity();
//        userEntity.setFirstName("test");
//        userEntity.setLastName("last name");
//        userEntity.setUserName("test");
//        userEntity.setPassword("test");
//        userEntity.setAbout("info");
//        userEntity.setRole("Dev");
//        userEntity.setRating(6);
//        userEntity.setExperience(10.8);
//        userEntity.setFollowers(100L);
//        userEntity.setProfileImage("some path");
        userEntity=usersRepository.save(userEntity);
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }
}
