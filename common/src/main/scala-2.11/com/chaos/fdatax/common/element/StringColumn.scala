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

  override def asLong: Option[Long] = ???

  override def asBigInteger: Option[BigInt] = {
    validateDoubleSpecific(rawData)
    Option(this.asBigDecimal.get.toBigInt())
  }

  override def asString: Option[String] = Option(rawData)

  override def asBoolean: Option[Boolean] = ???

  override def asBytes: Option[Array[Byte]] = ???

  override def asDouble: Option[Double] = ???

  override def asDate: Option[Date] = ???

  override def asBigDecimal: Option[BigDecimal] = ???
}
