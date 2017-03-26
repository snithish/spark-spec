package com.github.mrpowers.spark.spec.sql

import com.holdenkarau.spark.testing.DataFrameSuiteBase
import org.apache.spark.sql.Row
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.scalatest.FunSpec

class BugsSpec extends FunSpec with DataFrameSuiteBase {

  import spark.implicits._

  describe("Dataset#withColumnRenamed") {

    it("incorrectly renames a column in a case insensitive manner") {

      val sourceDF = Seq(1).toDF("foo")

      val actualDF = sourceDF.withColumnRenamed("FOO", "bar")

      val expectedDF = Seq(1).toDF("bar")

      assertDataFrameEquals(actualDF, expectedDF)

    }

  }

  describe("functions#locate") {

    it("does not use zero indexing") {

      val wordsDF = Seq(
        ("Spider-man"),
        ("Batman")
      ).toDF("word")

      val actualDF = wordsDF.withColumn("short_word", locate("man", col("word")))

      val expectedData = Seq(
        Row("Spider-man", 8),
        Row("Batman", 4)
      )

      val expectedSchema = List(
        StructField("word", StringType, true),
        StructField("short_word", IntegerType, true)
      )

      val expectedDF = spark.createDataFrame(
        spark.sparkContext.parallelize(expectedData),
        StructType(expectedSchema)
      )

      assertDataFrameEquals(actualDF, expectedDF)

    }

  }

}
