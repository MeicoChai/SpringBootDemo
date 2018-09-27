package com.chai;

import com.chai.domain.Girl;
import com.chai.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: minquan.chai@hand-china.com
 * @Modificd By:
 * @Date: Created in chai on 2018/9/27.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest() {
        Girl girl = girlService.findOne(17);
        Assert.assertEquals(new Integer(9),girl.getAge());
    }
}
