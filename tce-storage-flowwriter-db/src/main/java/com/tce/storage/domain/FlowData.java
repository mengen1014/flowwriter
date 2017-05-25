package com.tce.storage.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="流量记录参数" , description="FlowData")
public class FlowData {

	@Id
	private ObjectId id;
	@ApiModelProperty(value="上报节点ID" , required=true , position=0)
	private String NodeId;
	@ApiModelProperty(value="上报节点IP地址" , required=true , position=1)
	private String IPAddr;
	@ApiModelProperty(value="应用类型，如car，human等等" , required=true , position=2)
	private String Application;
	@ApiModelProperty(value="分析数据类型，0表示图片，1表示视频" , required=true , position=3)
	private Integer Type;
	@ApiModelProperty(value="流量报告产生时间（utc时间戳）" , required=true , position=4)
	private Integer TimeStamp;
	@ApiModelProperty(value="单位时间流浪增量，单位：字节" , required=true , position=5)
	private Integer Flow;

	

	public String getNodeId() {
		return NodeId;
	}

	public void setNodeId(String nodeId) {
		NodeId = nodeId;
	}

	public String getIPAddr() {
		return IPAddr;
	}

	public void setIPAddr(String iPAddr) {
		IPAddr = iPAddr;
	}

	public String getApplication() {
		return Application;
	}

	public void setApplication(String application) {
		Application = application;
	}

	public Integer getType() {
		return Type;
	}

	public void setType(Integer type) {
		Type = type;
	}

	public Integer getTimeStamp() {
		return TimeStamp;
	}

	public void setTimeStamp(Integer timeStamp) {
		TimeStamp = timeStamp;
	}

	public Integer getFlow() {
		return Flow;
	}

	public void setFlow(Integer flow) {
		Flow = flow;
	}

	public FlowData(String nodeId, String iPAddr, String application, Integer type, Integer timeStamp, Integer flow) {
		super();
		NodeId = nodeId;
		IPAddr = iPAddr;
		Application = application;
		Type = type;
		TimeStamp = timeStamp;
		Flow = flow;
	}

	public FlowData() {
		super();
	}

	@Override
	public String toString() {
		return "FlowData [NodeId=" + NodeId + ", IPAddr=" + IPAddr + ", Application=" + Application + ", Type=" + Type
				+ ", TimeStamp=" + TimeStamp + ", Flow=" + Flow + "]";
	}
	
	
}
