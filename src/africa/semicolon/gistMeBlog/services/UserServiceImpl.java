package africa.semicolon.gistMeBlog.services;

import africa.semicolon.gistMeBlog.data.models.User;
import africa.semicolon.gistMeBlog.data.repositories.UserRepository;
import africa.semicolon.gistMeBlog.dtos.requests.RegisterRequest;
import africa.semicolon.gistMeBlog.dtos.responses.FindUserResponse;
import africa.semicolon.gistMeBlog.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User register(RegisterRequest registerRequest) {
        if (userExist(registerRequest.getUsername())) throw new IllegalArgumentException(registerRequest.getUsername() + "already exist");
        return userRepository.save(Mapper.map(registerRequest));

    }

    private boolean userExist(String userName) {
        User found = userRepository.findByUserName(userName);
        return found != null;
    }

    @Override
    public FindUserResponse findUser(String id) {
        Optional<User> foundUser = userRepository.findById(id);
        if (foundUser.isEmpty() ) throw new NullPointerException("User does not exist");
        FindUserResponse response = new FindUserResponse();
        Mapper.map(foundUser.get(), response);
        return response;
    }


    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }




}
