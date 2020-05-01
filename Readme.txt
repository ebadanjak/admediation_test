For this task i decided to create s Spring Boot application.

For the storage, i used external PostgreSQL database.
TABLE - AD_NETWORKS
----------------------
ID - number -> populated with sequence
ad_network_handler - varchar -> one word representation of Ad-Network (example. 'FACEBOOK', 'ADMOB'...)
country - varchar -> country code (example. 'SLO', 'CRO', 'USA'...)
ad_type - varchar -> 'BANNER', 'INTERSTITIAL', 'VIDEO'
iab_category - varchar -> one word representation of interest (example. 'MOVIES')
platform - varchar -> (example. 'ANDROID', 'IOS'...)
device_brand - varchar -> (example. 'SAMSUNG', 'IPHONE'...)
score_val - number -> a number between 0 and 100
record_date - timestamp

I made the assumption the table is a part of more complex database model.
Also that the table is maintained by another system (partitioning, indexing, archiving/truncating etc.)

The application/service is providing 1 endpoint "/ad-networks"
	- HTTP GET - The body of the request must contain client contextual data
			   - Based on the given data, API returns 3 lists (1 list for each ad type)
	- HTTP POST - The body of the request should be a list of new ad-networks
				- If the list is succesfully stored, the response from the API should be "SUCESS"
				
				
Additional info:

- I made the assumption that the ad_networks table is updated with large amount of data,
	so I used Hibernate Second-Level caching that will cache the data into persistence context and will also cache the result of queries.
- Also, since I believe it is updated with a lot of data, the inserts are made in batches.
- Each AdNetwork should have its own validation class that implements the AdNetworkValidator interface for easier maintainance.
	- I created just a few of those classes, and only some of them have implemented logic. 


AppEngine

- I tried deploying the application to AppEngine but with no success. I am not familiar with development on Google Cloud platform.
- Deploying the Spring Boot application to AppEngine should be as easy as:
	- Excluding embedded server (tomcat) and logger (slf4j) dependencies
	- Adding app-engine dependencies and plugins
	- Running "gradle appengineDeploy" task (if using Gradle)
- I am sending you the version without appengine configuratiuon.


Build

- To build a jar file, a gradle task "build" should be invoked
- In the same directory as a Jar file include an application.properties file that will override properties (I left properties concerning database connection empty)
- If the application is deployed locally, API can be accessed at "http://localhost:8080/ad-mediation/ad-networks"


* I hope you won't mind this brief explanation of application. I'm looking forward to discuss the application in details. :)