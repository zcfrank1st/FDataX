package com.chaos.fdatax.common.base

import org.apache.commons.lang3.builder.{EqualsBuilder, HashCodeBuilder, ToStringBuilder, ToStringStyle}

/**
  * Created by zcfrank1st on 6/23/16.
  */
trait BaseObject {
  override def hashCode(): Int = HashCodeBuilder.reflectionHashCode(this, false)

  override def equals(obj: scala.Any): Boolean = EqualsBuilder.reflectionEquals(this, obj, false)

  override def toString: String = ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE)
}
