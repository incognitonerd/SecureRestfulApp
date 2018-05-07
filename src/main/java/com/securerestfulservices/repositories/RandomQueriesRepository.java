package com.securerestfulservices.repositories;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.securerestfulservices.dto.entities.randomqueries.AvgPhotosPerUserDTO;
import com.securerestfulservices.dto.entities.randomqueries.FiveMostPopHashtagsDTO;
import com.securerestfulservices.dto.entities.randomqueries.InactiveUsersDTO;
import com.securerestfulservices.dto.entities.randomqueries.MostPopPhotoDTO;
import com.securerestfulservices.dto.entities.randomqueries.TwoMostPopRegDatesDTO;
import com.securerestfulservices.dto.entities.randomqueries.UsersWhoMayBeBotsDTO;
import com.securerestfulservices.mappers.AvgPhotosPerUserMapper;
import com.securerestfulservices.mappers.FiveMostPopHashtagsMapper;
import com.securerestfulservices.mappers.InactiveUsersMapper;
import com.securerestfulservices.mappers.MostPopPhotoMapper;
import com.securerestfulservices.mappers.TwoMostPopRegDatesMapper;
import com.securerestfulservices.mappers.UsersWhoMayBeBotsMapper;

@Repository
public class RandomQueriesRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(RandomQueriesRepository.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<TwoMostPopRegDatesDTO> getTwoMostPopRegDates(){
		List<TwoMostPopRegDatesDTO> result = this.jdbcTemplate.query("SELECT DAYNAME(created_at) AS day, COUNT(*) AS total"
				+ " FROM users GROUP BY day ORDER BY total DESC LIMIT 2", new TwoMostPopRegDatesMapper());
		return result;
	}
	
	public List<InactiveUsersDTO> getInactiveUsers(){
		List<InactiveUsersDTO> result = this.jdbcTemplate.query(
				"SELECT username FROM users LEFT JOIN photos ON users.id = photos.user_id  WHERE photos.id IS NULL",
				new InactiveUsersMapper());
		return result;
	}
	
	public List<MostPopPhotoDTO> getMostPopPhoto(){
		List<MostPopPhotoDTO> result = this.jdbcTemplate.query(
				"SELECT username, photos.image_url, COUNT(*) AS totalLikes FROM photos INNER JOIN likes ON likes.photo_id = photos.id "
						+ "INNER JOIN users ON photos.user_id = users.id GROUP BY photos.id ORDER BY totalLikes DESC LIMIT 1",
				new MostPopPhotoMapper());
		return result;
	}
	
	public List<AvgPhotosPerUserDTO> getAvgPhotosPerUser(){
		List<AvgPhotosPerUserDTO> result = this.jdbcTemplate.query(
				"SELECT (SELECT Count(*)  FROM  photos) AS totalPhotos, (SELECT Count(*) FROM  users) AS totalUsers,  "
						+ "(SELECT Count(*)  FROM  photos)  / (SELECT Count(*) FROM  users) AS avgPhotosPerUser",
				new AvgPhotosPerUserMapper());
		return result;
	}
	
	public List<FiveMostPopHashtagsDTO> getFiveMostPopHashtags(){
		List<FiveMostPopHashtagsDTO> result = this.jdbcTemplate.query(
				"SELECT tags.tag_name AS tagName, Count(*) AS total FROM   photoTags JOIN tags ON photoTags.tag_id = tags.id  "
						+ "GROUP  BY tags.id ORDER  BY total DESC LIMIT  5",
				new FiveMostPopHashtagsMapper());
		return result;
	}
	
	public List<UsersWhoMayBeBotsDTO> getUsersWhoMayBeBots(){
		List<UsersWhoMayBeBotsDTO> result = this.jdbcTemplate.query(
				"SELECT username, Count(*) AS numOflikes FROM   users INNER JOIN likes ON users.id = likes.user_id GROUP  BY likes.user_id "
						+ "HAVING numOflikes = (SELECT Count(*) FROM   photos)",
				new UsersWhoMayBeBotsMapper());
		return result;
	}
}
