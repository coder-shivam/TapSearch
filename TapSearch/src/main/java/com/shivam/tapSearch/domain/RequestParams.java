package com.shivam.tapSearch.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RequestParams {

	@JsonProperty("Document")
    String document;

    @JsonProperty("WordToSearch")
    String wordToSearch;
}
