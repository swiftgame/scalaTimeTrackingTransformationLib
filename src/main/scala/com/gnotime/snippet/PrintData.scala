package com.gnotime
package snippet

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import com.gnotime.lib._
import Helpers._

import com.scala.gnotime.read_xml

class Printing {

  val test = read_xml.proc
  def data =
  {
   println(test)
    "#list *" #> test.map{
      x=>


    "#title *" #> x.title &
     "#projectdesc *" #> x.projectDesc &
      "#another *" #> x.tasks.map{ s =>
    "#memo *" #> s.memo &
    "#guid *" #> s.guid &
   "#times *" #> s.timeIntervals2.map { a=>
   "#start *" #>  a.start  &
  "#stop *" #> a.stop

   }
      }
     }
  }
  //};
}