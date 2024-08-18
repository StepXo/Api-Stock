package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Emazon.domain.model.Article;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.ArticleEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-18T12:58:19-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class ArticleMapperImpl implements ArticleMapper {

    @Override
    public Article toArticle(ArticleEntity article) {
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
    public ArticleEntity toArticleEntity(Article article) {
        if ( article == null ) {
            return null;
        }

        ArticleEntity articleEntity = new ArticleEntity();

        articleEntity.setId( article.getId() );
        articleEntity.setName( article.getName() );
        articleEntity.setDescription( article.getDescription() );
        if ( article.getQuantity() != null ) {
            articleEntity.setQuantity( article.getQuantity() );
        }
        articleEntity.setPrice( article.getPrice() );

        return articleEntity;
    }
}
