package africa.semicolon.gistMeBlog.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Comment {
   @Id
    private String id;
    private String articleId;
    private String userId;

    private String comment;
    private LocalDateTime timeCreated = LocalDateTime.now();

}
