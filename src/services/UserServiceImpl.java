package services;

import data.models.User;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImpl;
import dtos.requests.RegisterRequest;
import dtos.responses.FindUserResponse;
import utils.Mapper;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService{
    private UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public User register(RegisterRequest registerRequest) {
        if (userExist(registerRequest.getUsername())) throw new IllegalArgumentException(registerRequest.getUsername() + "already exist");
        return userRepository.save(Mapper.map(registerRequest));
        //User user = new User();
        //Mapper.map(registerRequest, user);
        //return userRepository.save(user);
    }

    private boolean userExist(String userName) {
        User found = userRepository.findByUserName(userName);
        if (found != null) return true;
        return false;
    }

    @Override
    public FindUserResponse findUser(int id) {
        User foundUser = userRepository.findById(id);
        FindUserResponse response = new FindUserResponse();
        Mapper.map(foundUser, response);
        return response;
    }

    @Override
    public List<FindUserResponse> findAll() {
        return null;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public FindUserResponse findByUsername() {
        return null;
    }

    @Override
    public User findId(int id) {
        return  userRepository.findById(id);
    }
}
