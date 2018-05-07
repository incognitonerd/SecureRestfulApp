package com.securerestfulservices.mappers;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.securerestfulservices.dto.entities.randomqueries.MostPopPhotoDTO;

public class MostPopPhotoMapper implements RowMapper<MostPopPhotoDTO> {
	@Override
	public MostPopPhotoDTO mapRow(ResultSet r, int rowNum) throws SQLException{
		MostPopPhotoDTO dto = new MostPopPhotoDTO(r.getString("username"), r.getString("photos.image_url"),
				r.getInt("totalLikes"));
		return dto;
	}
}
