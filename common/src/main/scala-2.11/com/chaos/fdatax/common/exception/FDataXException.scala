package com.chaos.fdatax.common.exception

import com.chaos.fdatax.common.spi.ErrorCode

/**
  * Created by zcfrank1st on 6/23/16.
  */
class FDataXException(val errorCode: ErrorCode, val errorMessage: String = "", val cause: Throwable = null) extends RuntimeException {
  def getErrorCode = errorCode
}

object FDataXException {
  def apply(errorCode: ErrorCode, message: String) = new FDataXException(errorCode = errorCode, errorMessage = message)
  def apply(errorCode: ErrorCode, message: String, cause: Throwable) = new FDataXException(errorCode = errorCode, errorMessage = message, cause = cause)
  def apply(errorCode: ErrorCode, cause: Throwable) = new FDataXException(errorCode = errorCode, cause = cause)
}
