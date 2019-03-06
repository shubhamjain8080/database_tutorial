1. Install Mongodb.
2. Start Mongodb
3. mongoimport --db rest_database --collection receipts --file {File location folder}\Receipts.json
4.Payment : Request : http://localhost:8080/receipts/payment
	Response : Shows all the restaurants with total payment done.
	Example : {restId: totalpayment}
	{"58cf60fe5d1080472738d54f":653.0,"5944f28a5d10803dd67da71e":595.0}
5.Daily/Monthly/Weekly Payment for a restaurant:
Request: http://localhost:8080/receipts/monthly/58cf60fe5d1080472738d54f
Response: {"Sep, 2017":428.0,"Oct, 2017":225.0}
Request: http://localhost:8080/receipts/daily/58cf60fe5d1080472738d54f
Response: {"Oct 22, 2017":225.0,"Sep 12, 2017":179.0,"Sep 25, 2017":249.0}
Request: http://localhost:8080/receipts/weekly/58cf60fe5d1080472738d54f
Response: {"5 week of Sep, 2017":249.0,"3 week of Sep, 2017":179.0,"4 week of Oct, 2017":225.0}