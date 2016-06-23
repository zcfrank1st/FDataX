package com.chaos.fdatax.common.element
import java.util.Date

import com.chaos.fdatax.common.element.ColumnType.ColumnType

/**
  * Created by zcfrank1st on 6/23/16.
  */
// TODO:  
class StringColumn(rawData: String, typeValue: ColumnType, byteSize: Int) extends Column(rawData, typeValue, byteSize) {
  def this() = {
    this(null, ColumnType.STRING, 0)
  }

  def this(rawData: String) = {
    this(rawData, ColumnType.STRING, rawData.length)
  }

  def validateDoubleSpecific(data: String) {
    if ("NaN" == data || "Infinity" == data || "-Infinity" == data) {
      throw new RuntimeException
    }
  }

  override def asLong: Long = ???

  override def asBigInteger: Option[BigInt] = {
    validateDoubleSpecific(rawData)
    Option(this.asBigDecimal.toBigInt())
  }

  override def asString: Option[String] = Option(rawData)

  override def asBoolean: Boolean = ???

  override def asBytes: Array[Byte] = ???

  override def asDouble: Double = ???

  override def asDate: Date = ???

  override def asBigDecimal: BigDecimal = ???
}
