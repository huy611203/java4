package service.Impl;

import java.sql.Timestamp;
import java.util.List;

import dao.HistoryDao;
import dao.iplm.HistoryDaoImpl;
import model.History;
import model.User;
import model.Video;
import service.HistoryService;
import service.VideoService;

public class HistoryServiceImpl implements HistoryService {
    private HistoryDao dao;
    private VideoService videoService = new VideoServiceImpl();
    public HistoryServiceImpl() {
    	dao = new HistoryDaoImpl();
    }
	@Override
	public List<History> findByUser(String username) {
		return dao.findByUser(username);
	}

	@Override
	public List<History> findByUserAndIsliked(String username) {
		return dao.findByUserAndIsliked(username);
	}

	@Override
	public History findByUserIdAndVideoId(Integer userId, Integer videoId) {
		return dao.findByUserIdAndVideoId(userId, videoId);
	}

	@Override
	public History create(User user, Video video) {
		History existhistory = findByUserIdAndVideoId(user.getId(),video.getId());
		if (existhistory == null) {
			existhistory = new History();
			existhistory.setUser(user);
			existhistory.setVideo(video);
			existhistory.setViewedDate(new Timestamp(System.currentTimeMillis()));
			existhistory.setIsLiked(Boolean.FALSE);
			dao.create(existhistory);
		}
		
		return existhistory;
	}

	@Override
	public boolean updateLikeOrUnLike(User user, String videoHref) {
		Video video = videoService.findByHref(videoHref);
		History existHistory = findByUserIdAndVideoId(user.getId(),video.getId());
		if (existHistory.getIsLiked() == Boolean.FALSE) {
			existHistory.setIsLiked(Boolean.TRUE);
			existHistory.setLikedDate(new Timestamp(System.currentTimeMillis()));
		}else {
			existHistory.setIsLiked(Boolean.FALSE);
			existHistory.setLikedDate(null);
		}
		History updateHistory = dao.update(existHistory);
		return updateHistory != null ? true : false;
	}

}
