# Java Technologies Master 1

## Author: Croitoru Razvan

### Laboratory 1

- Compulsory:
  - ✅ Create a servlet that receives a word and returns an HTML page containing the letters of that word presented as an ordered list.  
   ``Added inputs for text & size to the index.jsp and form submit with GET method.``
- Homework:
  - ✅ It receives an integer as a parameter, called size, and it returns all the permutations of length size of the given letters. If the size is 0 (default), it will return all the sequences.  
  ``Permutation generator for all sizes / specific length implemented in the homework page``
  - ✅ If the servlet has access to a server-side file containing a list of acceptable words (a dictionary), it will return only the sequences forming valid words. 
    This list should be large enough; you may use aspell to generate a text file containing English words, or anything similar: WordNet, dexonline, etc.
    For example, if the servlet receives the leters a,a,j,v and the size is 0, it may return the list aa, ava, java (assuming it uses an en english dictionary). 
  ``Generated dictionary using aspell and loaded it into a Set<String> in the WordDictionary class from the homework package``
- Bonus:
  - ✅ Invoke the service from a desktop application (Java, Python, .NET, etc.).
    In this case, the servlet must respond with a simple text containing the list of words, instead of an HTML page -> [invoke_servlet.py](Laboratory1/scripts/invoke_servlet.py)
  - ✅ Modify the servlet so it stores all the requests and results in a log file.
  Write in the server log the following information about each request: the HTTP method used, the IP-address of the client, the user-agent, the client language(s) and the parameters of the request. (Take a look at HttpServletRequest API) -> [requests_logs.log](Laboratory1/logs/requests_logs.log)
  - ✅ If the dictionary is large enough, the servlet may take some time in order to create the response.
    Analyze concurrency issues and resource contention, invoking the servlet repeatedly, in an asynchronous manner  
  ``Called the servlet asynchronously with a python script and got the following results:``
  ```
    For 10 async calls: Duration = 0.216743095 s, Successful requests = 9, Failed requests = 1
    For 50 async calls: Duration = 0.751326118 s, Successful requests = 32, Failed requests = 18
    For 100 async calls: Duration = 1.5155016569999997 s, Successful requests = 64, Failed requests = 36
    For 500 async calls: Duration = 7.1115265370000005 s, Successful requests = 376, Failed requests = 124
    For 1000 async calls: Duration = 14.151883472 s, Successful requests = 750, Failed requests = 250
    ```
    
### Laboratory 2
- ✅ Compulsory (1p)

Create a Web application (starting from the previous lab) containing the following components:

input.jsp: a page containing a form for introducing some letters and a size.
result.jsp a page describing the response that will be delivered to the client, for example an HTML table containing the words of the given size.
- ✅ Homework (2p)

Organize the application so it contains:

an object-oriented domain model;
a server-side component responsible with the business-logic of the application: writing the words to a file, reading data from a file, etc.
a server-side component responsible with controlling the web-flow.
A web filter that will log all requests received by input.jsp.
A web filter that will decorate the response by adding a specific prelude (at the beginning) and a specific coda (at the end) to the generated HTML page.
The purpose of the application is to integrate various components, each having a specialized role.

- ✅ Bonus (2p)

(0.5p) Create a web listener that reads a default category specified as a context init parameter at the application start-up. This default value should be stored in an attribute having application scope and it will be used whenever the request does not contain a category.
(0.5p) Use a "hand-made" cookie to store the category selected by the client. When the user returns to the site (after the current session was invalidated) and presents this cookie, the category will be set automatically.
(In case you want to store sensitive data in a cookie, you may read Improved Persistent Login Cookie Best Practice.)
(1p) Add an original, geometric-inspired, CAPTCHA facility to the input form.
