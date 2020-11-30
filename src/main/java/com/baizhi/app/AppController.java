package com.baizhi.app;

import com.baizhi.common.CommonResult;
import com.baizhi.po.CategoryPO;
import com.baizhi.po.VideoPO;
import com.baizhi.service.CategoryService;
import com.baizhi.service.VideoService;
import com.baizhi.util.AliyunUtil;
import com.baizhi.util.ImageCodeUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("app")
public class AppController {
    @Resource
 VideoService videoService;
    @Resource
    private CategoryService categoryService;

    @RequestMapping("getPhoneCode")
    public Object getPhoneCode(String phone){

        String randomCode= ImageCodeUtil.getSecurityCode();
        System.out.println("手机验证码："+randomCode);

        String message=null;
        try {
            message= AliyunUtil.phone(phone,randomCode);
            return new CommonResult().success("100",message,phone);
        }catch (Exception e){
            return new CommonResult().failed(message);
        }

    }
    @RequestMapping("queryByReleaseTime")
    public CommonResult queryByReleaseTime(){
        try {
            List<VideoPO> videoPOS = videoService.queryByReleaseTime();
            return new CommonResult().success(videoPOS);
        }catch (Exception e){
            return new CommonResult().failed();
        }
    }

    @RequestMapping("queryAllCategory")
    public CommonResult queryAllCategory(){
        try {
            List<CategoryPO> categoryPOS = categoryService.queryAllCategory();
            return new CommonResult().success(categoryPOS);
        }catch (Exception e){
            return new CommonResult().failed();
        }
    }
}
