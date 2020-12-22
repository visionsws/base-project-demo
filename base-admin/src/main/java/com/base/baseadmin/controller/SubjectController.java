package com.base.baseadmin.controller;


import com.base.baseadmin.api.CommonResult;
import com.base.baseadmin.entity.SaSubject;
import com.base.baseadmin.service.ISaSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Api(tags = "SubjectController", description = "专题管理")
@Slf4j
@RequestMapping("/subject")
@RestController
@RefreshScope
public class SubjectController {

    @Value("${user.name}")
    private String username;

    @Value("${user.id}")
    private String userid;

    @Value("${user.code}")
    private String usercode;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.password}")
    private String password;

    @Autowired
    private ISaSubjectService saSubjectService;

    private int count = 0;

    @GetMapping("getNacosConfig")
    public String getNacosConfig() {
        System.out.println("username:"+username);
        System.out.println("userid:"+userid);
        System.out.println("usercode:"+usercode);
        System.out.println("datasourceUrl:"+datasourceUrl);
        System.out.println("password:"+password);
        return username;
    }

    /**
     * 获取所有的专题
     * @return
     */
    @ApiOperation("获取所有专题")
    @GetMapping("/getSubject")
    public CommonResult getSubject(){
        log.info("调用getSubject接口，参数为空");
        List<SaSubject> list = saSubjectService.list();
        return CommonResult.success(list);
    }

    /**
     * 根据id获取专题
     * @param subjectId 专题id
     * @return
     */
    @ApiOperation("根据id获取专题")
    @RequestMapping(value = "/getSubjectById",method = {RequestMethod.POST,RequestMethod.GET })
    public CommonResult getSubjectById(@RequestParam @ApiParam("专题id") Long subjectId){
        log.info("调用getSubjectById接口，参数为：{}",subjectId);
        SaSubject sa = saSubjectService.getById(subjectId);
        return CommonResult.success(sa);
    }

    /**
     * 保存专题
     * @param subject
     * @return
     */
    @ApiOperation("保存专题")
    @PostMapping("/saveSubject")
    public CommonResult saveSubject(@RequestBody SaSubject subject){
        log.info("调用saveSubject接口，参数为：{}",subject);
        SaSubject saSubject = new SaSubject();
        saSubject.setCategoryId(1L);
        saSubject.setCategoryName("服装专题");
        saSubject.setTitle("男衬衫"+count++);
        saSubject.setCreateTime(LocalDateTime.now());
        saSubjectService.save(saSubject);
        return CommonResult.success(saSubject);
    }

}
