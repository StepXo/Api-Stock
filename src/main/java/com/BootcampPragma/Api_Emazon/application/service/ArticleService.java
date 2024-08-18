package com.BootcampPragma.Api_Emazon.application.service;

import com.BootcampPragma.Api_Emazon.application.dto.ArticleDto;
import com.BootcampPragma.Api_Emazon.application.mapper.ArticleRequest;
import com.BootcampPragma.Api_Emazon.domain.api.ArticleServicePort;
import com.BootcampPragma.Api_Emazon.domain.model.Article;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleService {

    private final ArticleRequest articleRequest;
    private  final ArticleServicePort articleServicePort;

    public List<ArticleDto> getArticleList() {
        return articleServicePort
                .getArticleList()
                .stream()
                .map(articleRequest::toArticleDto)
                .collect(Collectors.toList()
                );
    }

    public void saveArticle(ArticleDto articleDto){
        Article article = articleRequest.toArticle(articleDto);
        articleServicePort.saveArticle(article);
    }

}
