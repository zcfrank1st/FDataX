package com.chaos.fdatax.common.util

import java.net.InetAddress

import com.google.common.base.CharMatcher
import org.slf4j.LoggerFactory

import scala.sys.process._
/**
  * Created by zcfrank1st on 6/23/16.
  */
object HostUtil {
  val log = LoggerFactory.getLogger(this.getClass)

  val addr = InetAddress.getLocalHost
  var ip = addr.getHostAddress
  var hostname = addr.getHostName

  if (ip == "127.0.0.1" || ip == "::1" || ip == "UNKNOWN") {
    ip = "hostname -i".!!
    hostname = CharMatcher.BREAKING_WHITESPACE.trimFrom("hostname".!!)
  }

  log.info("IP {} HOSTNAME {}", ip, hostname)
}
