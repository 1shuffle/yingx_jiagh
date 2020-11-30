package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.ImageCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("getImageCode")
    public void getImageCode(HttpSession session, HttpServletResponse response){

        //获取随机字符
        String imageCode = ImageCodeUtil.getSecurityCode();
        System.out.println("验证码: "+imageCode);

        //存session
        session.setAttribute("imageCode",imageCode);

        //根据随机字符生成验证码图片
        BufferedImage image = ImageCodeUtil.createImage(imageCode);

        try {
            ImageIO.write(image,"png",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping("login")
    public HashMap<String, Object> login(Admin admin, String code){

        return adminService.login(admin, code);
    }
}
