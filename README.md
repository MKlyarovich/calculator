### Calculate the difference between two dates.

#### Description: 
+ Application can read in pairs of dates in the following format -  DD MM YYYY, DD MM YYYY from REST by RequestParam and by MultipartFile;
+ Application validates the input data and computes the difference between the two dates in days;
+ Output in format - DD MM YYYY, DD MM YYYY, difference - where the first date is the earliest, the second date is the latest and the difference is the number of days.

#### Run
In Idea you can start application with property key 
```
-Dspring.profiles.active=test
```
or
```
Run -> Edit Configurations -> Active Profile: test
```

Also you can run the application using:
```
./gradlew bootRun
```

#### Rest API
1\. Calculate the difference between two entered dates:
```
/calculation GET
RequestParam String firstDate
RequestParam String secondDate

Return couneted numbers of days
```

2\. Calculate the difference between two dates from file:
```
/calculation POST
RequestParam MultipartFile multipartFile

Return couneted numbers of days
```