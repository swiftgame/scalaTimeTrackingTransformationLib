/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.scala.gnotime
{
  import scala.xml._
  import gnotimetoscala.model._
  import com.scala.gnotime._

  object printDataModel {
  
    def main(args: Array[String] )
    {
      val test = read_xml.proc
      println("Title: " +test(0).title + ", Tasks: \n"+ test(0).tasks.map{
            b => "Memo: "+b.memo + ", Guid:" + b.guid +", Times: " + b.timeIntervals2.map {
              a => a.start + " - " + a.stop
            } + "\n"
          
        });
    }
  }

}
