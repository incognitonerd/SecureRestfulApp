package com.securerestfulservices.dto.entities.security;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserCountDto {
	@JsonProperty("total_user_count")
	private long userCount = 0;

	public UserCountDto(){}

	public UserCountDto(long count) {
		this.userCount = count;
	}

	public long getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	

}
