See the Assessment Guide for information on how to interpret this report.

ASSESSMENT SUMMARY

Compilation:  PASSED
API:          PASSED

Spotbugs:     PASSED
PMD:          FAILED (4 warnings)
Checkstyle:   FAILED (0 errors, 20 warnings)

Correctness:  28/41 tests passed
Memory:       1/1 tests passed
Timing:       41/41 tests passed

Aggregate score: 80.98%
[Compilation: 5%, API: 5%, Spotbugs: 0%, PMD: 0%, Checkstyle: 0%, Correctness: 60%, Memory: 10%, Timing: 20%]

ASSESSMENT DETAILS

The following files were submitted:
----------------------------------
3.4K Jul 19 03:26 BruteCollinearPoints.java
4.1K Jul 19 03:26 FastCollinearPoints.java
4.5K Jul 19 03:26 Point.java


********************************************************************************
*  COMPILING
********************************************************************************


% javac Point.java
*-----------------------------------------------------------

% javac LineSegment.java
*-----------------------------------------------------------

% javac BruteCollinearPoints.java
*-----------------------------------------------------------

% javac FastCollinearPoints.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
Point:

BruteCollinearPoints:

FastCollinearPoints:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS
********************************************************************************


% spotbugs *.class
*-----------------------------------------------------------


================================================================


% pmd .
*-----------------------------------------------------------
BruteCollinearPoints.java:15: Avoid unused private instance (or static) variables, such as 'DELAY'. [UnusedPrivateField]
FastCollinearPoints.java:15: Avoid unused private instance (or static) variables, such as 'DELAY'. [UnusedPrivateField]
FastCollinearPoints.java:74: Avoid reassigning the loop control variable 'q' [AvoidReassigningLoopVariables]
Point.java:151: The method body is empty. If this is your intent, document it with a comment. [UncommentedEmptyMethodBody]
PMD ends with 4 warnings.


================================================================


% checkstyle *.java
*-----------------------------------------------------------
[WARN] BruteCollinearPoints.java:109:15: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] BruteCollinearPoints.java:110:15: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] BruteCollinearPoints.java:119:15: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] BruteCollinearPoints.java:120:15: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] FastCollinearPoints.java:74:30: Control variable 'q' is modified inside loop. [ModifiedControlVariable]
[WARN] FastCollinearPoints.java:129:15: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] FastCollinearPoints.java:130:15: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] FastCollinearPoints.java:139:15: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] FastCollinearPoints.java:140:15: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] Point.java:63:35: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] Point.java:68:33: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] Point.java:73:33: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] Point.java:78:9: Use the primitive type 'double' instead of the wrapper type 'Double'. [Wrapper]
[WARN] Point.java:78:16: The local (or parameter) variable 'y' has the same name as an instance variable. Use a different name. [HiddenField]
[WARN] Point.java:78:27: Typecast is not followed by whitespace. [WhitespaceAfter]
[WARN] Point.java:79:9: Use the primitive type 'double' instead of the wrapper type 'Double'. [Wrapper]
[WARN] Point.java:79:16: The local (or parameter) variable 'x' has the same name as an instance variable. Use a different name. [HiddenField]
[WARN] Point.java:79:27: Typecast is not followed by whitespace. [WhitespaceAfter]
Checkstyle ends with 0 errors and 18 warnings.

% custom checkstyle checks for Point.java
*-----------------------------------------------------------

% custom checkstyle checks for BruteCollinearPoints.java
*-----------------------------------------------------------
[WARN] BruteCollinearPoints.java:15:38: The numeric literal '1000' appears to be unnecessary. [NumericLiteral]
Checkstyle ends with 0 errors and 1 warning.

% custom checkstyle checks for FastCollinearPoints.java
*-----------------------------------------------------------
[WARN] FastCollinearPoints.java:15:38: The numeric literal '1000' appears to be unnecessary. [NumericLiteral]
Checkstyle ends with 0 errors and 1 warning.


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of Point
*-----------------------------------------------------------
Running 3 total tests.

Test 1: p.slopeTo(q)
  * positive infinite slope, where p and q have coordinates in [0, 500)
  * positive infinite slope, where p and q have coordinates in [0, 32768)
  * negative infinite slope, where p and q have coordinates in [0, 500)
  * negative infinite slope, where p and q have coordinates in [0, 32768)
  * positive zero     slope, where p and q have coordinates in [0, 500)
  * positive zero     slope, where p and q have coordinates in [0, 32768)
  * symmetric for random points p and q with coordinates in [0, 500)
  * symmetric for random points p and q with coordinates in [0, 32768)
  * transitive for random points p, q, and r with coordinates in [0, 500)
  * transitive for random points p, q, and r with coordinates in [0, 32768)
  * slopeTo(), where p and q have coordinates in [0, 500)
  * slopeTo(), where p and q have coordinates in [0, 32768)
  * slopeTo(), where p and q have coordinates in [0, 10)
  * throw a java.lang.NullPointerException if argument is null
==> passed

Test 2: p.compareTo(q)
  * reflexive, where p and q have coordinates in [0, 500)
  * reflexive, where p and q have coordinates in [0, 32768)
  * antisymmetric, where p and q have coordinates in [0, 500)
  * antisymmetric, where p and q have coordinates in [0, 32768)
  * transitive, where p, q, and r have coordinates in [0, 500)
  * transitive, where p, q, and r have coordinates in [0, 32768)
  * sign of compareTo(), where p and q have coordinates in [0, 500)
  * sign of compareTo(), where p and q have coordinates in [0, 32768)
  * sign of compareTo(), where p and q have coordinates in [0, 10)
  * throw java.lang.NullPointerException exception if argument is null
==> passed

Test 3: p.slopeOrder().compare(q, r)
  * reflexive, where p and q have coordinates in [0, 500)
  * reflexive, where p and q have coordinates in [0, 32768)
  * antisymmetric, where p, q, and r have coordinates in [0, 500)
  * antisymmetric, where p, q, and r have coordinates in [0, 32768)
  * transitive, where p, q, r, and s have coordinates in [0, 500)
  * transitive, where p, q, r, and s have coordinates in [0, 32768)
  * sign of compare(), where p, q, and r have coordinates in [0, 500)
  * sign of compare(), where p, q, and r have coordinates in [0, 32768)
  * sign of compare(), where p, q, and r have coordinates in [0, 10)
  * throw java.lang.NullPointerException if either argument is null
==> passed


Total: 3/3 tests passed!


================================================================
********************************************************************************
*  TESTING CORRECTNESS (substituting reference Point and LineSegment)
********************************************************************************

Testing correctness of BruteCollinearPoints
*-----------------------------------------------------------
Running 17 total tests.

The inputs satisfy the following conditions:
  - no duplicate points
  - no 5 (or more) points are collinear
  - all x- and y-coordinates between 0 and 32,767

Test 1: points from a file
  * filename = input8.txt
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
==> passed

Test 2a: points from a file with horizontal line segments
  * filename = horizontal5.txt
  * filename = horizontal25.txt
==> passed

Test 2b: random horizontal line segments
  *  1 random horizontal line segment
  *  5 random horizontal line segments
  * 10 random horizontal line segments
  * 15 random horizontal line segments
==> passed

Test 3a: points from a file with vertical line segments
  * filename = vertical5.txt
  * filename = vertical25.txt
==> passed

Test 3b: random vertical line segments
  *  1 random vertical line segment
  *  5 random vertical line segments
  * 10 random vertical line segments
  * 15 random vertical line segments
==> passed

Test 4a: points from a file with no line segments
  * filename = random23.txt
  * filename = random38.txt
==> passed

Test 4b: random points with no line segments
  *  5 random points
  * 10 random points
  * 20 random points
  * 50 random points
==> passed

Test 5: points from a file with fewer than 4 points
  * filename = input1.txt
  * filename = input2.txt
  * filename = input3.txt
==> passed

Test 6: check for dependence on either compareTo() or compare()
        returning { -1, +1, 0 } instead of { negative integer,
        positive integer, zero }
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
==> passed

Test 7: check for fragile dependence on return value of toString()
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
==> passed

Test 8: random line segments, none vertical or horizontal
  *  1 random line segment
  *  5 random line segments
  * 10 random line segments
  * 15 random line segments
==> passed

Test 9: random line segments
  *  1 random line segment
  *  5 random line segments
  * 10 random line segments
  * 15 random line segments
==> passed

Test 10: check that data type is immutable by testing whether each method
         returns the same value, regardless of any intervening operations
  * input8.txt
  * equidistant.txt
==> passed

Test 11: check that data type does not mutate the constructor argument
  * input8.txt
  * equidistant.txt
==> passed

Test 12: numberOfSegments() is consistent with segments()
  * filename = input8.txt
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
  * filename = horizontal5.txt
  * filename = vertical5.txt
  * filename = random23.txt
==> passed

Test 13: throws an exception if either the constructor argument is null
         or any entry in array is null
  * argument is null
  * Point[] of length 10, number of null entries = 1
  * Point[] of length 10, number of null entries = 10
  * Point[] of length 4, number of null entries = 1
  * Point[] of length 3, number of null entries = 1
  * Point[] of length 2, number of null entries = 1
  * Point[] of length 1, number of null entries = 1
==> passed

Test 14: check that the constructor throws an exception if duplicate points
  * 50 points
  * 25 points
  * 5 points
  * 4 points
  * 3 points
  * 2 points
==> passed


Total: 17/17 tests passed!


================================================================
Testing correctness of FastCollinearPoints
*-----------------------------------------------------------
Running 21 total tests.

The inputs satisfy the following conditions:
  - no duplicate points
  - all x- and y-coordinates between 0 and 32,767

Test 1: points from a file
  * filename = input8.txt
  * filename = equidistant.txt
  * filename = input40.txt
    - number of entries in student   solution: 3
    - number of entries in reference solution: 4
    - 1 missing entry in student solution:
      '(1000, 17000) -> (1000, 27000) -> (1000, 28000) -> (1000, 31000)'


  * filename = input48.txt
    - number of entries in student   solution: 4
    - number of entries in reference solution: 6
    - 2 missing entries in student solution, including:
      '(18000, 13000) -> (18000, 23000) -> (18000, 26000) -> (18000, 27000)'


  * filename = input299.txt
    - number of entries in student   solution: 4
    - number of entries in reference solution: 6
    - 2 missing entries in student solution, including:
      '(7300, 10050) -> (7300, 10450) -> (7300, 25700) -> (7300, 31650)'


==> FAILED

Test 2a: points from a file with horizontal line segments
  * filename = horizontal5.txt
  * filename = horizontal25.txt
  * filename = horizontal50.txt
  * filename = horizontal75.txt
  * filename = horizontal100.txt
==> passed

Test 2b: random horizontal line segments
  *  1 random horizontal line segment
    - number of entries in student   solution: 0
    - number of entries in reference solution: 1
    - 1 missing entry in student solution:
      '(3749, 3891) -> (15245, 3891) -> (16430, 3891) -> (18785, 3891)'


    - failed on trial 1 of 500
     4
     15245  3891
     16430  3891
      3749  3891
     18785  3891

  *  5 random horizontal line segments
    - number of entries in student   solution: 4
    - number of entries in reference solution: 5
    - 1 missing entry in student solution:
      '(1663, 20593) -> (1752, 20593) -> (9869, 20593) -> (10951, 20593)'


    - failed on trial 3 of 250
     20
     10951 20593
     14028 13625
     20876  9365
      6484 13625
      1663 20593
      9518  9122
      6959  9122
     17345 14176
      7543 14176
     16665  9122
     13075 14176
     20998 13625
     12972  9365
      1752 20593
     17506  9365
     16618  9122
     18664 13625
      3608  9365
      9869 20593
      5066 14176

  * 10 random horizontal line segments
    - number of entries in student   solution: 9
    - number of entries in reference solution: 10
    - 1 missing entry in student solution:
      '(1198, 14931) -> (1965, 14931) -> (7534, 14931) -> (10119, 14931)'


    - failed on trial 5 of 50

  * 15 random horizontal line segments
==> FAILED

Test 3a: points from a file with vertical line segments
  * filename = vertical5.txt
    - number of entries in student   solution: 0
    - number of entries in reference solution: 5
    - 5 missing entries in student solution, including:
      '(14407, 10367) -> (14407, 17188) -> (14407, 17831) -> (14407, 19953)'


  * filename = vertical25.txt
    - number of entries in student   solution: 0
    - number of entries in reference solution: 25
    - 25 missing entries in student solution, including:
      '(19953, 10489) -> (19953, 10688) -> (19953, 19299) -> (19953, 20439)'


  * filename = vertical50.txt
    - number of entries in student   solution: 0
    - number of entries in reference solution: 50
    - 50 missing entries in student solution, including:
      '(5991, 15606) -> (5991, 20227) -> (5991, 20340) -> (5991, 20424)'


  * filename = vertical75.txt
    - number of entries in student   solution: 0
    - number of entries in reference solution: 75
    - 75 missing entries in student solution, including:
      '(13780, 16365) -> (13780, 17494) -> (13780, 18253) -> (13780, 18908)'


  * filename = vertical100.txt
    - number of entries in student   solution: 0
    - number of entries in reference solution: 100
    - 100 missing entries in student solution, including:
      '(15135, 15588) -> (15135, 17398) -> (15135, 19476) -> (15135, 20439)'


==> FAILED

Test 3b: random vertical line segments
  *  1 random vertical line segment
    - number of entries in student   solution: 0
    - number of entries in reference solution: 1
    - 1 missing entry in student solution:
      '(10620, 3867) -> (10620, 4205) -> (10620, 9290) -> (10620, 11433)'


    - failed on trial 1 of 500
     4
     10620 11433
     10620  9290
     10620  3867
     10620  4205

  *  5 random vertical line segments
    - number of entries in student   solution: 0
    - number of entries in reference solution: 5
    - 5 missing entries in student solution, including:
      '(12117, 15578) -> (12117, 16232) -> (12117, 18911) -> (12117, 20918)'


    - failed on trial 1 of 250
     20
     15267 12439
     16783 20333
     17219 13751
      2180 13617
     15267  1176
     12117 15578
     17219 17842
     17219  3313
     12117 18911
     12117 20918
     15267  6817
     16783 16229
     15267 18338
     16783 12266
      2180  9991
      2180 11435
     16783  9529
      2180 12125
     12117 16232
     17219  9233

  * 10 random vertical line segments
    - number of entries in student   solution: 0
    - number of entries in reference solution: 10
    - 10 missing entries in student solution, including:
      '(13019, 6872) -> (13019, 13394) -> (13019, 17825) -> (13019, 20815)'


    - failed on trial 1 of 50

  * 15 random vertical line segments
    - number of entries in student   solution: 0
    - number of entries in reference solution: 15
    - 15 missing entries in student solution, including:
      '(8804, 13527) -> (8804, 14380) -> (8804, 17060) -> (8804, 19501)'


    - failed on trial 1 of 5

==> FAILED

Test 4a: points from a file with no line segments
  * filename = random23.txt
  * filename = random38.txt
  * filename = random91.txt
  * filename = random152.txt
==> passed

Test 4b: random points with no line segments
  *  5 random points
  * 10 random points
  * 20 random points
  * 50 random points
==> passed

Test 5a: points from a file with 5 or more on some line segments
  * filename = input9.txt
    - segments() contains a subsegment of a segment in reference solution
    - student   segment 0: (1000, 1000) -> (8000, 8000)
    - reference segment 0: (1000, 1000) -> (2000, 2000) -> (3000, 3000) -> (4000, 4000) -> (5000, 5000) -> (6000, 6000) -> (7000, 7000) -> (8000, 8000) -> (9000, 9000)

    - number of entries in student   solution: 1
    - number of entries in reference solution: 1
    - 1 extra entry in student solution:
      '(1000, 1000) -> (8000, 8000)'

    - 1 missing entry in student solution:
      '(1000, 1000) -> (2000, 2000) -> (3000, 3000) -> (4000, 4000) -> (5000, 5000) -> (6000, 6000) -> (7000, 7000) -> (8000, 8000) -> (9000, 9000)'


  * filename = input10.txt
    - segments() contains a subsegment of a segment in reference solution
    - student   segment 1: (1000, 18000) -> (3500, 28000)
    - reference segment 1: (1000, 18000) -> (2000, 22000) -> (3000, 26000) -> (3500, 28000) -> (4000, 30000)

    - number of entries in student   solution: 2
    - number of entries in reference solution: 2
    - 1 extra entry in student solution:
      '(1000, 18000) -> (3500, 28000)'

    - 1 missing entry in student solution:
      '(1000, 18000) -> (2000, 22000) -> (3000, 26000) -> (3500, 28000) -> (4000, 30000)'


  * filename = input20.txt
    - segments() contains a subsegment of a segment in reference solution
    - student   segment 1: (4096, 20992) -> (4096, 24064)
    - reference segment 3: (4096, 20992) -> (4096, 22016) -> (4096, 23040) -> (4096, 24064) -> (4096, 25088)

    - number of entries in student   solution: 5
    - number of entries in reference solution: 5
    - 2 extra entries in student solution, including:
      '(8192, 25088) -> (8192, 28160)'

    - 2 missing entries in student solution, including:
      '(8192, 25088) -> (8192, 26112) -> (8192, 27136) -> (8192, 28160) -> (8192, 29184)'


  * filename = input50.txt
    - segments() contains a subsegment of a segment in reference solution
    - student   segment 1: (1000, 2000) -> (1000, 23000)
    - reference segment 5: (1000, 2000) -> (1000, 9000) -> (1000, 13000) -> (1000, 23000) -> (1000, 26000)

    - number of entries in student   solution: 7
    - number of entries in reference solution: 7
    - 2 extra entries in student solution, including:
      '(18000, 13000) -> (18000, 27000)'

    - 2 missing entries in student solution, including:
      '(18000, 13000) -> (18000, 23000) -> (18000, 26000) -> (18000, 27000) -> (18000, 30000)'


  * filename = input80.txt
    - segments() contains a subsegment of a segment in reference solution
    - student   segment 17: (25000, 8000) -> (25000, 29000)
    - reference segment 28: (25000, 8000) -> (25000, 9000) -> (25000, 12000) -> (25000, 27000) -> (25000, 29000) -> (25000, 31000)

    - number of entries in student   solution: 24
    - number of entries in reference solution: 31
    - 1 extra entry in student solution:
      '(25000, 8000) -> (25000, 29000)'

    - 8 missing entries in student solution, including:
      '(29000, 14000) -> (29000, 18000) -> (29000, 24000) -> (29000, 31000)'


  * filename = input300.txt
    - segments() contains a subsegment of a segment in reference solution
    - student   segment 3: (7300, 10050) -> (7300, 25700)
    - reference segment 5: (7300, 10050) -> (7300, 10450) -> (7300, 17000) -> (7300, 25700) -> (7300, 31650)

    - number of entries in student   solution: 5
    - number of entries in reference solution: 6
    - 1 extra entry in student solution:
      '(7300, 10050) -> (7300, 25700)'

    - 2 missing entries in student solution, including:
      '(7300, 10050) -> (7300, 10450) -> (7300, 17000) -> (7300, 25700) -> (7300, 31650)'


  * filename = inarow.txt
    - segments() contains a subsegment of a segment in reference solution
    - student   segment 2: (0, 0) -> (0, 25000)
    - reference segment 4: (0, 0) -> (0, 5000) -> (0, 10000) -> (0, 11000) -> (0, 15000) -> (0, 20000) -> (0, 25000) -> (0, 30000)

    - number of entries in student   solution: 5
    - number of entries in reference solution: 5
    - 1 extra entry in student solution:
      '(0, 0) -> (0, 25000)'

    - 1 missing entry in student solution:
      '(0, 0) -> (0, 5000) -> (0, 10000) -> (0, 11000) -> (0, 15000) -> (0, 20000) -> (0, 25000) -> (0, 30000)'


==> FAILED

Test 5b: points from a file with 5 or more on some line segments
  * filename = kw1260.txt
    - segments() contains a subsegment of a segment in reference solution
    - student   segment 15: (21030, 1952) -> (21030, 3113)
    - reference segment 282: (21030, 1952) -> (21030, 2339) -> (21030, 2726) -> (21030, 3113) -> (21030, 3500)

    - number of entries in student   solution: 284
    - number of entries in reference solution: 288
    - 18 extra entries in student solution, including:
      '(15188, 21523) -> (15188, 21787)'

    - 22 missing entries in student solution, including:
      '(15188, 21523) -> (15188, 21611) -> (15188, 21699) -> (15188, 21787) -> (15188, 21875)'


  * filename = rs1423.txt
    - number of entries in student   solution: 442
    - number of entries in reference solution: 443
    - 1 missing entry in student solution:
      '(15294, 17325) -> (15294, 17358) -> (15294, 17391) -> (15294, 17424)'


==> FAILED

Test 6: points from a file with fewer than 4 points
  * filename = input1.txt
  * filename = input2.txt
  * filename = input3.txt
==> passed

Test 7: check for dependence on either compareTo() or compare()
        returning { -1, +1, 0 } instead of { negative integer,
        positive integer, zero }
  * filename = equidistant.txt
  * filename = input40.txt
    - number of entries in student   solution: 3
    - number of entries in reference solution: 4
    - 1 missing entry in student solution:
      '(1000, 17000) -> (1000, 27000) -> (1000, 28000) -> (1000, 31000)'


  * filename = input48.txt
    - number of entries in student   solution: 4
    - number of entries in reference solution: 6
    - 2 missing entries in student solution, including:
      '(18000, 13000) -> (18000, 23000) -> (18000, 26000) -> (18000, 27000)'


  * filename = input299.txt
    - number of entries in student   solution: 4
    - number of entries in reference solution: 6
    - 2 missing entries in student solution, including:
      '(7300, 10050) -> (7300, 10450) -> (7300, 25700) -> (7300, 31650)'


==> FAILED

Test 8: check for fragile dependence on return value of toString()
  * filename = equidistant.txt
  * filename = input40.txt
    - number of entries in student   solution: 3
    - number of entries in reference solution: 4
    - 1 missing entry in student solution:
      '(1000, 17000) -> (1000, 27000) -> (1000, 28000) -> (1000, 31000)'


  * filename = input48.txt
    - number of entries in student   solution: 4
    - number of entries in reference solution: 6
    - 2 missing entries in student solution, including:
      '(18000, 13000) -> (18000, 23000) -> (18000, 26000) -> (18000, 27000)'



It is bad style to write code that depends on the particular format of
the output from the toString() method, especially if your reason for
doing so is to circumvent the public API (which intentionally does not
provide access to the x- and y-coordinates).

==> FAILED

Test 9: random line segments, none vertical or horizontal
  *  1 random line segment
    - number of entries in student   solution: 0
    - number of entries in reference solution: 1
    - 1 missing entry in student solution:
      '(5602, 6514) -> (7767, 9794) -> (9932, 13074) -> (10798, 14386)'


    - failed on trial 1 of 500
     4
      9932 13074
      5602  6514
     10798 14386
      7767  9794

  *  5 random line segments
    - number of entries in student   solution: 4
    - number of entries in reference solution: 5
    - 1 missing entry in student solution:
      '(2016, 6371) -> (8748, 11879) -> (10244, 13103) -> (18472, 19835)'


    - failed on trial 2 of 500
     20
      6975  5255
      9991  6948
     10244 13103
      6841  7115
     11097  9347
      7662  5937
     14061 10268
     18681 10127
      2016  6371
       360  5787
     18293 12505
      9177  6284
     13845 12075
      6023  6730
     18131 13588
      8634  7747
     18472 19835
      8748 11879
      4387  5960
      4497  6767

  * 25 random line segments
    - number of entries in student   solution: 24
    - number of entries in reference solution: 25
    - 1 missing entry in student solution:
      '(6000, 1094) -> (6108, 11624) -> (6156, 16304) -> (6180, 18644)'


    - failed on trial 2 of 100

  * 50 random line segments
    - number of entries in student   solution: 49
    - number of entries in reference solution: 50
    - 1 missing entry in student solution:
      '(7751, 226) -> (7793, 5476) -> (7828, 9851) -> (7898, 18601)'


    - failed on trial 5 of 15

  * 100 random line segments
==> FAILED

Test 10: random line segments
  *  1 random line segment
    - number of entries in student   solution: 0
    - number of entries in reference solution: 1
    - 1 missing entry in student solution:
      '(10157, 10057) -> (10157, 10399) -> (10157, 11083) -> (10157, 11330)'


    - failed on trial 1 of 500
     4
     10157 11083
     10157 10399
     10157 11330
     10157 10057

  *  5 random line segments
    - number of entries in student   solution: 4
    - number of entries in reference solution: 5
    - 1 missing entry in student solution:
      '(9817, 5548) -> (10089, 6316) -> (10157, 6508) -> (10480, 7420)'


    - failed on trial 1 of 500
     20
      5020  5920
      6065  5373
      7672  7858
      4968  5882
      8051 12712
      3823  4393
      4933  6909
      4183  5209
      5384  6186
      5861  5301
     10480  7420
      9817  5548
     10157  6508
      3977 12712
     10089  6316
      8377  6189
      3553  3781
      6596 12712
      8785  6333
      6111 12712

  * 25 random line segments
    - number of entries in student   solution: 19
    - number of entries in reference solution: 25
    - 6 missing entries in student solution, including:
      '(14381, 11659) -> (14381, 11722) -> (14381, 12310) -> (14381, 12583)'


    - failed on trial 1 of 100

  * 50 random line segments
    - number of entries in student   solution: 47
    - number of entries in reference solution: 50
    - 3 missing entries in student solution, including:
      '(7807, 7717) -> (7807, 9157) -> (7807, 10057) -> (7807, 10687)'


    - failed on trial 1 of 15

  * 100 random line segments
    - number of entries in student   solution: 90
    - number of entries in reference solution: 100
    - 10 missing entries in student solution, including:
      '(13565, 10206) -> (13565, 10656) -> (13565, 13311) -> (13565, 14436)'


    - failed on trial 1 of 2

==> FAILED

Test 11: random distinct points in a given range
  * 5 random points in a 10-by-10 grid
    - number of entries in student   solution: 0
    - number of entries in reference solution: 1
    - 1 missing entry in student solution:
      '(5, 5) -> (5, 6) -> (5, 7) -> (5, 9)'


    - failed on trial 21 of 500
     5
         5     5
         5     6
         5     7
         5     9
         1     3

  * 10 random points in a 10-by-10 grid
    - number of entries in student   solution: 0
    - number of entries in reference solution: 1
    - 1 missing entry in student solution:
      '(5, 5) -> (5, 7) -> (5, 8) -> (5, 9)'


    - failed on trial 14 of 500
     10
         5     5
         5     9
         8     2
         8     4
         0     1
         6     6
         6     8
         0     0
         5     7
         5     8

  * 50 random points in a 10-by-10 grid
    - segments() contains a subsegment of a segment in reference solution
    - student   segment 4: (1, 0) -> (1, 7)
    - reference segment 28: (1, 0) -> (1, 2) -> (1, 4) -> (1, 5) -> (1, 6) -> (1, 7) -> (1, 8)

    - number of entries in student   solution: 34
    - number of entries in reference solution: 37
    - 6 extra entries in student solution, including:
      '(4, 1) -> (4, 7)'

    - 9 missing entries in student solution, including:
      '(4, 1) -> (4, 2) -> (4, 3) -> (4, 5) -> (4, 7) -> (4, 8)'


    - failed on trial 1 of 100

  * 90 random points in a 10-by-10 grid
    - segments() contains a subsegment of a segment in reference solution
    - student   segment 7: (0, 0) -> (0, 8)
    - reference segment 112: (0, 0) -> (0, 1) -> (0, 2) -> (0, 4) -> (0, 5) -> (0, 7) -> (0, 8) -> (0, 9)

    - number of entries in student   solution: 122
    - number of entries in reference solution: 122
    - 10 extra entries in student solution, including:
      '(9, 0) -> (9, 8)'

    - 10 missing entries in student solution, including:
      '(9, 0) -> (9, 1) -> (9, 2) -> (9, 3) -> (9, 4) -> (9, 5) -> (9, 7) -> (9, 8) -> (9, 9)'


    - failed on trial 1 of 50

  * 200 random points in a 50-by-50 grid
    - segments() contains a subsegment of a segment in reference solution
    - student   segment 5: (31, 0) -> (31, 34)
    - reference segment 222: (31, 0) -> (31, 7) -> (31, 8) -> (31, 9) -> (31, 12) -> (31, 25) -> (31, 34) -> (31, 43)

    - number of entries in student   solution: 226
    - number of entries in reference solution: 233
    - 19 extra entries in student solution, including:
      '(40, 18) -> (40, 38)'

    - 26 missing entries in student solution, including:
      '(40, 18) -> (40, 23) -> (40, 36) -> (40, 38) -> (40, 49)'


    - failed on trial 1 of 10

==> FAILED

Test 12: m*n points on an m-by-n grid
  * 3-by-3 grid
  * 4-by-4 grid
    - number of entries in student   solution: 6
    - number of entries in reference solution: 10
    - 4 missing entries in student solution, including:
      '(3, 0) -> (3, 1) -> (3, 2) -> (3, 3)'


  * 5-by-5 grid
    - segments() contains a subsegment of a segment in reference solution
    - student   segment 2: (0, 0) -> (0, 3)
    - reference segment 11: (0, 0) -> (0, 1) -> (0, 2) -> (0, 3) -> (0, 4)

    - number of entries in student   solution: 16
    - number of entries in reference solution: 16
    - 5 extra entries in student solution, including:
      '(4, 0) -> (4, 3)'

    - 5 missing entries in student solution, including:
      '(4, 0) -> (4, 1) -> (4, 2) -> (4, 3) -> (4, 4)'


  * 10-by-10 grid
    - segments() contains a subsegment of a segment in reference solution
    - student   segment 8: (0, 0) -> (0, 8)
    - reference segment 144: (0, 0) -> (0, 1) -> (0, 2) -> (0, 3) -> (0, 4) -> (0, 5) -> (0, 6) -> (0, 7) -> (0, 8) -> (0, 9)

    - number of entries in student   solution: 154
    - number of entries in reference solution: 154
    - 10 extra entries in student solution, including:
      '(9, 0) -> (9, 8)'

    - 10 missing entries in student solution, including:
      '(9, 0) -> (9, 1) -> (9, 2) -> (9, 3) -> (9, 4) -> (9, 5) -> (9, 6) -> (9, 7) -> (9, 8) -> (9, 9)'


  * 20-by-20 grid
    - segments() contains a subsegment of a segment in reference solution
    - student   segment 24: (0, 0) -> (0, 18)
    - reference segment 2426: (0, 0) -> (0, 1) -> (0, 2) -> (0, 3) -> (0, 4) -> (0, 5) -> (0, 6) -> (0, 7) -> (0, 8) -> (0, 9) -> (0, 10) -> (0, 11) -> (0, 12) -> (0, 13) -> (0, 14) -> (0, 15) -> (0, 16) -> (0, 17) -> (0, 18) -> (0, 19)

    - number of entries in student   solution: 2446
    - number of entries in reference solution: 2446
    - 20 extra entries in student solution, including:
      '(19, 0) -> (19, 18)'

    - 20 missing entries in student solution, including:
      '(19, 0) -> (19, 1) -> (19, 2) -> (19, 3) -> (19, 4) -> (19, 5) -> (19, 6) -> (19, 7) -> (19, 8) -> (19, 9) -> (19, 10) -> (19, 11) -> (19, 12) -> (19, 13) -> (19, 14) -> (19, 15) -> (19, 16) -> (19, 17) -> (19, 18) -> (19, 19)'


  * 5-by-4 grid
    - number of entries in student   solution: 8
    - number of entries in reference solution: 13
    - 5 missing entries in student solution, including:
      '(4, 0) -> (4, 1) -> (4, 2) -> (4, 3)'


  * 6-by-4 grid
    - number of entries in student   solution: 10
    - number of entries in reference solution: 16
    - 6 missing entries in student solution, including:
      '(5, 0) -> (5, 1) -> (5, 2) -> (5, 3)'


  * 10-by-4 grid
    - number of entries in student   solution: 28
    - number of entries in reference solution: 38
    - 10 missing entries in student solution, including:
      '(9, 0) -> (9, 1) -> (9, 2) -> (9, 3)'


  * 15-by-4 grid
    - number of entries in student   solution: 64
    - number of entries in reference solution: 79
    - 15 missing entries in student solution, including:
      '(14, 0) -> (14, 1) -> (14, 2) -> (14, 3)'


  * 25-by-4 grid
    - number of entries in student   solution: 188
    - number of entries in reference solution: 213
    - 25 missing entries in student solution, including:
      '(24, 0) -> (24, 1) -> (24, 2) -> (24, 3)'


==> FAILED

Test 13: check that data type is immutable by testing whether each method
         returns the same value, regardless of any intervening operations
  * input8.txt
  * equidistant.txt
==> passed

Test 14: check that data type does not mutate the constructor argument
  * input8.txt
  * equidistant.txt
==> passed

Test 15: numberOfSegments() is consistent with segments()
  * filename = input8.txt
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
  * filename = horizontal5.txt
  * filename = vertical5.txt
  * filename = random23.txt
==> passed

Test 16: throws an exception if either constructor argument is null
         or any entry in array is null
  * argument is null
  * Point[] of length 10, number of null entries = 1
  * Point[] of length 10, number of null entries = 10
  * Point[] of length 4, number of null entries = 1
  * Point[] of length 3, number of null entries = 1
  * Point[] of length 2, number of null entries = 1
  * Point[] of length 1, number of null entries = 1
==> passed

Test 17: check that the constructor throws an exception if duplicate points
  * 50 points
    - failed on trial 1 of 5
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points


  * 25 points
    - failed on trial 1 of 10
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points


  * 5 points
    - failed on trial 3 of 100
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points

     5
     21452 24039
      5914 27240
      1635  1820
     22829  1277
     21452 24039

  * 4 points
    - failed on trial 1 of 100
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points

     4
     28065  4949
     17114 14099
     28065  4949
     30045 25155

  * 3 points
    - failed on trial 2 of 100
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points

     3
      1451 21258
      9620  8769
      1451 21258

  * 2 points
==> FAILED


Total: 8/21 tests passed!


================================================================
********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of Point
*-----------------------------------------------------------
Running 1 total tests.

The maximum amount of memory per Point object is 32 bytes.

Student memory = 24 bytes (passed)

Total: 1/1 tests passed!


================================================================



********************************************************************************
*  TIMING
********************************************************************************

Timing BruteCollinearPoints
*-----------------------------------------------------------
Running 10 total tests.

Test 1a-1e: Find collinear points among n random distinct points


                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    16   0.00         680           0            680                   60
=> passed    32   0.00        5456           0           5456                  154
=> passed    64   0.00       43680           0          43680                  368
=> passed   128   0.01      349504           0         349504                  865
=> passed   256   0.06     2796160           0        2796160                 1979
==> 5/5 tests passed

Test 2a-2e: Find collinear points among n/4 arbitrary line segments


                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    16   0.00         765           0            765                   62
=> passed    32   0.00        5884           0           5884                  154
=> passed    64   0.00       45237           0          45237                  375
=> passed   128   0.01      355785           0         355785                  867
=> passed   256   0.02     2822290           0        2822290                 1987
==> 5/5 tests passed

Total: 10/10 tests passed!


================================================================



Timing FastCollinearPoints
*-----------------------------------------------------------
Running 31 total tests.

Test 1a-1g: Find collinear points among n random distinct points


                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    64   0.01        7320       17676          42672                17903
=> passed   128   0.01       31000       86982         204964                87460
=> passed   256   0.03      127512      407629         942770               408761
=> passed   512   0.22      517144     1879650        4276444              1889859
=> passed  1024   0.46     2082852     8518411       19119674              8532758
=> passed  2048   1.35     8360035    37950509       84261053             38064958
==> 6/6 tests passed

lg ratio(slopeTo() + 2*compare()) = lg (84261053 / 19119674) = 2.14
=> passed

==> 7/7 tests passed

Test 2a-2g: Find collinear points among the n points on an n-by-1 grid

                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    64   0.00        3782        4566          12914                 6762
=> passed   128   0.00       15750       17406          50562                22558
=> passed   256   0.00       64262       67943         200148                79140
=> passed   512   0.01      259590      267857         795304               291391
=> passed  1024   0.03     1043462     1061948        3167358              1110676
=> passed  2048   0.09     4184070     4225064       12634198              4325254
=> passed  4096   0.21    16756742    16846869       50450480             17052073
==> 7/7 tests passed

lg ratio(slopeTo() + 2*compare()) = lg (50450480 / 12634198) = 2.00
=> passed

==> 8/8 tests passed

Test 3a-3g: Find collinear points among the n points on an n/4-by-4 grid

                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    64   0.00        7816       14386          36588                16193
=> passed   128   0.00       32512       42920         118352                62521
=> passed   256   0.01      132592      147881         428354               241401
=> passed   512   0.02      535504      544828        1625160               937816
=> passed  1024   0.07     2152336     2081014        6314364              3675678
=> passed  2048   0.23     8630032     8109673       24849378             14486404
=> passed  4096   1.00    34561552    31965619       98492790             57403486
==> 7/7 tests passed

lg ratio(slopeTo() + 2*compare()) = lg (98492790 / 24849378) = 1.99
=> passed

==> 8/8 tests passed

Test 4a-4g: Find collinear points among the n points on an n/8-by-8 grid

                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    64   0.00        7984       17251          42486                18165
=> passed   128   0.00       32972       74449         181870                83597
=> passed   256   0.01      133957      229652         593261               336687
=> passed   512   0.04      539989      849527        2239043              1333875
=> passed  1024   0.12     2168260     3251178        8670616              5302526
=> passed  2048   0.43     8689671    12679845       34049361             21139587
=> passed  4096   2.00    34791942    50004769      134801480             84299786
==> 7/7 tests passed

lg ratio(slopeTo() + 2*compare()) = lg (134801480 / 34049361) = 1.99
=> passed

==> 8/8 tests passed

Total: 31/31 tests passed!


================================================================