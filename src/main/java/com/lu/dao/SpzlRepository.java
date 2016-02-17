package com.lu.dao;

import com.lu.domain.Spzl;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by wuzhong on 16/1/25.
 */
public interface SpzlRepository extends CrudRepository<Spzl, Integer> {

    public List<Spzl> getListByHuohao(String huohao);

}
