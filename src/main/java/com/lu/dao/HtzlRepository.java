package com.lu.dao;

import com.lu.domain.Htzl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by wuzhong on 16/1/25.
 */
public interface HtzlRepository extends PagingAndSortingRepository<Htzl, Integer> , JpaSpecificationExecutor<Htzl> {

    @Query(nativeQuery = true, value = "select  * from htzl where bmmll = ?1")
    public List<Htzl> findBySql(String arg);


}
