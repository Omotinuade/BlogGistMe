package africa.semicolon.gistMeBlog.controllers;

import africa.semicolon.gistMeBlog.dtos.requests.RegisterRequest;
import org.springframework.web.bind.annotation.*;
import africa.semicolon.gistMeBlog.services.UserService;
import africa.semicolon.gistMeBlog.services.UserServiceImpl;

@RestController
public class UserController {
    private UserService userService = new UserServiceImpl();

   @PostMapping("/user/register")
    public Object register(@RequestBody RegisterRequest request){
       try {
           return userService.register(request);
       }catch (IllegalArgumentException ex){
           return ex.getMessage();
       }
    }

    @GetMapping("/user/{id}")
    public Object findUserById(@PathVariable int id){
        return userService.findUser(id);
    }
}
