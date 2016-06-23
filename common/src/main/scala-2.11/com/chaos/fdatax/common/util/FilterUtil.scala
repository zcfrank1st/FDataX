package com.chaos.fdatax.common.util

/**
  * Created by zcfrank1st on 6/23/16.
  */
object FilterUtil {
  def filterByRegular(allStrs: List[String], regular: String): List[String] = {
    var matchedValues: List[String] = Nil

    val newRegular = regular.replace(".*", "*").replace("*", ".*")
    val pattern = newRegular.r

    allStrs.foreach {
      case pattern(e) =>
        if (!matchedValues.contains(e))
          matchedValues = e :: matchedValues
    }

    matchedValues
  }

  def filterByRegulars (allStrs: List[String], regulars: List[String]): List[String] = {
    var matchedValues: List[String] = Nil
    var tempMatched: List[String] = Nil

    regulars.foreach(e => {
      tempMatched = filterByRegular(allStrs, e)

      if (null != tempMatched && tempMatched.nonEmpty) {
        tempMatched.foreach(e => {
          if (!matchedValues.contains(e)) {
            matchedValues = e :: matchedValues
          }
        })
      }
    })

    matchedValues
  }
}
