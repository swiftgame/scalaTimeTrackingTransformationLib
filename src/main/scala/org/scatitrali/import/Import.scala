package org.scatitrali.import

import scala.xml._
import org.scatitrali.model._


object read_xml {

  def clearScope(x: Node):Node = x match {
    case e:Elem => e.copy(scope=TopScope, child = e.child.map(clearScope))
    case o => o
  }

  // main purely for test
  def proc():List[Project] =
  { val gnotimeXmlPathname = scala.io.Source.fromFile("/home/koen/Dropbox/GnotimeScala/example1.xml").mkString
    val gnotimeXml = XML.loadString(gnotimeXmlPathname)

    // println(gnotimeXml \ "gtt:project-list" \ "@{file:/usr/share/gnotime/gtt.dtd}");
    transformXmlGnotimeToScalaModel(clearScope(gnotimeXml))
  }


  def transformXmlGnotimeToScalaModel(node: Node):List[Project] =
  {
    // println("   params node = \n{\n" + node + "\n}\n")
    // Elem (prefix: String, label: String, attributes: MetaData, scope: NamespaceBinding, child: Node*)
    node match
    {  //case Elem(asdf,blaat,test23,blaats,test,projectListAtTopLevel) => { println(asdf + blaat + test23 + blaats + test);transformProjectlist(test)  }
      //  case elem: Elem => println(")
      // case node \ "title" => { println(test);transformProjectlist(test)  }
      case xml.Elem("gtt", "gtt", _, _,_,test,_) => test match {
        case <gtt:project-list>{children @ _*}</gtt:project-list> =>  stripList(children)
      }
      case _ => Nil;



    }
  }

  def stripList(ls: Seq[Node]):List[Project] =
  {

      // println(scala.xml.Utility.trim(ls(0)));
      ls match
      { /*
         case <title>{e @ _*}</title> =>
         println(e)
         */
        // case   => println(myTitle)
        case Seq(xml.Elem("gtt", "project", _, _,_,test3 @ _ *), xs@_*) =>

          List(Project((test3 \\ "title").text,(test3 \\ "desc").text,(test3 \\ "id").text,
            test3.toList.flatMap{ m=>
              m match{
                case <gtt:task-list>{tasklist @ _ *}</gtt:task-list> => stripTimes(tasklist)
                case _ => Nil



              }})):::stripList(xs)


        case Seq(x, xs@_*) =>  stripList(xs)

        case Seq() => Nil

        //  print(test \\ "guid")//stripList(tail); //Hmm, need some changes here
        //case <gtt:project><title>{theText}</title></gtt:project> => println(theText)
        // case head::tail => println(ls.tail.head);stripList(ls.tail.head)


      }

  }

  def stripTimes(time_intervals: Seq[Node]):List[TaskList] =
  {

      time_intervals match {
        case Seq(xml.Elem("gtt", "task", _, _,_,test3 @ _ *),xs@_*) =>
          List(TaskList((test3 \\ "memo").text,(test3 \\ "guid").text,
            test3.toList.flatMap{
              x=>
                x match {
                  case <gtt:interval-list>{start_time @ _ *}</gtt:interval-list> => getTimes(start_time)
                  case _ => Nil


                }
            })):::stripTimes(xs)
        case Seq(x, xs@_*) =>  stripTimes(xs)

        case Seq() => Nil
      }



  }


  def getTimes(latest: Seq[Node]):List[TimeInterval]=
  {
  latest match
      {
    case Seq(Elem("gtt", "interval", _, _,_,st @ _ *),xs@_*) => List(TimeInterval((st \\ "start").text.toLong,(st \\ "stop").text.toLong)):::getTimes(xs)
        /* case <gtt:interval>{start_time}</gtt:interval> => println(start_time.child); start_time.map(x=> x match {
         case <start>{thetime}</start> => println(thetime)
         case <stop>{thetime}</stop> => println(thetime)
         case _ => Null
         }
         )*/

        // case x :: xs =>  x::getTimes(xs)
        //case Nil =>  getTimes(latest, i+1):::Nil

        case Seq(x, xs@_*) =>  getTimes(xs)

        case Seq() => Nil
      }


  }
}


