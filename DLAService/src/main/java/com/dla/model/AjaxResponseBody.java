package com.dla.model;

import java.util.List;
import java.util.Map;

public class AjaxResponseBody {

    String msg;
    List<User> result;
    Map<String, String> resultMap ;

  

	public Map<String, String> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, String> resultMap) {
		this.resultMap = resultMap;
	}

	public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<User> getResult() {
        return result;
    }

    public void setResult(List<User> result) {
        this.result = result;
    }

}
