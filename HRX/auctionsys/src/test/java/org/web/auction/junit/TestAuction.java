package org.web.auction.junit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.web.auction.mapper.AuctionCustomMapper;
import org.web.auction.mapper.UserMapper;
import org.web.auction.pojo.Auction;
import org.web.auction.pojo.Auctionrecord;
import org.web.auction.pojo.User;

import java.util.List;

@SpringBootTest
public class TestAuction {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AuctionCustomMapper auctionCustomMapper;

    @Test
    public void testQueryUser() {
        List<User> list = userMapper.selectByExample(null);
        for (User user: list) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryAuction(){
        Auction auction = auctionCustomMapper.findAuctionAndAuctionRecordList(4);
        System.out.println(auction.getAuctionname());
        System.out.println(auction.getAuctionendtime());
        List<Auctionrecord> records = auction.getAuctionrecordList();
        for (Auctionrecord record:records) {
            System.out.println(record.getAuctiontime()+","+record.getAuctionprice()+","+record.getUser().getUsername());
        }
    }
}
