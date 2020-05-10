package cn.xkz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * springmvc文件上传
     * @return
     */
    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("springmvc文件上传...");
        //使用fileupload组件完成文件上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断,该路径是否存在
        File file = new File(path);
        if(!file.exists()){
            //创建文件夹
            file.mkdirs();
        }
        //说明上传文件项
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        //把文件的名称设置唯一值,uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = filename+uuid;
        //完成文件上传
        upload.transferTo(new File(path,filename));

        return "success";
    }
}
