package com.scala.gnotime
import scala.xml._
import gnotimetoscala.model._


object read_xml {
  
  def clearScope(x: Node):Node = x match {
    case e:Elem => e.copy(scope=TopScope, child = e.child.map(clearScope))
    case o => o
  }

  // main purely for test
  def main(args: Array[String])
  {  
   
    val gnotimeXmlPathname = scala.io.Source.fromFile("/home/koen/Dropbox/GnotimeScala/gnotimetoscala/test/example1.xml").mkString
    val gnotimeXml = XML.loadString(gnotimeXmlPathname)
      
    // println(gnotimeXml \ "gtt:project-list" \ "@{file:/usr/share/gnotime/gtt.dtd}");
    transformXmlGnotimeToScalaModel(clearScope(gnotimeXml)) 
      


  }


  def transformXmlGnotimeToScalaModel(node: Node) =
  {  println("transformXmlGnotimeToScalaModel called")
   // println("   params node = \n{\n" + node + "\n}\n")
   // Elem (prefix: String, label: String, attributes: MetaData, scope: NamespaceBinding, child: Node*) 
   node match
   {  //case Elem(asdf,blaat,test23,blaats,test,projectListAtTopLevel) => { println(asdf + blaat + test23 + blaats + test);transformProjectlist(test)  }
      //  case elem: Elem => println(")
      // case node \ "title" => { println(test);transformProjectlist(test)  }
      case xml.Elem("gtt", "gtt", _, _,_,test,_) => test match {
          case <gtt:project-list>{children @ _*}</gtt:project-list> =>  stripList(children(3))
        } 
      case _ => println("fails");
           
       

    }
  }
  
  def stripList(ls: Seq[Node]) =
  {
    println("stripList called");
    // println(scala.xml.Utility.trim(ls(0)));
    ls match
    { /*
       case <title>{e @ _*}</title> =>
       println(e)
       */
      // case   => println(myTitle)
      case xml.Elem("gtt", "project", _, _,_,test3 @ _ *) => {
          test3.map{ m=>
            m match{
              case <title>{test2}</title> =>  println(test2.text)
              case <id>{test2}</id> =>  println(test2.text)
              case <desc>{test2}</desc> =>  println(test2.text)
              case <gtt:task-list>{tasklist @ _ *}</gtt:task-list> => println(tasklist); stripTimes(tasklist(1))
                  
                  
                
          
              case _ => Null
          
          
            }}
        }
        
        //  print(test \\ "guid")//stripList(tail); //Hmm, need some changes here
//case <gtt:project><title>{theText}</title></gtt:project> => println(theText)    
// case head::tail => println(ls.tail.head);stripList(ls.tail.head)
      case _ => println("laatse");
      
      
    }
    
  }
  
  def stripTimes(time_intervals: Seq[Node])
  {
    println("stripTimes called");
    time_intervals match {
      case xml.Elem("gtt", "task", _, _,_,test3 @ _ *) => test3.map{ x=>
          x match {
            case <gtt:interval-list>{start_time @ _ *}</gtt:interval-list> => println(start_time(1)); getTimes(start_time(1) )
            case _ => Null           
      
      
          }
        }
    }
    
    
  }
  
  def getTimes(latest: Seq[Node])
  {
    println("time stripper");
    latest match
    {
       case xml.Elem("gtt", "interval", _, _,_,st @ _ *) => println(List(TimeInterval((st \\ "start").text.toLong,(st \\ "stop").text.toLong)));
      case <gtt:interval>{start_time}</gtt:interval> => println(start_time.child);/* start_time.map(x=> x match {
       case <start>{thetime}</start> => println(thetime)     
                case <stop>{thetime}</stop> => println(thetime) 
                case _ => Null
      }
    )*/
    case _ => Null
    
    
  }
  }
  
  /*
   def transformProjectlist(node: NodeSeq) =
   {  println("transformProjectlist called")
   println(node)
   node match
   {  case <gtt:project-list>{projectNodeSeq}</gtt:project-list> => 
   {   
			 
   println(transformProjectNodeSeq(projectNodeSeq))
   }
   case _ =>
   {  println("Error in xml2...")
   }
   }
   }

   def transformProjectNodeSeq(ns:NodeSeq) =
   { println("transformProjectNodeSeq")
   println(ns)
   ns match
   {  case xml.Elem("title", _, _, _,_,test,_*)  =>
   {  
   println("   project = " + test)
   //  project.label::transformProjectNodeSeq(restOfProjects)
   }
   case _ =>
        
   println("no match");
   }
   }
   
   */
}



