package dao;

import java.util.List;

import model.History;

public interface HistoryDao {
      List<History> findByUser(String username);
      List<History> findByUserAndIsliked(String username);
      History findByUserIdAndVideoId(Integer userId,Integer videoId);
      History create(History entity);
      History update(History entity);
}
