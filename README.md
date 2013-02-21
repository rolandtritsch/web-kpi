# Know Better Instantly (KBI :))

A simple web-app to show/visualize the KPIs (Key Performance Indicators) of an
organisation in one place. KPIs are different from other metrics because they
aggregate information into a single number which directly [measures the business
impact](http://www.cutter.com/content-and-analysis/journals-and-reports/cutter-it-journal/sample/itj0604c.html).

## How to make it work?

* Install [sbt](http://www.scala-sbt.org) (maybe using [macports](http://www.macports.org))
    * This is for the Mac. Don't know how to do it on Windows.
* Install [git](http://git-scm.com/downloads) (maybe using macports again)
* Clone the repo with `> git clone https://github.com/rolandtritsch/web-kpi`
* Start the KPI server with `> sbt run`
* Go to `http://localhost:9000`

... and you should be in business.

## Personnas and Use Cases

### The CEO View - Michelle

Michelle is technology savy and knows how to use the browser. She knows that
the Tech organisation is managed based on KPIs and occassionaly wants to understand,
how Tech is doing overall (e.g. what are the initiatives that are underway and how
are they doing against the agreed targets). Sometimes she also looks up the KPI server
to understand how a specific initiative or group is doing (maybe because the success
of a larger initiative depends in getting the Tech piece done first). The KPI server
is a bookmark on her browser (Safari or Google Chrome) and the bookmark is also synced
to her iPhone, which she uses frequently to lookup the KPI server.

When she gets to the server she first sees all KPIs in a table view (the KPI listing
page (KLP)). The view is sorted by KPI name and the columns are ...

* Health Indicator (green/yellow/red/unknown)
* Team/Initiative Name
* Name of the KPI
* Current Value
* Last Value
* Target
* Last Updated (time stamp of the latest KPI value)

She can scroll that screen up and down (but the top row/column names are fixed).

There is filtering available on the Health Status and the Team/Initiative Name.

She then goes on to filter the table rows based on the health status. She does that
by clicking on the column name and will get a dialog that is similar to the Google Docs
Spreadsheat filtering feature. The values that are available for the health status
are Green, Yellow, Red and Unknown. She selects Red and Unknown and the table view
shrinks to just display the filtered rows. The column name turns red to indicate that
filtering is active.

She now picks a KPI by clicking on the KPI name. The next page displays detailed information
about the selected KPI (this is the KPI detail page (KDP)). At the top of the page the
KPI header is displayed (health, name, team/initiative, target, deadline and a detailed
description of the KPI (including what company priority this KPI is supporting).

The lower part of the screen shows a table view which displays all of the existing KPI values.
The table has two columns: Timestamp and value. Here she can see at a glance how the KPI has
improved/deveoped over time. The part if the screen that shows the KPI header and the column
headers in the table are fixed and scrolling down will just make the rows in the table scroll.
At the buttom of the screen there are two tabs that actually allow to toggle between the table
view and the graph view.

She then hits the back buttom of the browser to get back to the previous page (the KPI
listing page). She clicks on the red column name (the health status) and makes sure that
all filters are disabled and that all rows are displayed and moves on to take a look at
certain initiatives, means she uses the filtering on the team/initiative column to find
the KPIs that are of interest and looks at them one by one using the KPI detail page.

After 2 minutes she knows that Tech and the main initiatives are in good shape and moves
on to do something else.

### The KPI plugin Developer View - Sarah

Sarah is a savy Java engineer who is 6 month with Gilt. She really likes Gilt. She is
learning Scala and she just joined a new team/initiative (called Galactica) that has
commited itself to automate the HW deployment process. The expected business impact is
that engineers will not need to contact Infrastructure Engineering anymore to get something
done. They can do it themselves, thus reducing the number of JIRA tickets raised.

To get the related KPI into the KPI server she initially uses the default plugin. The
default plugin is file-based and allows to manually update a KPI. The plugin uses a
directory strcuture with yaml-files ...

`
email_deliverability --- kpi.yaml // KPI information (will be loaded into KPI.scala)
                     |
                     |
                     --- values.yaml // timestamp-value pairs (will be loaded into KPIValues.scala)
tickets_raised --------- kpi.yaml
                     |
                     |
                     --- values.yaml
`

Soon she gets tired to maintain and update the KPI values manually and decides to implement
a plugin for the KPI that will look up the values of the KPI automatically. She decides to
implement the plugin using the SOAP-based JIRA-API. It takes her half a day to implement
and test the plugin and 10 minutes to deploy the implementation to production.

## Solution Architecture

* Scala/Play based
* Not using any Gilt specific features and/or infrastructure, because we do not want to rule
out to open source this
* Initailly no local storage besides the file system, but we could see that sooner or later
the data is stored in a database

## Proposed prototype KPIs

* Number of tickets created per month for Infrastructure Engineering
* Email Deliverability
* Stores platform
