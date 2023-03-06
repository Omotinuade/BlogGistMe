package africa.semicolon.gistMeBlog.controllers;

import africa.semicolon.gistMeBlog.dtos.requests.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import africa.semicolon.gistMeBlog.services.UserService;
import africa.semicolon.gistMeBlog.services.UserServiceImpl;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

   @PostMapping("/user/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){

       try {

           return new ResponseEntity<>(userService.register(request), HttpStatus.CREATED);
       }catch (IllegalArgumentException ex){
           return new ResponseEntity<>(ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
       }
    }

    @GetMapping("/user/{id}")
    public Object findUserById(@PathVariable String id){
        return userService.findUser(id);
    }
}
