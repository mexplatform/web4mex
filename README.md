# web4mex

Web4Mex is a REST service which creates MEX RDF out of plain text. The endpoint swagger documentation is available on http://52.173.249.140:3011/swagger-ui.html 

## Exporting your experiment to your first MEX file 

### Get a token!
The following request generates a token which sould be used to create your experiment:

http://52.173.249.140:3011/

Or using CURL...

```curl -X GET --header 'Accept: text/plain' 'http://52.173.249.140:3011/token'```

### Adding basic information about yourself
Next, MEX needs information about the experiment creator or maintainer.

#### Creator
