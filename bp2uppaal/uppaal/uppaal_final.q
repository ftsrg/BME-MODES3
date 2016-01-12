//This file was generated from (Academic) UPPAAL 4.1.18 (rev. 5444), November 2013

/*

*/
Test.Finished --> not OccupiedDiv.dedicated10 && OccupiedStr.dedicated10 && not OccupiedTop.dedicated10

/*
Use case 5: DIV,TOP,STR Section with DIV Turnout, STR Turnout
*/
Test.Finished --> OccupiedDiv.dedicated10 && OccupiedStr.dedicated10 && OccupiedTop.dedicated10

/*
Use case 4: TOP Section with STR Turnout
*/
A<> not OccupiedTop.dedicated10

/*
Use case 3: DIV Section with STR Turnout
*/
Test.Finished --> OccupiedDiv.dedicated10

/*
Use case 2: STR,TOP Section with STR Turnout
*/
Test.Finished --> (OccupiedStr.dedicated10 && OccupiedTop.dedicated10)

/*
Use case 1: DIV,TOP Section with DIV Turnout

*/
Test.Finished --> (OccupiedDiv.dedicated10 && OccupiedTop.dedicated10)
