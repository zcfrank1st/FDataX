package com.chaos.fdatax.common.util

import com.chaos.fdatax.common.exception.{CONFIG_ERROR, FDataXException}

/**
  * Created by zcfrank1st on 6/23/16.
  */
object ListUtil {
  def checkIfValueDuplicate (list: List[String], caseSensitive: Boolean) = {
    if (null == list || list.isEmpty) {
      throw new FDataXException(CONFIG_ERROR, "您提供的作业配置有误，List不能为空.")
    }

    // TODO:  
  }
}
