package com.benezeth.MockinApp.controller;

import com.benezeth.MockinApp.entity.BankEntity;
import com.benezeth.MockinApp.exception.BankException;
import com.benezeth.MockinApp.exception.UserException;
import com.benezeth.MockinApp.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Bank_info")
@SuppressWarnings("ALL")
public class BankController {
    @Autowired
    private BankRepository bankRepository;
    //code for getting all user
    @GetMapping
    public List<BankEntity>getAllUser()
    {
        return bankRepository.findAll();
    }
    //code for creating user
    @PostMapping
    public BankEntity createUser(RequestBody BankEntity ){
        return bankRepository.save(new BankEntity());
    }
    //code for selecting single element
    @GetMapping("{id}")

    public ResponseEntity<BankEntity>getUserById(@PathVariable long id){
        BankEntity getUser=bankRepository.findById(id).orElseThrow(()->new UserException("user does not exist"));
        return ResponseEntity.ok(getUser);}
        //code updating user
        @PutMapping("{id}")
                public ResponseEntity<BankEntity>updateUser(@PathVariable Long id,@RequestBody BankEntity UserDetails){
        BankEntity updateUser=bankRepository.findById(id).orElseThrow(()->new BankException("User does not exist"));
        updateUser.setUserId(UserDetails.getUserId());
        updateUser.setUserAddress(UserDetails.getUserAddress());
        updateUser.setUserName(UserDetails.getUserName());
        updateUser.setUserJob(UserDetails.getUserJob());
        updateUser.setUserPhoneNo(UserDetails.getUserPhoneNo());
        bankRepository.save(updateUser);
        return ResponseEntity.ok(updateUser);

    }
    //code for deleting
    @DeleteMapping
    public ResponseEntity<BankEntity>deleteUser(long id){
        BankEntity user=bankRepository.findById(id).orElseThrow(()->new BankException("user does not exit"));
        bankRepository.delete(user);
        return ResponseEntity.ok(user);
    }
}
