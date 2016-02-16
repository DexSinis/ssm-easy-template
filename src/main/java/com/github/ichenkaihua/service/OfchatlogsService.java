package com.github.ichenkaihua.service;

import com.github.ichenkaihua.mapper.OfchatlogsMapper;
import com.github.ichenkaihua.model.Ofchatlogs;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenkaihua on 15-9-15.
 */
@Service
public class OfchatlogsService {

    @Autowired
    OfchatlogsMapper ofchatlogsMapper;



    @RequiresRoles("admin")
    public void deleteWithAdminRoleById(int id){
        ofchatlogsMapper.deleteByPrimaryKey(id);
    }


    public Ofchatlogs getOfchatlogsById(int id){
        return ofchatlogsMapper.selectByPrimaryKey(id);
    }



    public boolean isExist(Ofchatlogs ofchatlogs){
        return  ofchatlogsMapper.selectCount(ofchatlogs)>0;
    }


    public void addOfchatlogs(Ofchatlogs ofchatlogs){
        ofchatlogsMapper.insert(ofchatlogs);
    }


    public List<Ofchatlogs> getOfchatlogss(Ofchatlogs ofchatlogs){
        if (ofchatlogs == null) {
            return ofchatlogsMapper.selectAll();
        }

        return ofchatlogsMapper.select(ofchatlogs);
    }


    public void deleteById(int id){
        ofchatlogsMapper.deleteByPrimaryKey(id);

    }

    public void update(Ofchatlogs ofchatlogs){
        ofchatlogsMapper.updateByPrimaryKey(ofchatlogs);
    }

    public List<Ofchatlogs> getOfchatlogssBySelf(String id)
    {
//           id ="59";
           return ofchatlogsMapper.getOfchatlogssBySelf(id);
//         return  null;
    }

}
