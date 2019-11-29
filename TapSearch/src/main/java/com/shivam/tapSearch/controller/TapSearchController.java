package com.shivam.tapSearch.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.tapSearch.domain.GetDTO;
import com.shivam.tapSearch.domain.RequestParams;
import com.shivam.tapSearch.service.TapSearchServiceImpl;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TapSearchController {

	private TapSearchServiceImpl service;

	@Autowired
    public TapSearchController(@NonNull TapSearchServiceImpl service) {
        this.service = service;
    }
	
	@CrossOrigin
    @RequestMapping(value = "/indexParagraph", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GetDTO> indexParagraph(@RequestBody RequestParams request) {
    	GetDTO getDto = new GetDTO();
    	log.info("Inside indexParagraph");
    	if(request.getDocument() == null || request.getDocument().isEmpty()){
    		getDto.setParagraphs(null);
    		getDto.setMessage("Document Content is empty");
    		getDto.setStatus("404");
    	}else{
    		String[] para = request.getDocument().split("\\r?\\n\\r?\\n");
        	log.info("Splitting Document into Paragraphs");
        	service.indexParagraph(para);
        	getDto.setMessage("Indexing has been done. Please proceed to search.");
        	getDto.setStatus("200");
    	}

    	return ResponseEntity.ok(getDto);
    }
	
	@CrossOrigin
    @RequestMapping(value = "/searchWord", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GetDTO> searchWord(@RequestBody RequestParams request) {
    	log.info("Inside searchWord");
    	GetDTO getDto = new GetDTO();
    	if(request.getWordToSearch() == null || request.getWordToSearch().isEmpty()){
    		getDto.setParagraphs(null);
    		getDto.setMessage("Word to be Searched is Empty.");
    		getDto.setStatus("404");
    	}else{
    		getDto = service.searchWord(request.getWordToSearch());
    	}
    	
        return ResponseEntity.ok(getDto);
    }
	
	@CrossOrigin
    @RequestMapping(value = "/clearIndexing", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GetDTO> clearIndexing(@RequestBody RequestParams request) {
		log.info("Inside clearIndexing");
    	GetDTO getDto = new GetDTO();
    	service.indexParagraph(null);
    	getDto.setMessage("Cleared Successfully");
    	getDto.setStatus("200");
        return ResponseEntity.ok(getDto);
    }
}
