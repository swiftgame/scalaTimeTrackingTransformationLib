ScalaTimeTrackingTranformationLib = scatitrali
============

Library to manipulate time tracking information in Scala, and import it from and export it to existing tracking/planning/scheduling tools.
Primarily, it is intended to build transformations to connect different tracking/planning/scheduling tools to each other.
The first will be exporting Gnotime (a time tracking tool) to Taskjuggler (a sophisticated planning tool). This will allow a person in the role of worker
to track his time in gnotime, while a person in the role of planner can easily import the gnotime information into taskjuggler, and update the (progress of the) project plan.

Note that transformations are not always simply a matter of a (semantic preserving) transformation from one format to another. Some tracking/planning tools are more expressive than others. For example, the granularity of durations in Taskjuggeler is by default an hour,
(so, a duration is expressed in n*hour, where n is an integer), while that of Taskjuggler is a second. The transformation from Gnotime to Taskjuggler can therefore not preserve the semantics, and some (partly adhoc) decisions have to be made  what and how information is thrown away. For this purpose, this library contains ready made functions.

Anyone is invited to contribute to extend the library with new import and export modules to and from time tracking and planning tools.
