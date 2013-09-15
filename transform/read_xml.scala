package com.scala.gnotime
import scala.xml._
import gnotimetoscala.model._


object read_xml {
   // main purely for test
  def main(args: Array[String])
  {  val myXML = <a><b>My Text</b></a>
myXML match {
    case <a><b>{theText}</b></a> => println(theText);
    case _ =>
}    
   
  val gnotimeXmlPathname = scala.io.Source.fromFile("/home/koen/Dropbox/GnotimeScala/gnotimetoscala/test/example1.xml").mkString
      val gnotimeXml = XML.loadString(gnotimeXmlPathname)
      
     // println(gnotimeXml \ "gtt:project-list" \ "@{file:/usr/share/gnotime/gtt.dtd}");
      transformXmlGnotimeToScalaModel(gnotimeXml) 
      


  }


   def transformXmlGnotimeToScalaModel(node: Node) =
   {  println("transformXmlGnotimeToScalaModel called")
     // println("   params node = \n{\n" + node + "\n}\n")
      // Elem (prefix: String, label: String, attributes: MetaData, scope: NamespaceBinding, child: Node*) 
      node match
      {  //case Elem(asdf,blaat,test23,blaats,test,projectListAtTopLevel) => { println(asdf + blaat + test23 + blaats + test);transformProjectlist(test)  }
       //  case elem: Elem => println(")
      // case node \ "title" => { println(test);transformProjectlist(test)  }
       case xml.Elem("gtt", "gtt", _, _,_,test,_*) => 
        { 
         // println("test= " + test)
          test.map{x=>
            println((x \\ "title").text)
           
           
         println( Project((x \\ "title").text,(x \\ "id").text))
         /* x match {
            case xml.Elem("gtt", _, _, _,_,blaat,_*) =>
          println(blaat)
        } */
          }
        
      }
         case _ => println("fails");
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



