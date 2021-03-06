package com.lu.dao;

import com.lu.domain.Gdzj;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by wuzhong on 16/1/25.
 */
public interface GdzjRepository extends CrudRepository<Gdzj, Integer> {

    public List<Gdzj> getListByHtId(Integer htId);

}
