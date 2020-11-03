Calculate letter statistic api
Returns json data about letter statistic in string.

NOTE !!!
When you sending string as parameter in request, you should encode string by percent-encoding.
String Before encode: #GeeKs01fOr@gEEks07                
String after encode: 123o21j%40%21%23%21%24%21DSADAScxzda


URL /countAllStatistics/
	Method:GET
	URL Params Required: stringToCheck=[string]
	Examples:
	http://localhost:8080/countAllStatistics?stringToCheck=123o21j%40%21%23%21%24%21DSADAScxzda
	Success Response:
	Code: 200
	Content: 
	{
	lowerLetter: 7,
	upperLetter: 6,
	checkedString: "123o21j@!#!$!DSADAScxzda",
	specialLetter: 6

	}

	http://localhost:8080/countAllStatistics?stringToCheck=
	Error Response:
	Code: 400 BAD REQUEST
	Content: 
	{
	Error: "String is empty"
	}


URL /countSpecialLetter/
	Method:GET
	URL Params Required: stringToCheck=[string]
	Examples:
	http://localhost:8080/countSpecialLetter?stringToCheck=123o21j%40%21%23%21%24%21DSADAScxzda
	Success Response:
	Code: 200
	Content: 
	{
	checkedString: "123o21j@!#!$!DSADAScxzda",
	specialLetter: 6
	}

	http://localhost:8080/countSpecialLetter?stringToCheck=
	Error Response:
	Code: 400 BAD REQUEST
	Content: 
	{
	Error: "String is empty"
	}
	
URL /countLowerLetter/
	Method:GET
	URL Params Required: stringToCheck=[string]
	Examples:
	http://localhost:8080/countLowerLetter?stringToCheck=123o21j%40%21%23%21%24%21DSADAScxzda
	Success Response:
	Code: 200
	Content: 
	{
	lowerLetter: 7,
	checkedString: "123o21j@!#!$!DSADAScxzda"
	}

	http://localhost:8080/countSpecialLetter?stringToCheck=
	Error Response:
	Code: 400 BAD REQUEST
	Content: 
	{
	Error: "String is empty"
	}
	
URL /countUpperLetter/
	Method:GET
	URL Params Required: stringToCheck=[string]
	Examples:
	http://localhost:8080/countUpperLetter?stringToCheck=123o21j%40%21%23%21%24%21DSADAScxzda
	Success Response:
	Code: 200
	Content: 
	{
	upperLetter: 6,
	checkedString: "123o21j@!#!$!DSADAScxzda"
	}

	http://localhost:8080/countUpperLetter?stringToCheck=
	Error Response:
	Code: 400 BAD REQUEST
	Content: 
	{
	Error: "String is empty"
	}
	
Any other URL give PAGE NOT FOUNT ERROR

	Error Response:
	Code: 404 NOT FOUND
	Content: 
	Whitelabel Error Page
	This application has no explicit mapping for /error, so you are seeing this as a fallback.

	Tue Nov 03 16:10:13 CET 2020
	There was an unexpected error (type=Not Found, status=404).
