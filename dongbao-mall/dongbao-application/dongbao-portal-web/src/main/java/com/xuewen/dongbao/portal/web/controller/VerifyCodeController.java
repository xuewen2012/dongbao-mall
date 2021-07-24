package com.xuewen.dongbao.portal.web.controller;

import com.xuewen.dongbao.common.base.annotations.TokenCheck;
import com.xuewen.dongbao.portal.web.code.ImageCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/code")
public class VerifyCodeController {

    String attrName = "verfiyCode";

    @GetMapping("/generator")
    @TokenCheck(required=false)
    public void generatorCode(HttpServletRequest request, HttpServletResponse response) {
        try {
            ImageCode imageCode = ImageCode.getInstance();

            String code = imageCode.getCode();
            ByteArrayInputStream image = imageCode.getImage();

            request.getSession().setAttribute(attrName, code);

            response.setContentType("image/jpeg");
            byte[] bytes = new byte[1024];
            try(ServletOutputStream outputStream = response.getOutputStream()) {
                while (image.read(bytes) != -1) {
                    outputStream.write(bytes);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/verify")
    @TokenCheck(required=false)
    public String verify(String verifyCode, HttpServletRequest request) {
        String s = request.getSession().getAttribute(attrName).toString();
        if(verifyCode != null && verifyCode.equals(s)) {
            return "验证码校验通过";
        }else {
            return "验证码校验不通过";
        }
    }
}
