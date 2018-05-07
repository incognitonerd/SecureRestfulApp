package com.securerestfulservices.mappers;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.securerestfulservices.dto.entities.randomqueries.TwoMostPopRegDatesDTO;

public class TwoMostPopRegDatesMapper implements RowMapper<TwoMostPopRegDatesDTO> {
	@Override
	public TwoMostPopRegDatesDTO mapRow(ResultSet r, int rowNum) throws SQLException{
		TwoMostPopRegDatesDTO dto = new TwoMostPopRegDatesDTO(r.getString("day"), r.getInt("total"));
		return dto;
	}
}
