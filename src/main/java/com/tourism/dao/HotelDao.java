package com.tourism.dao;

import com.tourism.entity.Hotel;
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
public interface HotelDao extends PagingAndSortingRepository<Hotel, Long>,JpaSpecificationExecutor<Hotel>,JpaRepository<Hotel,Long> {
    @Query("from Hotel h where h.id = ?1")
    Hotel findById(String id);

    @Modifying
    @Query("UPDATE Hotel SET address=?1, bed=?2, day=?3, detail=?4, img=?5, price=?6, title=?7, star=?8 WHERE id = ?9")
    int updateHotel(String address, String bed, String day, String detail, String img, String price, String title, String star, String id);

}
