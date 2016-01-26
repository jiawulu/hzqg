package com.lu;

import com.lu.dao.GdsjRepository;
import com.lu.dao.GdzjRepository;
import com.lu.dao.HtzlRepository;
import com.lu.domain.Htzl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringbootApplication.class)
@WebAppConfiguration
public class SpringbootApplicationTests {

    @Autowired
    private HtzlRepository htzlRepository;
    @Autowired
    private GdsjRepository gdsjRepository;
    @Autowired
    private GdzjRepository gdzjRepository;

    @Test
    public void contextLoads() {

        for (int i = 0; i < 20; i++) {
            Htzl htzl = new Htzl();

            htzl.setBmmll(i);
            htzl.setKh("no:" + i);
            htzl.setKfddh("dh:" + i);

            htzl = htzlRepository.save(htzl);
        }

    }


    @Test
    public void testPage() {


        List<Htzl> list = htzlRepository.findBySql("2");
        Assert.assertTrue(list.size() > 0);

        Page<Htzl> page1 = htzlRepository.findAll(new PageRequest(0,5));
        Assert.assertTrue(page1.getTotalPages() > 0);
        Assert.assertTrue(page1.getContent().size() > 0);

        Sort sort = new Sort(Sort.Direction.DESC,"id");

        Page<Htzl> page2 = htzlRepository.findAll(new PageRequest(0,5,sort));
        Assert.assertTrue(page1.getTotalPages() > 0);
        Assert.assertTrue(page1.getContent().size() > 0);

    }

    @Test
    public void testSpecification(){

//        Specifications<Htzl> specification = Specifications.where(createSpeci());
//        specification.and(new Specification<Htzl>() {
//            @Override
//            public Predicate toPredicate(Root<Htzl> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//                return cb.lessThan(root.get("id").as(Integer.class),10);
//            }
//        });

        List<Htzl> list = htzlRepository.findAll(createSpeci());
        Assert.assertTrue(list.size() > 0);

    }

    private  Specification<Htzl> createSpeci() {

        return new Specification<Htzl>() {
            @Override
            public Predicate toPredicate(Root<Htzl> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                Predicate p1 = cb.equal(root.get("bmmll"),"2");
                Predicate p2 = cb.lessThan(root.get("id").as(Integer.class),10);

                query.where(cb.and(p1,p2));
                //添加排序的功能
                query.orderBy(cb.desc(root.get("id").as(Integer.class)));

                return query.getRestriction();

//                return predicate;
            }
        };
    }

}
