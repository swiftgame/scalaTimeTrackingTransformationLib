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
            case <gtt:project-list>{children @ _*}</gtt:project-list> => stripList(children(3))
          } 
         case _ => println("fails");
           
       

      }
   }
  
  def stripList(ls: Seq[Node]) =
  {
    println("stripList called");
  //  println(ls);
   ls match
   {
    // case   => println(myTitle)
     case xml.Elem("gtt", "project", _, _,_,Elem("title",_,_,_,_,test),_*) => println(test)//stripList(tail); //Hmm, need some changes here
//case <gtt:project><title>{theText}</title></gtt:project> => println(theText)    
// case head::tail => println(ls.tail.head);stripList(ls.tail.head)
     case _ => println("laatse");
      
      
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



