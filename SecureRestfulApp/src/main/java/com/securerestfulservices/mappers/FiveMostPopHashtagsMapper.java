package com.securerestfulservices.mappers;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.securerestfulservices.dto.entities.randomqueries.FiveMostPopHashtagsDTO;

public class FiveMostPopHashtagsMapper implements RowMapper<FiveMostPopHashtagsDTO> {
	@Override
	public FiveMostPopHashtagsDTO mapRow(ResultSet r, int rowNum) throws SQLException{
		FiveMostPopHashtagsDTO dto = new FiveMostPopHashtagsDTO(r.getString("tagName"), r.getInt("total"));
		return dto;
	}
}
