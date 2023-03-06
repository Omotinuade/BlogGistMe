package africa.semicolon.gistMeBlog.services;

import africa.semicolon.gistMeBlog.data.models.User;
import africa.semicolon.gistMeBlog.dtos.requests.RegisterRequest;
import africa.semicolon.gistMeBlog.dtos.responses.FindUserResponse;

public interface UserService {
    User register(RegisterRequest request);
    FindUserResponse findUser(String id);
    void delete(User user);

}
