package com.cn21.account.gateway.business.resourcepackage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
* @author: Chenzhenyong
* @description:
* @date: Created in 14:36 2018/8/5
*/
@RestController
@RequestMapping("/api/resource")
public class DownloadController {

    /**
     * download
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response) {

        String filePath = "/home/gsw.zip";
        try {
            File file = new File(filePath);
            if(!file.exists()) {
                return;
            }
            InputStream ips = new BufferedInputStream(new FileInputStream(filePath));

            response.reset();
            response.setContentType("bin");
            response.addHeader("Content-Disposition", "attachment;filename="
                    + new String(file.getName().getBytes()));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = ips.read(buffer)) > 0) {
                response.getOutputStream().write(buffer, 0, len);
            }
            ips.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

}
