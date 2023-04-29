import ujson._
import scala.io.Source
import scala.collection.immutable.ListMap

import java.io.File
import java.io.PrintWriter

/*

Загрузите файл с географическими данными различных стран 
(https://raw.githubusercontent.com/mledoze/countries/master/countries.json) 

Среди стран выберите 10 стран Африки с наибольшей площадью 
Запишите данные о выбранных странах в виде JSON-массива объектов следующей структуры: 
  [{ 
      “name”:    <Официальное название страны на английском языке, строка>
    , “capital”: <Название столицы, строка> (если столиц перечисленно несколько, выберите первую)
    , “area”:    <Площадь страны в квадратных километрах, число>
  }] 
  
Обеспечьте проект инструкциями для сборки JAR-файла, принимающего на вход имя выходного файла и осуществляющего запись в него

Ivan Serdyukov

*/
class CInfo( val name: String, val capital: String, val area: Double) {}

object Main extends App {

  val input = Source.fromURL("https://raw.githubusercontent.com/mledoze/countries/master/countries.json").mkString
  val data = ujson.read( input )
  // println( "Num cntry : " + data.arr.length ) // Num cntry : 250

  val mm = collection.mutable.Map[String,CInfo]()

  data.arr.foreach( x => 
    if (x("region").str == "Africa") {
      mm += x( "name" )("common").str -> new CInfo( x( "name" )("common").str , x("capital")(0).str , x("area").num )
    }
  )
  // println( "Num Afirca counties: " + mm.size ) //Num Afirca counties: 59

  val lm = ListMap( mm.toSeq.sortWith(_._2.area > _._2.area ):_* )
  
  var ss = "["
  lm.take(10).zipWithIndex.foreach{ case(x,i) => 
    if ( i < 9 ) {
           ss += s""" {"name": "${x._1}" , "capital": "${x._2.capital}" , "area": "${x._2.area}"}, """
    } else ss += s""" {"name": "${x._1}" , "capital": "${x._2.capital}" , "area": "${x._2.area}"}  """
  }
  ss += "]"

  println(ss)

  if (args.length > 0) {
    val outputFile = args(0)
    val printWriter = new PrintWriter(new File(outputFile))
    printWriter.print( ujson.write( ujson.read( ss ),indent = 4) )
    printWriter.flush
    printWriter.close()
  } 

}
