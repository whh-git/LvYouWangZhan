package com.tourism.dao;

import com.tourism.entity.ContentFlow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ContentFlowDao extends PagingAndSortingRepository<ContentFlow, Long>,JpaSpecificationExecutor<ContentFlow>,JpaRepository<ContentFlow,Long> {

    @Query("from ContentFlow cf where cf.title = ?1")
    Page<ContentFlow> findByLabelName(String labelName, Pageable pageable);

    @Query("from ContentFlow cf where cf.id = ?1")
    ContentFlow findById(String id);

    @Modifying
    @Query("UPDATE ContentFlow SET title=?1,detail=?2 ,content=?3 ,img=?4 ,star=?5 ,time=?6 ,price=?7 WHERE id = ?8")
    int updateContentFlow(String title, String detail,  String content,   String img,   String star,   String time,   String price, String id);

    @Modifying
    @Query("UPDATE ContentFlow SET pupNo=0")
    int updatePup();

    @Modifying
    @Query("UPDATE ContentFlow SET todayPupNo=0")
    int updateTPup();

    @Query("from ContentFlow cf where cf.title like ?1")
    List<ContentFlow> findByContent(String content);

}
