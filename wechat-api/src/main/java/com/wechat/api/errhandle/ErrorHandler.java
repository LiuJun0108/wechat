package com.wechat.api.errhandle;

import com.wechat.api.result.ErrorResult;

public interface ErrorHandler {
	public void handle(ErrorResult error);
}
