package org.scatitrali.test

import java.util.Date
import org.scatitrali.lib._

import org.scatitrali.read_xml

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
