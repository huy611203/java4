package service;

import java.util.List;

import model.History;
import model.User;
import model.Video;

public interface HistoryService {
	List<History> findByUser(String username);
    List<History> findByUserAndIsliked(String username);
    History findByUserIdAndVideoId(Integer userId,Integer videoId);
    History create(User user, Video video);
    boolean updateLikeOrUnLike(User user,String videoHref);
}
