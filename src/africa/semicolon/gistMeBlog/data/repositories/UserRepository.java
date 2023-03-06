package africa.semicolon.gistMeBlog.data.repositories;

import africa.semicolon.gistMeBlog.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUserName(String userName);
}