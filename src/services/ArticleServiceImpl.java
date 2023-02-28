package services;

import data.models.Article;
import data.models.User;
import data.repositories.ArticleRepository;
import data.repositories.ArticleRepositoryImpl;

public class ArticleServiceImpl implements ArticleService{
    ArticleRepository articleRepository = new ArticleRepositoryImpl();
    @Override
    public Article createPost(String title, String body, int id) {
        Article post = new Article();
        UserService userService = new UserServiceImpl();
        User savedUser = userService.findId(id);
        int find = savedUser.getId();

        post.setTitle(title);
        post.setBody(body);
        post.setAuthorId(find);
        return articleRepository.save(post);
    }

    @Override
    public Article findPost(int id) {
        return articleRepository.findById(id);
    }
}
