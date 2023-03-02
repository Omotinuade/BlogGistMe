package africa.semicolon.gistMeBlog.services;

import africa.semicolon.gistMeBlog.data.models.Article;
import africa.semicolon.gistMeBlog.data.repositories.ArticleRepository;
import africa.semicolon.gistMeBlog.data.repositories.ArticleRepositoryImpl;
import africa.semicolon.gistMeBlog.dtos.requests.CreateArticleRequest;
import africa.semicolon.gistMeBlog.utils.Mapper;

public class ArticleServiceImpl implements ArticleService{
    ArticleRepository articleRepository = new ArticleRepositoryImpl();
    UserService userService = new UserServiceImpl();

    @Override
    public Article createNewArticle(CreateArticleRequest createArticleRequest) {
        checkAuthorExistsFrom(createArticleRequest);
        Article article = new Article();
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
