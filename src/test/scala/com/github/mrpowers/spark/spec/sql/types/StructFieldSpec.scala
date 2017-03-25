package com.github.mrpowers.spark.spec.sql.types

import com.holdenkarau.spark.testing.DataFrameSuiteBase
import org.apache.spark.sql.types.{IntegerType, StructField}
import org.scalatest.FunSpec

class StructFieldSpec extends FunSpec with DataFrameSuiteBase {

  describe("#new") {

    it("can be instantiated with shorthand notation") {

      val s = StructField("num1", IntegerType, true)
      assert(s.getClass().getName() === "org.apache.spark.sql.types.StructField")

    }

    it("can be instantiated with explicit notation") {

      val s = new StructField("num1", IntegerType, true)
      assert(s.getClass().getName() === "org.apache.spark.sql.types.StructField")

    }

  }

  describe("#canEqual") {
    pending
  }

  describe("#dataType") {

    it("returns the dataType") {

      val s = StructField("num1", IntegerType, true)
      assert(s.dataType === IntegerType)

    }

  }

  describe("#equals") {

    it("returns true if two StructFields are equal") {

      val s1 = StructField("num1", IntegerType, true)
      val s2 = StructField("num1", IntegerType, true)
      assert(s1.equals(s2) === true)

    }

  }

  describe("#getComment") {
    pending
  }

  describe("#metadata") {
    pending
  }

  describe("#name") {
    pending
  }

  describe("#nullable") {
    pending
  }

  describe("#productArity") {
    pending
  }

  describe("#productElement") {
    pending
  }

  describe("#productIterator") {
    pending
  }

  describe("#productPrefix") {
    pending
  }

  describe("#toString") {

    it("converts a StructField to a string") {

      val s = StructField("num1", IntegerType, true)
      assert(s.toString() === "StructField(num1,IntegerType,true)")

    }

  }

  describe("#withComment") {

    it("adds a comment to the metadata") {

      val s = StructField("num1", IntegerType, true)
      val c = s.withComment("boo")
      assert(c.getComment() === Some("boo"))

    }

  }

}
