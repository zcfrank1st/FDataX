package com.chaos.fdatax.common.exception

import java.io.{PrintWriter, StringWriter}

/**
  * Created by zcfrank1st on 6/23/16.
  */
object ExceptionTracker {
  val STRING_BUFFER = 1024

  def trace(ex: Throwable) = {
    val sw = new StringWriter(STRING_BUFFER)
    val pw = new PrintWriter(sw)
    ex.printStackTrace(pw)
    sw.toString
  }
}
