package com.lu.controller;

import com.alibaba.fastjson.JSON;
import com.lu.dao.HtzlRepository;
import com.lu.domain.Htzl;
import com.lu.domain.PageValue;
import com.lu.domain.Result;
import com.lu.domain.User;
import com.lu.utils.Constants;
import com.lu.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/htzl/")
public class HtzlController {

    @Autowired
    private HtzlRepository htzlRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String list(HttpServletRequest httpServletRequest) {

        final User user = Utils.getUser(httpServletRequest);

        int pageNo = Utils.getIntParam(httpServletRequest, "pageNo", 0);
        int pageSize = Utils.getIntParam(httpServletRequest, "pageSize", 20);

        PageRequest pageRequest = new PageRequest(pageNo, pageSize);

        Specification<Htzl> specification = new Specification<Htzl>() {
            @Override
            public Predicate toPredicate(Root<Htzl> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> list = new ArrayList<Predicate>();
                if (Constants.ROLE_USER == user.getRole()) {
                    list.add(cb.equal(root.get("ddczy"), user.getUserName()));
                }
                //TODO here~
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        };

        Page<Htzl> page = htzlRepository.findAll(specification, pageRequest);

        Result<PageValue<Htzl>> result = new Result<>();

        result.setSuccess(true);

        PageValue<Htzl> pageValue = new PageValue<>();
        pageValue.setPageNo(page.getNumber());
        pageValue.setTotalSize(page.getTotalElements());
        pageValue.setTotalPage(page.getTotalPages());
        pageValue.setPageSize(page.getSize());
        pageValue.setValues(page.getContent());

        result.setData(pageValue);
        return JSON.toJSONString(result);

    }

}
