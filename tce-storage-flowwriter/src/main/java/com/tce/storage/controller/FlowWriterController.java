package com.tce.storage.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.tce.storage.FlowWriterApi;
import com.tce.storage.domain.FlowData;
import com.tce.storage.service.FlowWriterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * swagger2使用说明：
         @Api：用在类上，说明该类的作用
         @ApiOperation：用在方法上，说明方法的作用
         @ApiImplicitParams：用在方法上包含一组参数说明
         @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
            paramType：参数放在哪个地方
                 header-->请求参数的获取：@RequestHeader
                 query-->请求参数的获取：@RequestParam
                 path（用于restful接口）-->请求参数的获取：@PathVariable
                 body（不常用）
                 form（不常用）
             name：参数名
             dataType：参数类型
             required：参数是否必须传
             value：参数的意思
             defaultValue：参数的默认值
         @ApiResponses：用于表示一组响应
         @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
             code：数字，例如400
             message：信息，例如"请求参数没填好"
             response：抛出异常的类
         @ApiModel：描述一个Model的信息（这种一般用在post创建的时候，使用@RequestBody这样的场景，请求参数无法使用@ApiImplicitParam注解进行描述的时候）
            @ApiModelProperty：描述一个model的属性

 *
 */
@RestController
@RequestMapping(value="/api/stroage")
@Api(value = "FlowWriterController", description = "流量记录服务通信协议")
public class FlowWriterController implements FlowWriterApi{

	@Autowired
	private FlowWriterService service;

	@ApiOperation(value="流量记录服务",notes="流量记录服务将流量增量信息写入数据库")
	@ApiImplicitParam(name="StrData",value="流量记录信息",required=true,dataType="FlowData")
	@RequestMapping(value="",method=RequestMethod.POST)
	@ApiResponses(value = {  
			@ApiResponse(code = 200, message = "请求已完成"),
			@ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
			@ApiResponse(code = 401, message = "未授权客户机访问数据"),
			@ApiResponse(code = 403, message = "被禁止"),
			@ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
			@ApiResponse(code = 500, message = "服务器不能完成请求")}
			) 
	public Boolean FlowWriter(@RequestBody String StrData){
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(format.format(cal.getTime()) +"    record ==>>" +StrData);
		FlowData data = null;
		try {
			data = JSON.parseObject(StrData, FlowData.class);
		} catch (Exception e) {
			return false;
		}
		return service.IsFlowWriter(data);
	}
}
