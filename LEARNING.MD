
### Example of http request
```commandline
GET /index.html HTTP/1.1\r\nHost: localhost:4221\r\nUser-Agent: curl/7.64.1\r\nAccept: */*\r\n\r\n
```
Explanation of above request : 
```commandline
// Request line
GET                          // HTTP method
/index.html                  // Request target
HTTP/1.1                     // HTTP version
\r\n                         // CRLF that marks the end of the request line

// Headers
Host: localhost:4221\r\n     // Header that specifies the server's host and port
User-Agent: curl/7.64.1\r\n  // Header that describes the client's user agent
Accept: */*\r\n              // Header that specifies which media types the client can accept
\r\n                         // CRLF that marks the end of the headers

// Request body (empty)
```
