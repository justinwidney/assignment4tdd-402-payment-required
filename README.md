# Week3LabTDD

[![Build Status](https://travis-ci.org/Struckdown/Week3LabTDD.svg?branch=master)](https://travis-ci.org/Struckdown/Week3LabTDD)
[![codecov](https://codecov.io/gh/Struckdown/Week3LabTDD/branch/TDD/graph/badge.svg)](https://codecov.io/gh/Struckdown/Week3LabTDD)

The master branch contains the skeleton. 

There is a database somewhere, that contains soccer players' records: name, number of matches, and scores. 
And there is a service that returns the whole list. 

Our job is to implement two methods:

1) countAverageScore---This method returns the average score of each player with their names. 
2) findTopScorer---This method returns the player name and his score who is currently is the highest scorer. 

Dependency: Both methods depend on the service that returns the whole list. The service is slow and we don't 
want to test it. 
MinorGoal: Use Mockito. 

The Main Goal: The Development must follow Test-Driven-Development principles. 
And finally, with Travis CI, we want to check the coverage of our test suite. 
