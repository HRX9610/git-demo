package org.web.auction.service;

import org.web.auction.pojo.Auction;
import org.web.auction.pojo.Auctionrecord;
import org.web.auction.pojo.Result;

import java.util.List;

public interface AuctionService {
    public List<Auction> queryAuctions();
    public Result queryAuctions(int pageNum, int pageSize);
    public void addAuction(Auction auction);
    public Auction findAuctionAndAuctionRecordList(int id);
    public void addAuctionRecord(Auctionrecord record) throws Exception;
}
