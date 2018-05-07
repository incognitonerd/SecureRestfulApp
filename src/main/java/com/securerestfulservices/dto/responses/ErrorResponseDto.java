package com.securerestfulservices.dto.responses;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"code", "status", "message"})
public class ErrorResponseDto extends AbstractResponseDto {
}
