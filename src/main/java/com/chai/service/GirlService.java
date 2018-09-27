package com.chai.service;

import com.chai.domain.Girl;
import com.chai.enums.ResultEnum;
import com.chai.exception.GirlException;
import com.chai.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @Author: minquan.chai@hand-china.com
 * @Modificd By:
 * @Date: Created in chai on 2018/9/25.
 */

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;


    @Transactional
    public void insertTwo() {
        Girl girl1 = new Girl();
        girl1.setCupSize("A");
        girl1.setAge(18);
        girlRepository.save(girl1);

        Girl girl2 = new Girl();
        girl2.setCupSize("B");
        girl2.setAge(19);
        girlRepository.save(girl2);
    }

    /**
     * 通过ID获取女生年龄进行判断
     * @param id
     * @throws Exception
     */
    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findById(id).orElse(null);
        Integer age = girl.getAge();
        if(age < 10) {
            //返回“你应该还是再读小学吧” code=100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if(age > 10 && age < 16) {
            //返回“你应该还是再读初中吧” code=101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过Id查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id) {
        return girlRepository.findById(id).orElse(null);
    }
}
