package com.tce.storage.error;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {


	
	 private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	    /**
	     * 系统异常处理，比如：404,500
	     * @param req
	     * @param resp
	     * @param e
	     * @return
	     * @throws Exception
	     */
	    @ExceptionHandler(value = Exception.class)
	    @ResponseBody
	    public ErrorInfo defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
	        logger.error("", e);
	        ErrorInfo r = new ErrorInfo();
	        r.setMessage(e.getMessage());
	        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
	             r.setCode(404);
	        } else {
	             r.setCode(500);
	        }
	        r.setStatus(false);
	        return r;
	    }

}
