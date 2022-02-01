package com.heima.article.mapper;

import com.heima.model.article.dtos.ArticleHomeDto;
import com.heima.model.article.pojos.ApArticle;

import java.util.List;

/**
 * @author FF
 * @date 2022/2/1
 * @TIME:21:45
 */
public interface ApArticleMapper {

    /**
     * 加载文章列表
     * @param dto
     * @param type
     * @return
     */
    public List<ApArticle> LoadArticleList(ArticleHomeDto dto,short type);
}
