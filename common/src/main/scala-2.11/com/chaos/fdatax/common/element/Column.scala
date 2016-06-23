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

  abstract def asLong: Long
  abstract def asDouble: Double
  abstract def asString: String
  abstract def asDate: Date
  abstract def asBytes: Array[Byte]
  abstract def asBoolean: Boolean
  abstract def asBigDecimal: BigDecimal
  abstract def asBigInteger: BigInt

  override def toString: String = gson.toJson(this)
}