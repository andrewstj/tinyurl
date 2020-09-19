# Requirements
- Sending a POST request to the application running locally with any URL will generate and return a shortened version such as http://localhost:port/Xtbu9R
Request sample:
`{"url":"https://test.com?q=some_url_that_could_be_long"}`
- Application to maintain as many as millions of short URLs if necessary
- The application should persist data in durable storage of your choice
- Navigating to that shortened route will redirect you to the URL providing to the POST
