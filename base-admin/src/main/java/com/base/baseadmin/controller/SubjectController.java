package com.base.baseadmin.controller;

import com.base.basecommon.api.CommonResult;
import com.base.basemapper.entity.SaSubject;
import com.base.basemapper.service.ISaSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;
import java.util.List;

@Api(tags = "SubjectController", description = "专题管理")
@Slf4j
@RequestMapping("/subject")
@RestController
public class SubjectController {

    @Autowired
    private ISaSubjectService saSubjectService;

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
        return CommonResult.success(subject);
    }

}
