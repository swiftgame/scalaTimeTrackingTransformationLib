package org.scatitrali.model
{

object Types
{  type POSIXtime = Long // POSIXtime: see http://en.wikipedia.org/wiki/Unix_time
}

package standard
{

import Types._

case class Project(  title:String, // in gnotime.xml: <title>
                     projectDesc:String,
                     id:String, // in gnotime.xml: <id>
                     tasks:List[TaskList] // in gnotime.xml: <project-list>

                  )
{
}

case class TaskList(  memo:String, // in gnotime.xml: <id>
                      guid:String, // in gnotime.xml: <title>
                      timeIntervals2:List[TimeInterval] // in gnotime.xml: <task-list> (not certain yet, better verify) list of time intervals on which this project was active tracked on TOP level (so excluding time intervals occupied by the subprojects).
                   )
{
}

case class TimeInterval(start:POSIXtime, stop:POSIXtime)
{
}
}
/** BS: if it is possible to fit a piece of information into the general scalatri datastructures by extending the latter, this is the way it must be done (instead of defining a gnotime-specific datastructure).
  */
package gnotime
{
object Types
{  type POSIXtime = Long // POSIXtime: see http://en.wikipedia.org/wiki/Unix_time
}

import Types._

case class Project(  title:String, // in gnotime.xml: <title>
                     projectDesc:String,
                     id:String, // in gnotime.xml: <id>
                     tasks:List[TaskList] // in gnotime.xml: <project-list>

                  )
{
}

case class TaskList(  memo:String, // in gnotime.xml: <id>
                      guid:String, // in gnotime.xml: <title>
                      timeIntervals2:List[TimeInterval] // in gnotime.xml: <task-list> (not certain yet, better verify) list of time intervals on which this project was active tracked on TOP level (so excluding time intervals occupied by the subprojects).
                   )
{
}

case class TimeInterval(start:POSIXtime, stop:POSIXtime)
{
}
}
