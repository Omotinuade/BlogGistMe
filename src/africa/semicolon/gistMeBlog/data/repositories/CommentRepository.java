package africa.semicolon.gistMeBlog.data.repositories;

import africa.semicolon.gistMeBlog.data.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {

}
