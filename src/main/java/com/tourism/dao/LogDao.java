package com.tourism.dao;

import com.tourism.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.util.Date;

@Transactional
public interface LogDao extends PagingAndSortingRepository<Log, Long>,JpaSpecificationExecutor<Log>,JpaRepository<Log,Long> {
    @Query("from Log h where h.id = ?1")
    Log findById(String id);

    @Modifying
    @Query("UPDATE Log SET name=?1, info=?2, nume=?3, creat_time=?4  WHERE id = ?5")
    int updateHotel(String name, String info, String num, Date creatTime,String id);

    @Modifying
    @Query(value = "insert into Log (id,name,create_time) values(?1,?2,?3)", nativeQuery = true)
    int insertTest(String id,String name,Date createTime);
}
