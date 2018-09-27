package com.chai.controller;

import com.chai.domain.Girl;
import com.chai.domain.Result;
import com.chai.enums.ResultEnum;
import com.chai.repository.GirlRepository;
import com.chai.service.GirlService;
import com.chai.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: minquan.chai@hand-china.com
 * @Modificd By:
 * @Date: Created in chai on 2018/9/25.
 */

@RestController
public class GirlController {


    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有girl的列表
     * @return
     */
    @GetMapping(value = "/girls")
    public Result<List<Girl>> girlList() {
        return ResultUtil.success(girlRepository.findAll(), ResultEnum.SUCCESS);
    }

    /**
     * 添加一个女生
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> addGirl(@Valid Girl girl , BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }


        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        girl.setMoney(girl.getMoney());
        return ResultUtil.success(girlRepository.save(girl),ResultEnum.SUCCESS);
    }

    /**
     * 根据id查询girl
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Result<Girl> getGirlByID(@PathVariable("id") Integer id) {
        //如果用户存在则返回这个对象，如果不存在则返回null
        if(girlRepository.findById(id).orElse(null)==null){
            return ResultUtil.error(1,"没有该数据");
        }
        return ResultUtil.success(girlRepository.findById(id).orElse(null),ResultEnum.SUCCESS);
    }

    /**
     * 根据id更新girl
     * @param id
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Result<Girl> updateGirlByID(@PathVariable("id") Integer id,@Valid Girl girl,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        if(girlRepository.findById(id).orElse(null)==null) {
            return ResultUtil.error(1,"没有该数据");
        }
        girl.setId(id);
        return ResultUtil.success(girlRepository.save(girl),ResultEnum.SUCCESS);
    }

    /**
     * 根据id删除girl
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public Result deleteGirlByID(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
        return ResultUtil.success();
    }

    /**
     * 根据年龄查询girl
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public Result<List<Girl>> getGirlListByAge(@PathVariable("age") Integer age) {

        if(girlRepository.findByAge(age).isEmpty()){
            return ResultUtil.error(1,"没有该数据");
        }
        return ResultUtil.success(girlRepository.findByAge(age),ResultEnum.SUCCESS);
    }

    /**
     * 事务管理
     * @return
     */
    @PostMapping(value = "/girls/two")
    public Result insertTwo() {
        girlService.insertTwo();
        return ResultUtil.success();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
 }
