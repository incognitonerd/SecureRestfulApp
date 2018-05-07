package com.securerestfulservices.utils;

import com.securerestfulservices.dto.responses.ErrorResponseDto;
import com.securerestfulservices.dto.responses.SuccessResponseDto;

public class ResponseUtil {

	public static SuccessResponseDto<Object> success(){
		return new SuccessResponseDto<Object>();
	}
	
	public static ErrorResponseDto error(){
		return new ErrorResponseDto();
	}
}
