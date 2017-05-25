package com.tce.storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class HttpPostUtil {
	
	public static String HttpPost(String requestUrl ,Map<String, Object> requestParamsMap){

		PrintWriter printWriter = null;
		BufferedReader bufferedReader = null;
		// BufferedReader bufferedReader = null;
		StringBuffer responseResult = new StringBuffer();
		HttpURLConnection httpURLConnection = null;
		// 组织请求参数

		String params = com.alibaba.fastjson.JSONObject.parseObject(JSON.toJSONString(requestParamsMap)).toString();
		try {
			URL realUrl = new URL(requestUrl);
			// 打开和URL之间的连接
			httpURLConnection = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setRequestProperty("accept", "*/*");
			httpURLConnection.setRequestProperty("connection", "Keep-Alive");
			httpURLConnection.setRequestProperty("Content-Length", String
					.valueOf(params.length()));
			//          application/x-javascript text/xml->xml数据 
			//			application/x-javascript->json对象 
			//			application/x-www-form-urlencoded->表单数据 
			//			application/json;charset=utf-8 -> json数据  
			httpURLConnection.setRequestProperty("Content-Type",  
					"application/json;charset=utf-8"); 
			httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
			httpURLConnection.setRequestProperty("contentType", "utf-8");
			// 发送POST请求必须设置如下两行
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			printWriter = new PrintWriter(httpURLConnection.getOutputStream());
			// 发送请求参数
			System.out.println("请求参数==>"+params);
			printWriter.write(params);
			// flush输出流的缓冲
			printWriter.flush();
			// 根据ResponseCode判断连接是否成功
			int responseCode = httpURLConnection.getResponseCode();
			if (responseCode != 200) {
				System.out.println(" Error===" + responseCode);
			} else {
				System.out.println("Post Success!");
			}
			// 定义BufferedReader输入流来读取URL的ResponseData
			bufferedReader = new BufferedReader(new InputStreamReader(
					httpURLConnection.getInputStream()));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				responseResult.append(line);
			}
		} catch (Exception e) {
			System.out.println("send post request error!" + e);
		} finally {
			httpURLConnection.disconnect();
			try {
				if (printWriter != null) {
					printWriter.close();
				}
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}
		return responseResult.toString();
	}
}
