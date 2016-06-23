package com.chaos.fdatax.common.util

import java.text.DecimalFormat

import org.apache.commons.lang3.{StringUtils, Validate}

import scala.collection.mutable

/**
  * Created by zcfrank1st on 6/23/16.
  */
object StrUtil {
  val KB_IN_BYTES = 1024
  val MB_IN_BYTES = 1024 * KB_IN_BYTES
  val GB_IN_BYTES = 1024 * MB_IN_BYTES
  val TB_IN_BYTES = 1024 * GB_IN_BYTES

  val df = new DecimalFormat("0.00")

  val VARIABLE_PATTERN = """(\$)\{?(\w+)\}?""".r
  var SYSTEM_ENCODING = System.getProperty("file.encoding")

  if (SYSTEM_ENCODING == null) {
    SYSTEM_ENCODING = "UTF-8"
  }

  def stringify(byteNumber: Long) = {
    if (byteNumber / TB_IN_BYTES > 0) {
      df.format(byteNumber.toDouble / TB_IN_BYTES.toDouble) + "TB"
    } else if (byteNumber / GB_IN_BYTES > 0) {
      df.format(byteNumber.toDouble / GB_IN_BYTES.toDouble) + "GB"
    } else if (byteNumber / MB_IN_BYTES > 0) {
      df.format(byteNumber.toDouble / MB_IN_BYTES.toDouble) + "MB"
    } else if (byteNumber / KB_IN_BYTES > 0) {
      df.format(byteNumber.toDouble / KB_IN_BYTES.toDouble) + "KB"
    } else {
      String.valueOf(byteNumber) + "B"
    }
  }

  def replaceVariable(param: String) = {
    val mapping = mutable.HashMap[String, String]()

    param match {
      case VARIABLE_PATTERN(_, variable) =>
        var value = System.getProperty(variable)
        if (StringUtils.isBlank(value)) {
          value = param
        }
        mapping + (param -> value)
    }

    var retString = param
    mapping.keySet.foreach {e =>
      retString = retString.replace(e, mapping.get(e).get)
    }

    retString
  }

  def compressMiddle(s: String, headLength: Int, tailLength: Int): String = {
    Validate.notNull(s, "Input string must not be null")
    Validate.isTrue(headLength > 0, "Head length must be larger than 0")
    Validate.isTrue(tailLength > 0, "Tail length must be larger than 0")

    if (headLength + tailLength >= s.length) {
      return s
    }

    s.substring(0, headLength) + "..." + s.substring(s.length - tailLength)
  }
}
