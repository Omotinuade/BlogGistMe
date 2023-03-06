package africa.semicolon.gistMeBlog.services;

import africa.semicolon.gistMeBlog.data.models.Comment;

public interface CommentService {
    Comment createComment(String body);
    Comment findComment(String Id);
    Comment deleteComment(String Id);
    Comment editComment(String title, String body);
}
