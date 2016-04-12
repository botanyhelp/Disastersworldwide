### Disastersworldwide Android App README

Code for Disastersworldwide android application.

Interface in English, German, Chinese, Czech, Dutch, French, Italian, Japanese, Korean, Polish, Russian and Spanish

Disasters wordwide from 1900-2008
A comprehensive listing of of over 17,000 disasters, natural and otherwise, from around the globe.

Since 1988 the WHO Collaborating Centre for Research on the Epidemiology of Disasters (CRED) has been maintaining an Emergency Events Database EM-DAT. EM-DAT was created with the initial support of the WHO and the Belgian Government.

The main objective of the database is to serve the purposes of humanitarian action at national and international levels. It is an initiative aimed to rationalise decision making for disaster preparedness, as well as providing an objective base for vulnerability assessment and priority setting. For example, it allows on to decide whether floods in a given country are more significant in terms of its human impact than earthquakes or whether a country is more vulnerable than another for computing resources is.

EM-DAT contains essential core data on the occurrence and effects of over 16,000 mass disasters in the world from 1900 to present. The database is compiled from various sources, including UN agencies, non-governmental organisations, insurance companies, research institutes and press agencies.

This is only public domain natural disaster database around (two other global sources are private: Sigma from Swiss Re and NatCat from Munich Re).

The EM-DAT database is protected by the law of 30 June 1994 on copyright and the law of 31 August 1998 on the legal protection of databases.

EM-DAT was created in 1988 at the Université Catholique de Louvain by researchers at the Centre de Recherche sur l’Epidemiologie des Desastres – Centre for Research on the Epidemiology of Disasters (CRED). The database was set up with the support of the WHO and the Belgian government. Since 1999, CRED has received support from the Office of Foreign Disaster Assistance (OFDA) of the US Agency for International Development (USAID). The Université Catholique de Louvain holds the copyright for the database.

The EM-DAT database has been made available for unrestricted access free of charge by UCL so that anyone with a query can obtain information.

EM-DAT: The OFDA/CRED International Disaster Database – www.emdat.be – Université Catholique de Louvain – Brussels – Belgium.


Inside of the application is an SQL database that was created with this schema like this:
```{sql}
CREATE TABLE emdata (Startmonthday integer default null, Startyear integer default null, End integer default null, Country text default null, Location text default null, Type text default null, Sub_Type text default null, Name text default null, Killed integer default null, Cost integer default null, Affected text default null, Id text default null);
CREATE INDEX idxAffected ON emdata(Affected);
CREATE INDEX idxCost ON emdata(Cost);
CREATE INDEX idxCountry ON emdata(Country);
CREATE INDEX idxEnd ON emdata(End);
CREATE INDEX idxId ON emdata(Id);
CREATE INDEX idxKilled ON emdata(Killed);
CREATE INDEX idxLocation ON emdata(Location);
CREATE INDEX idxName ON emdata(Name);
CREATE INDEX idxStartmonthday ON emdata(Startmonthday);
CREATE INDEX idxStartyear ON emdata(Startyear);
CREATE INDEX idxSub_Type ON emdata(Sub_Type);
CREATE INDEX idxType ON emdata(Type);
```
The application queries that database to produce results.  Queries like this one, run in sqlite3 on linux, show some bad times in Switzerland:
```
sqlite> SELECT * FROM emdata WHERE Country="Switzerland" AND Killed > 50;
7|2003|72003|Switzerland||Extreme temperature|Heat wave||1039|0|280|2003-0391
3008|1965|30081965|Switzerland|Saas-Fee|Mass movement wet|Avalanche||90|0||1965-0051
2|1951|21951|Switzerland||Mass movement wet|Avalanche||92|0|20|1951-0029
```
The data, as shown above, is in English.  The interface of the application is available in several languages.  There is not much to this after proper translation is achieved.  Some of these folders in the application hold the keys to more languages:
```
ls res/
drawable-hdpi/       menu/                values-it/           values-sw600dp/
drawable-ldpi/       values/              values-ja/           values-sw720dp-land/
drawable-mdpi/       values-cs/           values-ko/           values-v11/
drawable-xhdpi/      values-de/           values-nl/           values-v14/
drawable-xxhdpi/     values-es/           values-pl/           values-zh/
layout/              values-fr/           values-ru/    
```
