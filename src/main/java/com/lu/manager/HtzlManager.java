package com.lu.manager;

import com.lu.dao.CyjyRepository;
import com.lu.dao.GdzjRepository;
import com.lu.dao.HtzlRepository;
import com.lu.domain.*;
import com.lu.utils.Constants;
import com.lu.utils.HtzlPoiHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuzhong on 16/1/29.
 */
@Component
public class HtzlManager {

    @Autowired
    private HtzlRepository htzlRepository;
    @Autowired
    private GdzjRepository gdzjRepository;
    @Autowired
    private CyjyRepository cyjyRepository;

    public boolean importXls(InputStream inputStream) {

        List<Htzl> list = new HtzlPoiHelper().convert(inputStream);

        if (null == list) {
            return false;
        }

        return batchInsert(list);

    }

    @Transactional
    private boolean batchInsert(List<Htzl> list) {

        try {
            htzlRepository.save(list);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param pageRequest
     * @param user
     * @param cgjqWarnType 1,2,3,4 (天数)
     * @param startJq
     * @param endJq
     * @param zjcs
     * @param cycs
     * @return
     */
    public Page<Htzl> search(Pageable pageRequest, final User user, final int cgjqWarnType, final long startJq, final long endJq, final int zjcs, final int cycs) {
        Specification<Htzl> specification = new Specification<Htzl>() {
            @Override
            public Predicate toPredicate(Root<Htzl> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> list = new ArrayList<Predicate>();
                if (Constants.ROLE_USER == user.getRole()) {
                    list.add(cb.equal(root.get("ddczy"), user.getUserName()));
                }

                if (cgjqWarnType > 0) {
                    Long endtime = System.currentTimeMillis() + cgjqWarnType * 24 * 3600 * 1000;
                    Expression<Long> cgjq = root.get("cgjq");
                    list.add(cb.le(cgjq, endtime));
                } else {

                    if (startJq > 0) {
                        Expression<Long> cgjq = root.get("cgjq");
                        list.add(cb.ge(cgjq, startJq));
                    }

                    if (endJq > 0) {
                        Expression<Long> cgjq = root.get("cgjq");
                        list.add(cb.le(cgjq, endJq));
                    }

                    if (zjcs > 0) {
                        Expression<Integer> cgjq = root.get("zjcs");
                        list.add(cb.ge(cgjq, zjcs));
                    }

                    if (cycs > 0) {
                        Expression<Long> cgjq = root.get("cyjccs");
                        list.add(cb.ge(cgjq, cycs));
                    }
                }
                //TODO here~
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        };

        return htzlRepository.findAll(specification, pageRequest);
    }


    @Transactional
    public boolean save(HtzlDto dto) {
        Htzl htzl = htzlRepository.findOne(dto.getId());
        if (null == htzl) {
            return false;
        }

        List<Gdzj> gdzjList = dto.getZjs();
        List<Cyjy> cyjyList = dto.getCjs();

        if (null != gdzjList && gdzjList.size() > 0) {
            int addcount = 0;
            for (Gdzj gdzj : gdzjList) {
                if ( null != gdzj.getId() && gdzj.getId() > 0) {
                    continue;
                }
                addcount++;
                gdzj.setHtId(dto.getId());
                if (null == gdzjRepository.save(gdzj)) {
                    throw new RuntimeException("save gdzj failed");
                }
            }
            htzl.setZjcs(htzl.getZjcs() + addcount);
        }

        if (null != cyjyList && cyjyList.size() > 0) {
            int addcount = 0;
            for (Cyjy cyjy : cyjyList) {
                if ( null != cyjy.getId() && cyjy.getId() > 0) {
                    continue;
                }
                addcount++;
                cyjy.setHtId(dto.getId());
                if (null == cyjyRepository.save(cyjy)) {
                    throw new RuntimeException("save cyjy failed");
                }
            }
            htzl.setCyjccs(htzl.getCyjccs() + addcount);
        }

        htzl.setYpqrsj(dto.getYpqrsj());
        htzl.setPsdqysj(dto.getPsdqysj());
        htzl.setCsyq(dto.getCsyq());
        htzl.setCswcsj(dto.getCswcsj());

        if (null == htzlRepository.save(htzl)) {
            throw new RuntimeException("save htzl failed");
        }

        return true;
    }


}
