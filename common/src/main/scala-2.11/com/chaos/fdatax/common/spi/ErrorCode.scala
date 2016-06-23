package com.chaos.fdatax.common.spi

/**
  * Created by zcfrank1st on 6/23/16.
  */
trait ErrorCode {
  def getCode: String
  def getDescription: String
  def toString: String
}
