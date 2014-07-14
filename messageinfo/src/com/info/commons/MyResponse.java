package com.info.commons;

public class MyResponse {
  public static final int ERROR = 0;
  public static final int SUCCESS = 1;

  private int code = SUCCESS;
  private Object data;
  private String msg = "";
  
  public void setErrorCode() {
    code = this.ERROR;
  }
  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public static int getError() {
    return ERROR;
  }

  public static int getSuccess() {
    return SUCCESS;
  }

}
