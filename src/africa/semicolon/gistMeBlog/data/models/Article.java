package africa.semicolon.gistMeBlog.data.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Article {
    private int id;
    private String title;
    private String body;
    private LocalDateTime timeCreated = LocalDateTime.now();
    private int authorId;

}
