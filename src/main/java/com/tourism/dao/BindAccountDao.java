package com.tourism.dao;

import com.tourism.entity.BindAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;

/**
 * Created by ppm on 2020/7/21.
 */
@Transactional
public interface BindAccountDao extends PagingAndSortingRepository<BindAccount, Long>{
    BindAccount findByOpenId(String openId);

}
