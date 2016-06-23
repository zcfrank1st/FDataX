package com.chaos.fdatax.common.spi

import com.chaos.fdatax.common.util.Configuration

/**
  * Created by zcfrank1st on 6/23/16.
  */
trait Hook {
  def getName: String
  def invoke(configuration: Configuration, msg: Map[String, Number]): Unit
}
