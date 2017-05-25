package com.tce.storage;

import java.util.HashMap;
import java.util.Map;
/**
 * 流量记录服务接口测试类
 * 
 *@author BJ-TCE 曹蒙恩
 *
 */
public class FlowWriterTest {

	
	public static void main(String[] args) {
		String requestUrl = "http://192.168.3.195:4260/api/stroage";
		Map<String, Object> requestParamsMap = new HashMap<String, Object>();
		requestParamsMap.put("NodeId", "001");
		requestParamsMap.put("IPAddr", "192.168.3.158");
		requestParamsMap.put("Application", "car");
		requestParamsMap.put("TimeStamp", "1890498234");
		requestParamsMap.put("Type", "1");
		requestParamsMap.put("Flow", "24");
		String httpPost = HttpPostUtil.HttpPost(requestUrl, requestParamsMap);
		System.out.println(httpPost);
	}
}
