package com.shivam.tapSearch.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.shivam.tapSearch.domain.GetDTO;
import com.shivam.tapSearch.domain.Tuple;
import com.shivam.tapSearch.utility.GenerateUniqueId;

@Service
public class TapSearchServiceImpl implements TapSearchService {

	Map<String, List<Tuple>> index = new HashMap<String, List<Tuple>>();

	Map<Integer, String> paragraphContent = new HashMap<Integer, String>();

	public void indexParagraph(String[] para) {
		
		if(para == null){
			index.clear();
			paragraphContent.clear();
			return;
		}
		int paraId = 0;
		int paraInsertionId = 1;
		for (String pa : para) {
			paraId = GenerateUniqueId.generateUniqueId();
			paragraphContent.put(paraId, pa);
			for (String word : pa.split("\\s")) {
				word = word.toLowerCase();
				boolean flag = true;
				List<Tuple> idx = index.get(word);
				if (idx == null) {
					idx = new LinkedList<Tuple>();
					index.put(word, idx);

				} else {
					Iterator<Tuple> itr = idx.iterator();
					while (itr.hasNext()) {
						Tuple t = itr.next();
						if (t.getParaId() == paraId)
							flag = false;
					}
				}
				if (flag) {
					Tuple t = new Tuple();
					t.setParaInsertionId(paraInsertionId);
					t.setParaId(paraId);
					idx.add(t);
				//	System.out.println("ParaInsertionId : " + paraInsertionId + " Paragraph ID : " + paraId);
					paraInsertionId++;
				}

			}
			System.out.println(" Paragraph ID : " + paraId + "Para Content : " + paragraphContent.get(paraId));
		}
	}

	@Override
	public GetDTO searchWord(String word) {
		
		GetDTO getDTO = new GetDTO();
		
		if(index.isEmpty() || index == null){
			getDTO.setParagraphs(null);
			getDTO.setMessage("Indexing has not been done! First do indexing.");
			getDTO.setStatus("401");
			return getDTO;
		}
		List<Tuple> answer = new ArrayList<Tuple>();
		word = word.toLowerCase();
		List<Tuple> idx = index.get(word);
		if (idx != null) {
			for (Tuple t : idx) {
				answer.add(t);
			}
		}
		
		System.out.println("Word to Search : " + word + "\n");
		int paraCounter = 1;
		String paragraphs = "";
		String abc = "\n\n";
		for (Tuple t : answer) {
			if(paraCounter > topN_Paragraphs)
				break;
		//	System.out.println(t.getParaInsertionId() + ". Paragraph ID : " + t.getParaId());
		//	System.out.println(paragraphContent.get(t.getParaId()));
			paragraphs = paragraphs.concat(paragraphContent.get(t.getParaId()) + abc);
			paraCounter++;
		}
		getDTO.setParagraphs(paragraphs);
		System.out.println("\n" + paragraphs);
		if(paragraphs == null || paragraphs.isEmpty()){
			getDTO.setMessage("Searched Successfully but No Paragraph with this word "+ word +" is Found.");
			getDTO.setStatus("200");
		}else{
			getDTO.setMessage("Searched Successfully & Found Required Paragraphs");
			getDTO.setStatus("200");;
		}
		return getDTO;
	
	}
}
