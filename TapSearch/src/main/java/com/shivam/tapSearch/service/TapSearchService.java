package com.shivam.tapSearch.service;

import com.shivam.tapSearch.domain.GetDTO;

public interface TapSearchService {

	final static Integer topN_Paragraphs = 10;
	
	public void indexParagraph(String[] doc);
	
	public GetDTO searchWord(String word);
	
}
