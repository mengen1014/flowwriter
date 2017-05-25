package com.tce.storage.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.tce.storage.domain.FlowData;

public interface FlowWriterDao extends MongoRepository<FlowData, ObjectId>{

}
