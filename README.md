# web4mex

Web4Mex is a REST service which creates MEX RDF out of plain text. The endpoint swagger documentation is available on http://52.173.249.140:3011/swagger-ui.html 

## Exporting your experiment to your first MEX file 

Three simple steps are necessary to create your first MEX file.

### Get a token!
The following request generates a token which should be used to create your experiment:

http://52.173.249.140:3011/token

You can check out the CURL request on the [swagger documentation](http://52.173.249.140:3011/swagger-ui.html).

### Add basic information about yourself
Next, MEX needs information about the experiment creator or maintainer.

Use your token to set the [Author Email](http://52.173.249.140:3011/swagger-ui.html#!/mex45controller/setAuthorEmailUsingPOST) and  [Author Name](http://52.173.249.140:3011/swagger-ui.html#!/mex45controller/setAuthorNameUsingPOST).

### Add data about your experiment
The experiment itself can be described using the [Experiment Endpoint](http://52.173.249.140:3011/swagger-ui.html#/experiment45controller). Remember that you need to send your token on each request.

## Get your MEX description in RDF!
Done with adding basic data about your experiment?

Now you can get your MEX description using the [Serializer Endpoint](http://52.173.249.140:3011/swagger-ui.html#!/mex45controller/serializeUsingGET). Send the token and the desired format (e.g., ttl) to receive your MEX RDF data! 
