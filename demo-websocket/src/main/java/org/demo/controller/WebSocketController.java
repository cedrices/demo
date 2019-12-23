package org.demo.controller;

import org.demo.server.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * WebSocketController
 *
 * @author hss
 * @date 2019/12/16 15:18
 */
@Controller("webSocket")
public class WebSocketController{

    @Autowired
    private WebSocketServer webSocketServer;

        //页面请求
        @GetMapping("/socket/{cid}")
        public ModelAndView socket(@PathVariable String cid) {
            ModelAndView mav=new ModelAndView("/socket");
            mav.addObject("cid", cid);
            return mav;
        }
        //推送数据接口
        @ResponseBody
        @RequestMapping("/socket/push/{cid}")
        public String pushToWeb(@PathVariable String cid,String message) {
            try {
                WebSocketServer.sendInfo(message,cid);
            } catch (IOException e) {
                e.printStackTrace();
                return cid+"#"+e.getMessage();
            }
            return cid.concat("#").concat("推送成功");
        }
}
