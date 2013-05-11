# A Web-Kpi Server (work in progress)

This will (over time) hoefully become a simple web-app to show/visualize the KPIs
(Key Performance Indicators) of an organisation in one place. KPIs are different
from other metrics because they aggregate information into a single number which
directly [measures the business impact](http://www.cutter.com/content-and-analysis/journals-and-reports/cutter-it-journal/sample/itj0604c.html).

## How to make it work?

* Install [sbt](http://www.scala-sbt.org) (maybe using [macports](http://www.macports.org))
    * This is for the Mac. Don't know how to do it on Windows.
* Install [git](http://git-scm.com/downloads) (maybe using macports again)
* Clone the repo with `> git clone https://github.com/rolandtritsch/web-kpi`
* Start the KPI server with `> sbt run`
* Go to `http://localhost:9000`

... and you should be in business.

## Work in progress ...

* Right now this is mainly a test-bed for me to play around with [charting]
(http://blog.tritsch.org/2013/05/charting-some-kpis-how-hard-can-it-be.html)
