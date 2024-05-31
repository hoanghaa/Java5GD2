package com.java5.demojpa.api;

import com.java5.demojpa.entity.User;
import com.java5.demojpa.service.UserSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("api/user-api")
@RestController
@RequiredArgsConstructor
public class UserApi {

    private final UserSevice userSevice;

    @GetMapping("getAllUser")
    public ResponseEntity<?> doGetAllUser(){
        Map<String,Object> result = new HashMap();
        try {
            result.put("success",true);
            result.put("message","Call api succes");
            result.put("data",userSevice.getAllUser());
        }catch (Exception e){
            result.put("success",false);
            result.put("message","Call api fail");
            result.put("data",null);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("saveUser")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        Map<String,Object> result = new HashMap();
        try {
            result.put("success",true);
            result.put("message","Call api succes");
            result.put("data",userSevice.saveUser(user));
        }catch (Exception e){
            result.put("success",false);
            result.put("message","Call api fail");
            result.put("data",null);
        }
        return ResponseEntity.ok(result);
    }
}
