package gnotimetoscala.model
{
object Types
{  type POSIXtime = Long // POSIXtime: see http://en.wikipedia.org/wiki/Unix_time
}

import Types._

case class Project(  title:String, // in gnotime.xml: <title>
                     id:String//, // in gnotime.xml: <id>
                     //subprojects:List[Project], // in gnotime.xml: <project-list>
                   //  timeIntervals:List[TimeInterval] // in gnotime.xml: <task-list> (not certain yet, better verify) list of time intervals on which this project was active tracked on TOP level (so excluding time intervals occupied by the subprojects).
                  )
{
}

case class TimeInterval(start:POSIXtime, stop:POSIXtime)
{
}

}
