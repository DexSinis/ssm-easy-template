package com.github.ichenkaihua.mapper;

import com.github.ichenkaihua.model.User;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.jdbc.core.SqlProvider;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.provider.base.BaseDeleteProvider;
import tk.mybatis.mapper.provider.base.BaseSelectProvider;

import java.util.List;

public interface UserMapper extends Mapper<User> {

//    @DeleteProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
     User selectUserByID(int id);

//    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
//    List<T> select(T record);
}