package com.BootcampPragma.Api_Emazon.application.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.ArticleDto;
import com.BootcampPragma.Api_Emazon.domain.model.Article;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-18T12:58:19-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class ArticleRequestImpl implements ArticleRequest {

    @Override
    public Article toArticle(ArticleDto article) {
        if ( article == null ) {
            return null;
        }

        Long quantity = null;
        double price = 0.0d;
        long id = 0L;
        String name = null;
        String description = null;

        quantity = article.getQuantity();
        price = article.getPrice();
        id = article.getId();
        name = article.getName();
        description = article.getDescription();

        Article article1 = new Article( id, name, description, quantity, price );

        return article1;
    }

    @Override
    public ArticleDto toArticleDto(Article articleDto) {
        if ( articleDto == null ) {
            return null;
        }

        ArticleDto articleDto1 = new ArticleDto();

        articleDto1.setId( articleDto.getId() );
        articleDto1.setName( articleDto.getName() );
        articleDto1.setDescription( articleDto.getDescription() );
        if ( articleDto.getQuantity() != null ) {
            articleDto1.setQuantity( articleDto.getQuantity() );
        }
        articleDto1.setPrice( articleDto.getPrice() );

        return articleDto1;
    }
}
