package org.web.auction.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.web.auction.pojo.Auction;
import org.web.auction.pojo.Auctionrecord;
import org.web.auction.pojo.Result;
import org.web.auction.pojo.User;
import org.web.auction.service.AuctionService;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;

@Controller
public class AuctionController {

    @Reference
    private AuctionService auctionservice;

    public static final int PAGE_SIZE = 10;

    @RequestMapping("/queryAuctions")
    public ModelAndView queryAuctions(
            @RequestParam(value="pageNo",required=false,defaultValue="1")int pageNo){
        ModelAndView mv = new ModelAndView();

        Result result = auctionservice.queryAuctions(pageNo,PAGE_SIZE);
        mv.addObject("auctionList", result.getData());
        mv.addObject("pageInfo", result.getPageInfo());

        //获取Shiro上下文中的用户身份对象
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        mv.addObject("user",user);
        mv.setViewName("index");
        return mv;

    }

    //商品基本数据的添加和文件上传
    @RequestMapping("/publishAuctions")
    public String publishAuctions(Auction auction, MultipartFile pic) {
        try {
            //1.文件上传
            //先判断是否有文件数据, pic不为null
            if (pic.getSize() > 0) {
                //把文件保存到tomcat目录之下, 先要获取文件保存的绝对路径
                String path = "d:/file";

                String filename = pic.getOriginalFilename();
                File targetFile = new File(path, filename );
                pic.transferTo(targetFile );

                //设置图片的参数
                auction.setAuctionpic(filename);
                auction.setAuctionpictype(pic.getContentType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //2.添加商品数据
        auctionservice.addAuction(auction);

        return "redirect:/queryAuctions";

    }

    @GetMapping("/toAdd")
    public String toAdd(){
        return "addAuction";
    }

    //Restful
    @RequestMapping("/toDetail/{id}")
    public ModelAndView toDetail(@PathVariable int id){
        ModelAndView mv = new ModelAndView();
        Auction auctionDetail = auctionservice.findAuctionAndAuctionRecordList(id);
        mv.addObject("auctionDetail",auctionDetail);
        mv.setViewName("auctionDetail");
        return mv;
    }

    //mapper--service--handler--DispatcherServlet--异常处理器
    @RequestMapping("/saveAuctionRecord")
    public String saveAuctionRecord(Auctionrecord record, HttpSession session) throws Exception {
        record.setAuctiontime(new Date());
        //User loginUser = (User)session.getAttribute("user");
        User loginUser = (User)SecurityUtils.getSubject().getPrincipal();
        record.setUserid(loginUser.getUserid());
        auctionservice.addAuctionRecord(record);
        return "redirect:/toDetail/"+record.getAuctionid();
    }
}
