package com.developers.dmaker.exception;

import lombok.Getter;

@Getter
public class DMakeException extends RuntimeException{
  private DMakeErrorCode dMakeErrorCode;
  private String detailMessage;

  public DMakeException(DMakeErrorCode errorCode){
    super(errorCode.getMessage());
    this.dMakeErrorCode = errorCode;
    this.detailMessage = errorCode.getMessage();
  }

  public DMakeException(DMakeErrorCode errorCode, String detailMessage){
    super(detailMessage);
    this.dMakeErrorCode = errorCode;
    this.detailMessage = detailMessage;
  }
}
