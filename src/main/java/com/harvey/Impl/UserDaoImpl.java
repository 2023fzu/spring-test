package com.harvey.Impl;

import com.harvey.service.UserDao;
import com.harvey.utils.Log;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : UserDao
 * @date : 2023/10/30 00:45
 **/
public class UserDaoImpl implements UserDao {
    //dao层用来作增删改查的基础命令,这些命令怎么用,什么时候用(业务意义上)不知道哦
    boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }



    public UserDaoImpl() {
//        Log.info("UserDao创建");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
    }

    public void init(){
        Log.info("Dao:init");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
//        Log.info("afterPropertiesSet");
    }
}
