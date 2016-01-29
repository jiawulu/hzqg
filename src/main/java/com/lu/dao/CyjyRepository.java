package com.lu.dao;

import com.lu.domain.Cyjy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by wuzhong on 16/1/25.
 */
public interface CyjyRepository extends CrudRepository<Cyjy, Integer> {

    public List<Cyjy> getListByHtId(Integer htId);

}
