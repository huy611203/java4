package service.Impl;

import java.util.List;

import dao.StatsDao;
import dao.iplm.StatsDaoImpl;
import dto.VideoLikedInfo;
import service.StatsService;

public class StatsServiceImpl implements StatsService{
     private StatsDao statsDao;
     public StatsServiceImpl() {
    	 statsDao = new StatsDaoImpl();
     }
	@Override
	public List<VideoLikedInfo> likedInfos() {
		return statsDao.findVideoLikedInfo();
	}

}
