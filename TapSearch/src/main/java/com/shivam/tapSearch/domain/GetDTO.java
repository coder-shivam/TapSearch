package com.shivam.tapSearch.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GetDTO {
	
	@JsonProperty("Paragraphs")
    String paragraphs;

    @JsonProperty("Message")
    String message;
    
    @JsonProperty("Status")
    String status;
}
