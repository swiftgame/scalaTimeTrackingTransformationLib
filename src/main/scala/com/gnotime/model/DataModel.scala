package com.gnotime.model

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