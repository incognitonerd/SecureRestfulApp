package com.securerestfulservices.mappers;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.securerestfulservices.dto.entities.randomqueries.UsersWhoMayBeBotsDTO;

public class UsersWhoMayBeBotsMapper implements RowMapper<UsersWhoMayBeBotsDTO> {
	@Override
	public UsersWhoMayBeBotsDTO mapRow(ResultSet r, int rowNum) throws SQLException{
		UsersWhoMayBeBotsDTO dto = new UsersWhoMayBeBotsDTO(r.getString("username"), r.getInt("numOflikes"));
		return dto;
	}
}
