package com.securerestfulservices.mappers;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.securerestfulservices.dto.entities.randomqueries.AvgPhotosPerUserDTO;

public class AvgPhotosPerUserMapper implements RowMapper<AvgPhotosPerUserDTO> {
	@Override
	public AvgPhotosPerUserDTO mapRow(ResultSet r, int rowNum) throws SQLException{
		AvgPhotosPerUserDTO dto = new AvgPhotosPerUserDTO(r.getInt("totalPhotos"), r.getInt("totalUsers"),
				r.getDouble("avgPhotosPerUser"));
		return dto;
	}
}
