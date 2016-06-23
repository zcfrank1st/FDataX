package com.chaos.fdatax.common.exception

import com.chaos.fdatax.common.spi.ErrorCode

/**
  * Created by zcfrank1st on 6/23/16.
  */
case object CONFIG_ERROR extends CommonErrorCode("Common-00", "您提供的配置文件存在错误信息，请检查您的作业配置 .")
case object CONVERT_NOT_SUPPORT extends CommonErrorCode("Common-01", "同步数据出现业务脏数据情况，数据类型转换错误 .")
case object CONVERT_OVER_FLOW extends CommonErrorCode("Common-02", "同步数据出现业务脏数据情况，数据类型转换溢出 .")
case object RETRY_FAIL extends CommonErrorCode("Common-10", "方法调用多次仍旧失败 .")
case object RUNTIME_ERROR extends CommonErrorCode("Common-11", "运行时内部调用错误 .")
case object HOOK_INTERNAL_ERROR extends CommonErrorCode("Common-12", "Hook运行错误 .")
case object SHUT_DOWN_TASK extends CommonErrorCode("Common-20", "Task收到了shutdown指令，为failover做准备")
case object WAIT_TIME_EXCEED extends CommonErrorCode("Common-21", "等待时间超出范围")
case object TASK_HUNG_EXPIRED extends CommonErrorCode("Common-22", "任务hung住，Expired")

sealed class CommonErrorCode (code: String, description: String) extends ErrorCode {
  override def getCode: String = code
  override def getDescription: String = description
}
