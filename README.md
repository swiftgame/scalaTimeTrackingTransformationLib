GnotimeScala
============

Library to transform time tracking information, and import it from and export it to existing tracking/planning/scheduling tools.
For example, it can be used to build transformations to connect different tracking/planning/scheduling tools to each other.
The first will be exporting Gnotime (a time tracking tool) to Taskjuggler (a sophisticated planning tool). This will allow a user
to track his time in gnotime, while a planner can than easily import the gnotime information into taskjuggler, and recalculate
the (progress of the) project plan.

Note that transformations are not always simply a matter of a (semantic preserving) transformation from one format to another.
Some tools are more expressive than others. For example, the granularity of durations in Taskjuggeler is by default an hour,
(so, a duration is expressed in n*hour, where n is an integer), while that of Taskjuggler is a second. The transformation
from gnotime to taskjuggler can therefore not preserve the semantics, and some (partly adhoc) decisions have to be made 
what and how information is thrown a way. That is where this library contians ready made functions.



import into netbeans or something like that.

Main class: printDataModel.scala 
