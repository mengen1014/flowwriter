package com.tce.storage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tce.storage.dao.FlowWriterDao;
import com.tce.storage.domain.FlowData;
import com.tce.storage.service.FlowWriterService;

@Service
public class FlowWriterServiceImpl implements FlowWriterService{

	
	@Autowired
	private FlowWriterDao dao;
	
	
	@Override
	public Boolean IsFlowWriter(FlowData data) {
		 try {
		   dao.save(data);
		   return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
