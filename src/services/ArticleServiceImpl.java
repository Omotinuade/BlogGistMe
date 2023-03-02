package services;

import data.models.Article;
import data.models.User;
import data.repositories.ArticleRepository;
import data.repositories.ArticleRepositoryImpl;
import dtos.requests.CreateArticleRequest;
import utils.Mapper;

import java.util.NoSuchElementException;

public class ArticleServiceImpl implements ArticleService{
    ArticleRepository articleRepository = new ArticleRepositoryImpl();
    UserService userService = new UserServiceImpl();

    @Override
    public Article createNewArticle(CreateArticleRequest createArticleRequest) {
         checkAuthorExistsFrom(createArticleRequest);
        Article article = new Article();
//        convert(createArticleRequest, article);
        Mapper.map(createArticleRequest, article);
        return articleRepository.save(article);
    }

    private void convert(CreateArticleRequest createArticleRequest, Article article){
        article.setBody(createArticleRequest.getBody());
        article.setTitle(createArticleRequest.getTitle());
        article.setAuthorId(createArticleRequest.getAuthorId());
    }




    private void checkAuthorExistsFrom(CreateArticleRequest createArticleRequest) {
        try {
            var foundUser = userService.findUser(createArticleRequest.getAuthorId());
        }
        catch (NullPointerException ex){
            throw new IllegalArgumentException(String.format("Author with id %s does not exist", createArticleRequest.getAuthorId() ));
        }
    }

    @Override
    public Article findArticle(int id) {
        return articleRepository.findById(id);
    }

    @Override
    public long count() {
        return articleRepository.count();
    }
}
