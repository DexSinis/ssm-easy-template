package com.github.ichenkaihua.mapper;

import com.github.ichenkaihua.model.Ofchatlogs;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OfchatlogsMapper extends Mapper<Ofchatlogs> {
     List<Ofchatlogs> getOfchatlogssBySelf(String id);
}