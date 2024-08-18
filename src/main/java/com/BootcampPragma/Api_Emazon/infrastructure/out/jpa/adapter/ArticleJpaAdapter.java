package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter;

import com.BootcampPragma.Api_Emazon.domain.model.Article;
import com.BootcampPragma.Api_Emazon.domain.spi.ArticlePersistencePort;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.DescriptionNotFoundException;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.NoDataFoundException;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.ArticleEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.ArticleMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class ArticleJpaAdapter implements ArticlePersistencePort {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    @Override
    public List<Article> getArticleList() {

        List<ArticleEntity> articleEntityList = articleRepository.findAll();
        if (articleEntityList.isEmpty()){throw new NoDataFoundException();}

        return articleRepository
                .findAll()
                .stream()
                .map(articleMapper::toArticle)
                .collect(Collectors.toList()
                );
    }

    @Override
    public Article saveArticle(Article article){

        if (article.getDescription().isEmpty()){
            throw new DescriptionNotFoundException();
        }

        ArticleEntity articleEntity = this.articleRepository.save(
                articleMapper.toArticleEntity(article)
        );
        return articleMapper.toArticle(articleEntity);
    }

    @Override
    public void updateArticulo(Article article){
        if (article.getDescription().isEmpty()){
            throw new DescriptionNotFoundException();
        }
        ArticleEntity articleEntity = this.articleRepository.save(
                articleMapper.toArticleEntity(article));
    };

    @Override
    public void deleteArticulo(String articleId){
        articleRepository.deleteByName(articleId);}

}
