package com.koitt.model;

import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Board, Board>{

	@Override
	public Board process(Board item) throws Exception {
		
		if(item.getAttachment() == null) {
			item.setAttachment("null");
		
		} else {
			System.out.println(item);
		}
		return item;
	}
}
