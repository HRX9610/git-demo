package org.web.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web.auction.mapper.AuctionCustomMapper;
import org.web.auction.mapper.AuctionMapper;
import org.web.auction.mapper.AuctionrecordMapper;
import org.web.auction.pojo.Auction;
import org.web.auction.pojo.Auctionrecord;
import org.web.auction.utils.CustomException;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AuctionServiceImpl implements AuctionService{

    @Autowired
    private AuctionMapper auctionMapper;

    @Autowired
    private AuctionCustomMapper auctionCustomMapper;

    @Autowired
    private AuctionrecordMapper auctionrecordMapper;

    @Override
    public List<Auction> queryAuctions() {
        return auctionMapper.selectByExample(null);
    }

    @Override
    public void addAuction(Auction auction) {
        auctionMapper.insert(auction);
    }

    @Override
    public Auction findAuctionAndAuctionRecordList(int id) {
        return auctionCustomMapper.findAuctionAndAuctionRecordList(id);
    }
    @Override  //使用异常处理器
    public void addAuctionRecord(Auctionrecord record) throws Exception {
        //先查询商品的详情(使用映射的方法来封装: List<AuctionRecord>)
        Auction auction = auctionCustomMapper.findAuctionAndAuctionRecordList(record.getAuctionid());
        //1. 判断竞拍时间
        if (auction.getAuctionendtime().after(new Date()) == false) {
            throw new CustomException("该商品拍卖时间已经结束");
        }
        //判断是否有竞拍记录
        if (auction.getAuctionrecordList()!=null && auction.getAuctionrecordList().size()>0) {
            //3. 如果当前商品已经竞拍， 竞拍价格必须高于当前的最高竞价
            //集合的第一条记录就是最高竞价记录（排序后）
            Auctionrecord maxRecord = auction.getAuctionrecordList().get(0);
            if (record.getAuctionprice() <= maxRecord.getAuctionprice()) {
                throw new CustomException("竞拍价格必须高于当前的最高竞价");
            }

        } else { //第一次竞价: 2. 如果当前商品没有竞拍记录，竞拍价格必须高于起拍价
            if (record.getAuctionprice() <= auction.getAuctionstartprice()) {
                throw new CustomException("竞拍价格必须高于起拍价");
            }
        }
        auctionrecordMapper.insert(record);
    }
}
