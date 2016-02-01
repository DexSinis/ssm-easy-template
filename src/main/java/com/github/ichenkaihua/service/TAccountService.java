package com.github.ichenkaihua.service;

import com.github.ichenkaihua.mapper.TAccountMapper;
import com.github.ichenkaihua.model.TAccount;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenkaihua on 15-9-15.
 */
@Service
public class TAccountService {

    @Autowired
    TAccountMapper tAccountMapper;



    @RequiresRoles("admin")
    public void deleteWithAdminRoleById(int id){
        tAccountMapper.deleteByPrimaryKey(id);
    }


    public TAccount getTAccountById(int id){
        return tAccountMapper.selectByPrimaryKey(id);
    }



    public boolean isExist(TAccount tAccount){
        return  tAccountMapper.selectCount(tAccount)>0;
    }


    public void addTAccount(TAccount tAccount){
        tAccountMapper.insert(tAccount);
    }


    public List<TAccount> getTAccounts(TAccount tAccount){
        if (tAccount == null) {
            return tAccountMapper.selectAll();
        }

        return tAccountMapper.select(tAccount);
    }


    public void deleteById(int id){
        tAccountMapper.deleteByPrimaryKey(id);

    }

    public void update(TAccount tAccount){
        tAccountMapper.updateByPrimaryKey(tAccount);
    }


}
