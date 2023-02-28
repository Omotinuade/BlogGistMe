package services;

import data.models.User;
import dtos.requests.RegisterRequest;
import dtos.responses.FindUserResponse;

import java.util.List;

public interface UserService {
    User register(RegisterRequest request);
    FindUserResponse findUser(int id);
    List<FindUserResponse> findAll();
    void delete(User user);
    void delete(int id);
    void deleteAll();

    FindUserResponse findByUsername();
    User findId(int id);
}
