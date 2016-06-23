package com.chaos.fdatax.common.element

import java.util.Date

import com.chaos.fdatax.common.element.ColumnType.ColumnType
import com.chaos.fdatax.common.util.GsonUtil

/**
  * Created by zcfrank1st on 6/23/16.
  */
object ColumnType extends Enumeration {
  type ColumnType = Value
  val BAD, NULL, INT, LONG, DOUBLE, STRING, BOOL, DATE, BYTES = Value
}

abstract class Column(rawData: AnyRef, typeValue: ColumnType, byteSize: Int) extends GsonUtil {
  def getRawData: Any = this.rawData

  def getType: ColumnType = this.typeValue

  def getByteSize: Int = this.byteSize

  def asLong: Option[Long]
  def asDouble: Option[Double]
  def asString: Option[String]
  def asDate: Option[Date]
  def asBytes: Option[Array[Byte]]
  def asBoolean: Option[Boolean]
  def asBigDecimal: Option[BigDecimal]
  def asBigInteger: Option[BigInt]

  override def toString: String = gson.toJson(this)
}