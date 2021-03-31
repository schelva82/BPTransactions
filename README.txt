This project is providing REST APIs to retrieve transactions object from OpenBank sandbox (TEST url) and transforms the data into backbase specific object.
Technologies used:
•	Java 8
•	Spring MVC (without spring boot)
•	Tomcat7 server (embedded) 

Find the instruction document "BP_Transactions_Setup_API_Details.docx" in the root folder for more details.

Start service:
1. checkout project from github https://github.com/schelva82/BPTransactions.git
2. Set JAVA_HOME if it is not set already.
3. Go to BPTransactions project folder and run the below maven command to start the service. 
mvn clean install tomcat7:run
Note: Make sure you have Apache maven installed in your system.
4.	Service will be up and running using embedded tomcat server (using default port 8080). 
We can start calling services using REST API end-points.

API details:
TRANSACTIONS LIST API:
Description: Transactions objects are retrieved from openbank sandbox (test API) and transformed in to backbase specific transactions objects.
Request Type:	GET
REST URL:	http://localhost:8080/backbase/transactions/list
User: testuser 
Password: testuser123
Curl command:	curl http://localhost:8080/backbase/transactions/list -u testuser:testuser123
Response:
	{
	"status": "Success",
	"statusCode": "000",
	"transactions": [{
		"id": "58aeed54-7042-456d-af86-f517bff5b7af",
		"accountId": "savings-kids-john",
		"counterpartyAccount": "savings-kids-john",
		"counterpartyName": "ALIAS_03C57D",
		"counterpartyLogoPath": null,
		"instructedAmount": 8.6,
		"instructedCurrency": "GBP",
		"transactionAmount": 8.6,
		"transactionCurrency": "GBP",
		"transactionType": "SEPA",
		"description": "This is a SEPA Transaction Request"
	}]
}

TRANSACTIONS LIST FILTER API:
Description: Transactions objects are retrieved from openbank sandbox (test API) and transformed in to backbase specific transactions objects and transactions are filtered based on account type
Request Type:	GET
REST URL:	http://localhost:8080/backbase/transactions/list/{type}
input parameter:
type: Transaction type
User: testuser
Password: testuser123
Curl command:	curl http://localhost:8080/backbase/transactions/list/SEPA -u testuser:testuser123
Response:
	{
	"status": "Success",
	"statusCode": "000",
	"transactions": [{
		"id": "58aeed54-7042-456d-af86-f517bff5b7af",
		"accountId": "savings-kids-john",
		"counterpartyAccount": "savings-kids-john",
		"counterpartyName": "ALIAS_03C57D",
		"counterpartyLogoPath": null,
		"instructedAmount": 8.6,
		"instructedCurrency": "GBP",
		"transactionAmount": 8.6,
		"transactionCurrency": "GBP",
		"transactionType": "SEPA",
		"description": "This is a SEPA Transaction Request"
	}}

TRANSACTIONS TOTAL AMOUNT API:
Description:	Returns transactions total amount based on account type
Request Type:	GET
REST URL:	http://localhost:8080/backbase/transactions/list/{type}
input parameter:
type: Transaction type
User: testuser 
Password: testuser123

Curl command:	curl http://localhost:8080/backbase/transactions/list/SEPA -u testuser:testuser123
Getting total amount for transactionType: SEPA
Response:
	{
	"status": "Success",
	"statusCode": "000",
	"amount": {
		"transactionType": "SEPA",
		"totalAmount": 25.799999999999997
	}
}
