package com.heima.article.service;

import com.heima.model.article.dtos.ArticleHomeDto;
import com.heima.model.article.pojos.ApArticle;
import com.heima.model.common.dtos.ResponseResult;

import java.util.List;

/**
 * @author FF
 * @date 2022/2/1
 * @TIME:21:42
 */
public interface ApArticleService {

    ResponseResult LoadArticleList(ArticleHomeDto dto, Short type);
}
