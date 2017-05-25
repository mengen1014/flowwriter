package com.tce.storage;

public interface FlowWriterApi {
	/**
	 * 
	 * 
	 * 流量记录服务是分析服务将原始数据流增量信息推送至kafka 消息服务以后，将消息以json的数据格式，记录在数据库的这一过程。
	 * 
	 *	TCE.Report.Flow
	 *
	 *	Request			NodeId			string		上报节点ID
	 *					IPAddr			string		上报节点IP地址
	 *					Application		string		应用类型，如car，human等等
	 *					Type			uint8		分析数据类型，0表示图片，1表示视频
	 *					TimeStamp		uint64		流量报告产生时间（utc时间戳）
	 *					Flow			uint64		单位时间流浪增量，单位：字节
	 *
	 *	Response			
	 *
	 * e.g
	 * 
	 *	{
	 *		"IPAddr": "192.168.3.158",
	 *		"Type": "1",
	 *		"NodeId": "001",
	 *		"Application": "car",
	 *		"TimeStamp": "1890498234",
	 *		"Flow": "24"
	 *	}
	 * 
	 * 
	 * 
	 * 
	 */
	public Boolean FlowWriter(String StrData);
}
