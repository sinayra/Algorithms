See the Assessment Guide for information on how to interpret this report.

ASSESSMENT SUMMARY

Compilation:  PASSED
API:          PASSED

Spotbugs:     PASSED
PMD:          PASSED
Checkstyle:   FAILED (0 errors, 1 warning)

Correctness:  24/35 tests passed
Memory:       16/16 tests passed
Timing:       42/42 tests passed

Aggregate score: 81.14%
[Compilation: 5%, API: 5%, Spotbugs: 0%, PMD: 0%, Checkstyle: 0%, Correctness: 60%, Memory: 10%, Timing: 20%]

ASSESSMENT DETAILS

The following files were submitted:
----------------------------------
 14K Aug  2 17:44 KdTree.java
3.0K Aug  2 17:44 PointSET.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac PointSET.java
*-----------------------------------------------------------

% javac KdTree.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
PointSET:

KdTree:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS                                       
********************************************************************************


% spotbugs *.class
*-----------------------------------------------------------


================================================================


% pmd .
*-----------------------------------------------------------


================================================================


% checkstyle *.java
*-----------------------------------------------------------
[WARN] KdTree.java:121:21: Using a quadruple nested if statement suggests poor design in this program. [NestedIfDepth]
Checkstyle ends with 0 errors and 1 warning.

% custom checkstyle checks for PointSET.java
*-----------------------------------------------------------

% custom checkstyle checks for KdTree.java
*-----------------------------------------------------------


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of PointSET
*-----------------------------------------------------------
Running 8 total tests.

A point in an m-by-m grid means that it is of the form (i/m, j/m),
where i and j are integers between 0 and m

Test 1: insert n random points; check size() and isEmpty() after each insertion
        (size may be less than n because of duplicates)
  * 5 random points in a 1-by-1 grid
  * 50 random points in a 8-by-8 grid
  * 100 random points in a 16-by-16 grid
  * 1000 random points in a 128-by-128 grid
  * 5000 random points in a 1024-by-1024 grid
  * 50000 random points in a 65536-by-65536 grid
==> passed

Test 2: insert n random points; check contains() with random query points
  * 1 random points in a 1-by-1 grid
  * 10 random points in a 4-by-4 grid
  * 20 random points in a 8-by-8 grid
  * 10000 random points in a 128-by-128 grid
  * 100000 random points in a 1024-by-1024 grid
  * 100000 random points in a 65536-by-65536 grid
==> passed

Test 3: insert random points; check nearest() with random query points
  * 10 random points in a 4-by-4 grid
  * 15 random points in a 8-by-8 grid
  * 20 random points in a 16-by-16 grid
  * 100 random points in a 32-by-32 grid
  * 10000 random points in a 65536-by-65536 grid
==> passed

Test 4: insert random points; check range() with random query rectangles
  * 2 random points and random rectangles in a 2-by-2 grid
  * 10 random points and random rectangles in a 4-by-4 grid
  * 20 random points and random rectangles in a 8-by-8 grid
  * 100 random points and random rectangles in a 16-by-16 grid
  * 1000 random points and random rectangles in a 64-by-64 grid
  * 10000 random points and random rectangles in a 128-by-128 grid
==> passed

Test 5: call methods before inserting any points
 * size() and isEmpty()
 * contains()
 * nearest()
 * range()
==> passed

Test 6: call methods with null argument
  * insert()
  * contains()
  * range()
  * nearest()
==> passed

Test 7: check intermixed sequence of calls to insert(), isEmpty(),
        size(), contains(), range(), and nearest() with
        probabilities (p1, p2, p3, p4, p5, p6, p7), respectively
  * 10000 calls with random points in a 1-by-1 grid
    and probabilities (0.3, 0.1, 0.1, 0.1, 0.2, 0.2)
  * 10000 calls with random points in a 16-by-16 grid
    and probabilities (0.3, 0.1, 0.1, 0.1, 0.2, 0.2)
  * 10000 calls with random points in a 128-by-128 grid
    and probabilities (0.3, 0.1, 0.1, 0.1, 0.2, 0.2)
  * 10000 calls with random points in a 1024-by-1024 grid
    and probabilities (0.3, 0.1, 0.1, 0.1, 0.2, 0.2)
  * 10000 calls with random points in a 8192-by-8192 grid
    and probabilities (0.3, 0.1, 0.1, 0.1, 0.2, 0.2)
  * 10000 calls with random points in a 65536-by-65536 grid
    and probabilities (0.3, 0.1, 0.1, 0.1, 0.2, 0.2)
==> passed

Test 8: check that two PointSET objects can be created at the same time
==> passed


Total: 8/8 tests passed!


================================================================
Testing correctness of KdTree
*-----------------------------------------------------------
Running 27 total tests.

In the tests below, we consider three classes of points and rectangles.

  * Non-degenerate points: no two points (or rectangles) share either an
                           x-coordinate or a y-coordinate

  * Distinct points:       no two points (or rectangles) share both an
                           x-coordinate and a y-coordinate

  * General points:        no restrictions on the x-coordinates or y-coordinates
                           of the points (or rectangles)

A point in an m-by-m grid means that it is of the form (i/m, j/m),
where i and j are integers between 0 and m (inclusive).

Test 1a: insert points from file; check size() and isEmpty() after each insertion
  * input0.txt
  * input1.txt
  * input5.txt
  * input10.txt
==> passed

Test 1b: insert non-degenerate points; check size() and isEmpty() after each insertion
  * 1 random non-degenerate points in a 1-by-1 grid
  * 5 random non-degenerate points in a 8-by-8 grid
  * 10 random non-degenerate points in a 16-by-16 grid
  * 50 random non-degenerate points in a 128-by-128 grid
  * 500 random non-degenerate points in a 1024-by-1024 grid
  * 50000 random non-degenerate points in a 65536-by-65536 grid
==> passed

Test 1c: insert distinct points; check size() and isEmpty() after each insertion
  * 1 random distinct points in a 1-by-1 grid
  * 10 random distinct points in a 8-by-8 grid
  * 20 random distinct points in a 16-by-16 grid
  * 10000 random distinct points in a 128-by-128 grid
  * 100000 random distinct points in a 1024-by-1024 grid
  * 100000 random distinct points in a 65536-by-65536 grid
==> passed

Test 1d: insert general points; check size() and isEmpty() after each insertion
  * 5 random general points in a 1-by-1 grid
  * 10 random general points in a 4-by-4 grid
  * 50 random general points in a 8-by-8 grid
  * 100000 random general points in a 16-by-16 grid
  * 100000 random general points in a 128-by-128 grid
  * 100000 random general points in a 1024-by-1024 grid
==> passed

Test 2a: insert points from file; check contains() with random query points
  * input0.txt
  * input1.txt
  * input5.txt
  * input10.txt
==> passed

Test 2b: insert non-degenerate points; check contains() with random query points
  * 1 random non-degenerate points in a 1-by-1 grid
  * 5 random non-degenerate points in a 8-by-8 grid
  * 10 random non-degenerate points in a 16-by-16 grid
  * 20 random non-degenerate points in a 32-by-32 grid
  * 500 random non-degenerate points in a 1024-by-1024 grid
  * 10000 random non-degenerate points in a 65536-by-65536 grid
==> passed

Test 2c: insert distinct points; check contains() with random query points
  * 1 random distinct points in a 1-by-1 grid
  * 10 random distinct points in a 4-by-4 grid
  * 20 random distinct points in a 8-by-8 grid
  * 10000 random distinct points in a 128-by-128 grid
  * 100000 random distinct points in a 1024-by-1024 grid
  * 100000 random distinct points in a 65536-by-65536 grid
==> passed

Test 2d: insert general points; check contains() with random query points
  * 10000 random general points in a 1-by-1 grid
  * 10000 random general points in a 16-by-16 grid
  * 10000 random general points in a 128-by-128 grid
  * 10000 random general points in a 1024-by-1024 grid
==> passed

Test 3a: insert points from file; check range() with random query rectangles
  * input0.txt

    java.lang.NullPointerException

    KdTree.range(KdTree.java:235)
    TestKdTree.checkRange(TestKdTree.java:576)
    TestKdTree.checkRange(TestKdTree.java:529)
    TestKdTree.test3a(TestKdTree.java:1675)
    TestKdTree.main(TestKdTree.java:1953)

  * input1.txt
  * input5.txt
  * input10.txt
==> FAILED

Test 3b: insert non-degenerate points; check range() with random query rectangles
  * 1 random non-degenerate points and random rectangles in a 2-by-2 grid
  * 5 random non-degenerate points and random rectangles in a 8-by-8 grid
  * 10 random non-degenerate points and random rectangles in a 16-by-16 grid
  * 20 random non-degenerate points and random rectangles in a 32-by-32 grid
  * 500 random non-degenerate points and random rectangles in a 1024-by-1024 grid
  * 10000 random non-degenerate points and random rectangles in a 65536-by-65536 grid
==> passed

Test 3c: insert distinct points; check range() with random query rectangles
  * 2 random distinct points and random rectangles in a 2-by-2 grid
  * 10 random distinct points and random rectangles in a 4-by-4 grid
  * 20 random distinct points and random rectangles in a 8-by-8 grid
  * 100 random distinct points and random rectangles in a 16-by-16 grid
  * 1000 random distinct points and random rectangles in a 64-by-64 grid
  * 10000 random distinct points and random rectangles in a 128-by-128 grid
==> passed

Test 3d: insert general points; check range() with random query rectangles
  * 5000 random general points and random rectangles in a 2-by-2 grid
  * 5000 random general points and random rectangles in a 16-by-16 grid
  * 5000 random general points and random rectangles in a 128-by-128 grid
  * 5000 random general points and random rectangles in a 1024-by-1024 grid
==> passed

Test 3e: insert random points; check range() with tiny rectangles
         enclosing each point
  * 5 tiny rectangles and 5 general points in a 2-by-2 grid
  * 10 tiny rectangles and 10 general points in a 4-by-4 grid
  * 20 tiny rectangles and 20 general points in a 8-by-8 grid
  * 5000 tiny rectangles and 5000 general points in a 128-by-128 grid
  * 5000 tiny rectangles and 5000 general points in a 1024-by-1024 grid
  * 5000 tiny rectangles and 5000 general points in a 65536-by-65536 grid
==> passed

Test 4a: insert points from file; check range() with random query rectangles
         and check traversal of kd-tree
  * input5.txt
  * input10.txt
==> passed

Test 4b: insert non-degenerate points; check range() with random query rectangles
         and check traversal of kd-tree
  * 3 random non-degenerate points and 1000 random rectangles in a 4-by-4 grid
  * 6 random non-degenerate points and 1000 random rectangles in a 8-by-8 grid
  * 10 random non-degenerate points and 1000 random rectangles in a 16-by-16 grid
  * 20 random non-degenerate points and 1000 random rectangles in a 32-by-32 grid
  * 30 random non-degenerate points and 1000 random rectangles in a 64-by-64 grid
==> passed

Test 5a: insert points from file; check nearest() with random query points
  * input0.txt
  * input1.txt
  * input5.txt
    - failed on trial 7 of 10000
    - sequence of points inserted: 
      A  0.7 0.2
      B  0.5 0.4
      C  0.2 0.3
      D  0.4 0.7
      E  0.9 0.6
    - query point                   = (0.07, 0.522)
    - student   nearest()           = (0.4, 0.7)
    - reference nearest()           = (0.2, 0.3)
    - student   distanceSquaredTo() = 0.140584
    - reference distanceSquaredTo() = 0.066184

  * input10.txt
    - failed on trial 2 of 10000
    - sequence of points inserted: 
      A  0.372 0.497
      B  0.564 0.413
      C  0.226 0.577
      D  0.144 0.179
      E  0.083 0.51
      F  0.32 0.708
      G  0.417 0.362
      H  0.862 0.825
      I  0.785 0.725
      J  0.499 0.208
    - query point                   = (0.508, 0.895)
    - student   nearest()           = (0.785, 0.725)
    - reference nearest()           = (0.32, 0.708)
    - student   distanceSquaredTo() = 0.105629
    - reference distanceSquaredTo() = 0.070313

==> FAILED

Test 5b: insert non-degenerate points; check nearest() with random query points
  * 5 random non-degenerate points in a 8-by-8 grid
    - failed on trial 16 of 10000
    - sequence of points inserted: 
      A  0.0 0.875
      B  0.125 0.375
      C  1.0 0.125
      D  0.625 1.0
      E  0.375 0.5
    - query point                   = (0.5, 0.25)
    - student   nearest()           = (0.125, 0.375)
    - reference nearest()           = (0.375, 0.5)
    - student   distanceSquaredTo() = 0.15625
    - reference distanceSquaredTo() = 0.078125

  * 10 random non-degenerate points in a 16-by-16 grid
    - failed on trial 39 of 10000
    - sequence of points inserted: 
      A  0.6875 0.1875
      B  1.0 0.0
      C  0.875 0.875
      D  0.75 0.9375
      E  0.625 0.0625
      F  0.5625 0.125
      G  0.3125 0.8125
      H  0.4375 0.625
      I  0.0625 0.25
      J  0.25 0.5625
    - query point                   = (0.5, 1.0)
    - student   nearest()           = (0.3125, 0.8125)
    - reference nearest()           = (0.75, 0.9375)
    - student   distanceSquaredTo() = 0.0703125
    - reference distanceSquaredTo() = 0.06640625

  * 20 random non-degenerate points in a 32-by-32 grid
    - failed on trial 3 of 10000
    - sequence of points inserted: 
      A  0.65625 0.5
      B  0.34375 0.9375
      C  0.25 0.875
      D  0.75 0.40625
      E  0.6875 0.375
      F  0.90625 0.6875
      G  1.0 0.59375
      H  0.46875 0.4375
      I  0.78125 0.75
      J  0.1875 0.90625
      K  0.59375 0.1875
      L  0.53125 0.03125
      M  0.71875 0.625
      N  0.28125 0.0
      O  0.9375 0.78125
      P  0.0 0.5625
      Q  0.8125 0.28125
      R  0.3125 0.46875
      S  0.0625 0.84375
      T  0.5 0.0625
    - query point                   = (0.15625, 0.21875)
    - student   nearest()           = (0.0, 0.5625)
    - reference nearest()           = (0.28125, 0.0)
    - student   distanceSquaredTo() = 0.142578125
    - reference distanceSquaredTo() = 0.0634765625

  * 30 random non-degenerate points in a 64-by-64 grid
    - failed on trial 2 of 10000
    - query point                   = (0.578125, 0.984375)
    - student   nearest()           = (0.484375, 0.96875)
    - reference nearest()           = (0.5625, 0.921875)
    - student   distanceSquaredTo() = 0.009033203125
    - reference distanceSquaredTo() = 0.004150390625

  * 10000 random non-degenerate points in a 65536-by-65536 grid
    - failed on trial 2 of 10000
    - query point                   = (0.7952728271484375, 0.203125)
    - student   nearest()           = (0.8060150146484375, 0.19580078125)
    - reference nearest()           = (0.7989044189453125, 0.194732666015625)
    - student   distanceSquaredTo() = 0.000169038772583
    - reference distanceSquaredTo() = 0.000083619728684

==> FAILED

Test 5c: insert distinct points; check nearest() with random query points
  * 10 random distinct points in a 4-by-4 grid
    - failed on trial 26 of 10000
    - sequence of points inserted: 
      A  0.75 1.0
      B  0.0 0.5
      C  0.25 0.25
      D  0.5 0.0
      E  0.75 0.25
      F  1.0 0.25
      G  0.75 0.75
      H  0.5 0.5
      I  1.0 0.75
      J  0.0 0.0
    - query point                   = (1.0, 0.0)
    - student   nearest()           = (0.75, 0.25)
    - reference nearest()           = (1.0, 0.25)
    - student   distanceSquaredTo() = 0.125
    - reference distanceSquaredTo() = 0.0625

  * 15 random distinct points in a 8-by-8 grid
    - failed on trial 4 of 10000
    - sequence of points inserted: 
      A  1.0 1.0
      B  0.375 0.125
      C  0.375 0.875
      D  0.125 0.25
      E  0.125 1.0
      F  1.0 0.5
      G  0.5 0.625
      H  0.375 0.5
      I  1.0 0.25
      J  1.0 0.625
      K  1.0 0.125
      L  0.125 0.875
      M  0.5 1.0
      N  0.0 0.25
      O  0.875 0.125
    - query point                   = (0.875, 0.0)
    - student   nearest()           = (0.375, 0.125)
    - reference nearest()           = (0.875, 0.125)
    - student   distanceSquaredTo() = 0.265625
    - reference distanceSquaredTo() = 0.015625

  * 20 random distinct points in a 16-by-16 grid
    - failed on trial 3 of 10000
    - sequence of points inserted: 
      A  0.5 0.9375
      B  0.0 0.0
      C  0.5 0.0625
      D  0.0625 0.6875
      E  0.3125 0.0625
      F  0.0 1.0
      G  0.25 0.8125
      H  0.75 0.375
      I  0.125 0.625
      J  0.25 0.625
      K  0.6875 0.0
      L  0.4375 0.6875
      M  0.9375 0.3125
      N  0.5625 0.5
      O  1.0 0.875
      P  1.0 0.75
      Q  0.5 0.875
      R  0.875 1.0
      S  0.8125 0.8125
      T  0.125 0.1875
    - query point                   = (0.875, 0.0625)
    - student   nearest()           = (0.9375, 0.3125)
    - reference nearest()           = (0.6875, 0.0)
    - student   distanceSquaredTo() = 0.06640625
    - reference distanceSquaredTo() = 0.0390625

  * 100 random distinct points in a 32-by-32 grid
    - failed on trial 12 of 10000
    - query point                   = (0.75, 0.59375)
    - student   nearest()           = (0.8125, 0.6875)
    - reference nearest()           = (0.78125, 0.6875)
    - student   distanceSquaredTo() = 0.0126953125
    - reference distanceSquaredTo() = 0.009765625

  * 10000 random distinct points in a 65536-by-65536 grid
    - failed on trial 1 of 10000
    - query point                   = (0.2274169921875, 0.2689361572265625)
    - student   nearest()           = (0.2404022216796875, 0.2662353515625)
    - reference nearest()           = (0.228729248046875, 0.2730865478515625)
    - student   distanceSquaredTo() = 0.0001759105362
    - reference distanceSquaredTo() = 0.000018947757781

==> FAILED

Test 5d: insert general points; check nearest() with random query points
  * 10000 random general points in a 16-by-16 grid
  * 10000 random general points in a 128-by-128 grid
    - failed on trial 4 of 10000
    - query point                   = (0.7734375, 0.0078125)
    - student   nearest()           = (0.78125, 0.015625)
    - reference nearest()           = (0.7734375, 0.0)
    - student   distanceSquaredTo() = 0.0001220703125
    - reference distanceSquaredTo() = 0.00006103515625

  * 10000 random general points in a 1024-by-1024 grid
    - failed on trial 1 of 10000
    - query point                   = (0.8212890625, 0.013671875)
    - student   nearest()           = (0.814453125, 0.0068359375)
    - reference nearest()           = (0.81640625, 0.0146484375)
    - student   distanceSquaredTo() = 0.000093460083008
    - reference distanceSquaredTo() = 0.000024795532227

==> FAILED

Test 6a: insert points from file; check nearest() with random query points
         and check traversal of kd-tree
  * input5.txt
    - student   nearest() = (0.4, 0.7)
    - reference nearest() = (0.4, 0.7)
    - performs incorrect traversal of kd-tree during call to nearest()
    - query point = (0.62, 0.95)
    - sequence of points inserted: 
      A  0.7 0.2
      B  0.5 0.4
      C  0.2 0.3
      D  0.4 0.7
      E  0.9 0.6
    - student sequence of kd-tree nodes involved in calls to Point2D methods:
      A B D 
    - reference sequence of kd-tree nodes involved in calls to Point2D methods:
      A B D E 
    - failed on trial 2 of 1000

  * input10.txt
    - student   nearest() = (0.32, 0.708)
    - reference nearest() = (0.32, 0.708)
    - performs incorrect traversal of kd-tree during call to nearest()
    - query point = (0.22, 0.89)
    - sequence of points inserted: 
      A  0.372 0.497
      B  0.564 0.413
      C  0.226 0.577
      D  0.144 0.179
      E  0.083 0.51
      F  0.32 0.708
      G  0.417 0.362
      H  0.862 0.825
      I  0.785 0.725
      J  0.499 0.208
    - student sequence of kd-tree nodes involved in calls to Point2D methods:
      A C F 
    - reference sequence of kd-tree nodes involved in calls to Point2D methods:
      A C F B H I 
    - failed on trial 2 of 1000

==> FAILED

Test 6b: insert non-degenerate points; check nearest() with random query points
         and check traversal of kd-tree
  * 5 random non-degenerate points in a 8-by-8 grid
    - student   nearest() = (0.5, 0.375)
    - reference nearest() = (0.5, 0.375)
    - performs incorrect traversal of kd-tree during call to nearest()
    - query point = (0.75, 0.75)
    - sequence of points inserted: 
      A  0.0 0.625
      B  1.0 0.0
      C  0.25 0.5
      D  0.5 0.375
      E  0.625 0.25
    - student sequence of kd-tree nodes involved in calls to Point2D methods:
      A B C D 
    - reference sequence of kd-tree nodes involved in calls to Point2D methods:
      A B C D E 
    - failed on trial 1 of 1000

  * 10 random non-degenerate points in a 16-by-16 grid
    - student   nearest() = (0.0, 0.3125)
    - reference nearest() = (0.0, 0.3125)
    - performs incorrect traversal of kd-tree during call to nearest()
    - query point = (0.0625, 0.125)
    - sequence of points inserted: 
      A  0.5 0.4375
      B  0.1875 0.5625
      C  0.9375 0.8125
      D  0.6875 0.5
      E  0.25 0.0
      F  0.75 0.1875
      G  1.0 0.75
      H  0.4375 0.375
      I  0.875 0.875
      J  0.0 0.3125
    - student sequence of kd-tree nodes involved in calls to Point2D methods:
      A B E J 
    - reference sequence of kd-tree nodes involved in calls to Point2D methods:
      A B E J H 
    - failed on trial 2 of 1000

  * 20 random non-degenerate points in a 32-by-32 grid
    - student   nearest() = (0.3125, 0.3125)
    - reference nearest() = (0.3125, 0.3125)
    - performs incorrect traversal of kd-tree during call to nearest()
    - query point = (0.375, 0.25)
    - sequence of points inserted: 
      A  0.78125 1.0
      B  0.53125 0.4375
      C  0.8125 0.40625
      D  0.3125 0.3125
      E  0.6875 0.46875
      F  0.09375 0.15625
      G  0.28125 0.6875
      H  0.625 0.03125
      I  0.5 0.78125
      J  0.4375 0.59375
      K  0.96875 0.28125
      L  0.90625 0.0625
      M  0.75 0.53125
      N  0.0 0.71875
      O  0.65625 0.5625
      P  0.40625 0.65625
      Q  0.125 0.84375
      R  0.03125 0.5
      S  0.84375 0.875
      T  0.875 0.34375
    - student sequence of kd-tree nodes involved in calls to Point2D methods:
      A B D H 
    - reference sequence of kd-tree nodes involved in calls to Point2D methods:
      A B D H F 
    - failed on trial 3 of 1000

  * 30 random non-degenerate points in a 64-by-64 grid
    - student   nearest() = (0.84375, 0.3125)
    - reference nearest() = (0.84375, 0.3125)
    - performs incorrect traversal of kd-tree during call to nearest()
    - number of student   entries = 6
    - number of reference entries = 8
    - failed on trial 1 of 1000

  * 50 random non-degenerate points in a 128-by-128 grid
    - student   nearest() = (0.5703125, 0.40625)
    - reference nearest() = (0.5703125, 0.40625)
    - performs incorrect traversal of kd-tree during call to nearest()
    - number of student   entries = 10
    - number of reference entries = 12
    - failed on trial 2 of 1000

  * 1000 random non-degenerate points in a 2048-by-2048 grid
    - student   nearest() = (0.77880859375, 0.16845703125)
    - reference nearest() = (0.77880859375, 0.16845703125)
    - performs incorrect traversal of kd-tree during call to nearest()
    - number of student   entries = 10
    - number of reference entries = 22
    - failed on trial 1 of 1000

==> FAILED

Test 7: check with no points
  * size() and isEmpty()
  * contains()
  * nearest()
  * range()

    java.lang.NullPointerException

    KdTree.range(KdTree.java:235)
    TestKdTree.checkRange(TestKdTree.java:576)
    TestKdTree.checkRange(TestKdTree.java:518)
    TestKdTree.test7(TestKdTree.java:1833)
    TestKdTree.main(TestKdTree.java:1992)

==> FAILED

Test 8: check that the specified exception is thrown with null arguments
  * argument to insert() is null
  * argument to contains() is null
  * argument to range() is null
  * argument to nearest() is null
==> passed

Test 9a: check intermixed sequence of calls to insert(), isEmpty(),
         size(), contains(), range(), and nearest() with probabilities
         (p1, p2, p3, p4, p5, p6), respectively
  * 20000 calls with non-degenerate points in a 1-by-1 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with non-degenerate points in a 16-by-16 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 24 of 20000
    - student   nearest()  = (0.125, 0.75)
    - reference nearest()  = (0.375, 0.0625)
    - student   distanceSquaredTo() = 0.265625
    - reference distanceSquaredTo() = 0.17578125
    - sequence of operations was:
           st.insert(0.25, 0.875)
           st.contains((0.125, 0.125))  ==>  false
           st.nearest((0.4375, 0.0))   ==>  (0.25, 0.875)
           st.size()  ==>  1
           st.contains((0.75, 0.625))  ==>  false
           st.nearest((0.5625, 0.6875))   ==>  (0.25, 0.875)
           st.contains((0.375, 0.3125))  ==>  false
           st.range([0.0, 0.9375] x [0.125, 0.3125])  ==>  empty
           st.range([0.375, 0.5] x [0.0625, 0.8125])  ==>  empty
           st.contains((0.75, 0.25))  ==>  false
           st.size()  ==>  1
           st.insert(0.625, 0.3125)
           st.range([0.375, 0.4375] x [0.75, 0.9375])  ==>  empty
           st.insert(0.75, 0.5625)
           st.insert(0.5, 0.375)
           st.insert(0.125, 0.75)
           st.size()  ==>  5
           st.insert(0.8125, 0.5)
           st.size()  ==>  6
           st.insert(0.375, 0.0625)
           st.isEmpty()  ==>  false
           st.size()  ==>  7
           st.insert(0.6875, 0.8125)
           st.nearest((0.0, 0.25))   ==>  (0.125, 0.75)

  * 20000 calls with non-degenerate points in a 128-by-128 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 43 of 20000
    - student   nearest()  = (0.1328125, 0.515625)
    - reference nearest()  = (0.359375, 0.4140625)
    - student   distanceSquaredTo() = 0.0382080078125
    - reference distanceSquaredTo() = 0.012939453125

  * 20000 calls with non-degenerate points in a 1024-by-1024 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 57 of 20000
    - student   nearest()  = (0.8466796875, 0.6259765625)
    - reference nearest()  = (0.8369140625, 0.3583984375)
    - student   distanceSquaredTo() = 0.033851623535156
    - reference distanceSquaredTo() = 0.029327392578125

  * 20000 calls with non-degenerate points in a 8192-by-8192 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 91 of 20000
    - student   nearest()  = (0.789794921875, 0.60107421875)
    - reference nearest()  = (0.786376953125, 0.3028564453125)
    - student   distanceSquaredTo() = 0.046962052583694
    - reference distanceSquaredTo() = 0.039096489548683

  * 20000 calls with non-degenerate points in a 65536-by-65536 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 34 of 20000
    - student   nearest()  = (0.0428314208984375, 0.3356475830078125)
    - reference nearest()  = (0.5842742919921875, 0.917083740234375)
    - student   distanceSquaredTo() = 0.347542990930378
    - reference distanceSquaredTo() = 0.322707033948973

==> FAILED

Test 9b: check intermixed sequence of calls to insert(), isEmpty(),
         size(), contains(), range(), and nearest() with probabilities
         (p1, p2, p3, p4, p5, p6), respectively
  * 20000 calls with distinct points in a 1-by-1 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with distinct points in a 16-by-16 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 42 of 20000
    - student   nearest()  = (0.625, 0.125)
    - reference nearest()  = (0.875, 0.1875)
    - student   distanceSquaredTo() = 0.078125
    - reference distanceSquaredTo() = 0.03515625

  * 20000 calls with distinct points in a 128-by-128 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 17 of 20000
    - student   nearest()  = (0.4375, 0.2734375)
    - reference nearest()  = (0.640625, 0.421875)
    - student   distanceSquaredTo() = 0.09674072265625
    - reference distanceSquaredTo() = 0.0548095703125
    - sequence of operations was:
           st.insert(0.0390625, 0.671875)
           st.nearest((0.484375, 0.7734375))   ==>  (0.0390625, 0.671875)
           st.contains((0.296875, 0.6015625))  ==>  false
           st.insert(0.4375, 0.2734375)
           st.size()  ==>  2
           st.range([0.28125, 0.8203125] x [0.1953125, 0.2578125])  ==>  empty
           st.range([0.2578125, 0.296875] x [0.21875, 0.3671875])  ==>  empty
           st.nearest((0.5234375, 0.1875))   ==>  (0.4375, 0.2734375)
           st.contains((0.28125, 0.3984375))  ==>  false
           st.insert(0.640625, 0.421875)
           st.contains((0.6015625, 0.125))  ==>  false
           st.insert(0.0859375, 0.359375)
           st.insert(0.0859375, 0.0625)
           st.contains((0.4921875, 0.234375))  ==>  false
           st.contains((0.359375, 0.1953125))  ==>  false
           st.range([0.3984375, 0.4375] x [0.484375, 0.53125])  ==>  empty
           st.nearest((0.7421875, 0.2109375))   ==>  (0.4375, 0.2734375)

  * 20000 calls with distinct points in a 1024-by-1024 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 48 of 20000
    - student   nearest()  = (0.3369140625, 0.7216796875)
    - reference nearest()  = (0.06640625, 0.6650390625)
    - student   distanceSquaredTo() = 0.03447437286377
    - reference distanceSquaredTo() = 0.020784378051758

  * 20000 calls with distinct points in a 8192-by-8192 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 70 of 20000
    - student   nearest()  = (0.91162109375, 0.55322265625)
    - reference nearest()  = (0.518798828125, 0.3651123046875)
    - student   distanceSquaredTo() = 0.109949231147766
    - reference distanceSquaredTo() = 0.012648954987526

  * 20000 calls with distinct points in a 65536-by-65536 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 26 of 20000
    - student   nearest()  = (0.7827301025390625, 0.6215362548828125)
    - reference nearest()  = (0.3484039306640625, 0.125457763671875)
    - student   distanceSquaredTo() = 0.318949644453824
    - reference distanceSquaredTo() = 0.099635898368433
    - sequence of operations was:
           st.insert(0.641632080078125, 0.7045440673828125)
           st.contains((0.097930908203125, 0.3770599365234375))  ==>  false
           st.contains((0.6982574462890625, 0.6330108642578125))  ==>  false
           st.isEmpty()  ==>  false
           st.insert(0.5520477294921875, 0.606781005859375)
           st.nearest((0.1919708251953125, 0.0255584716796875))   ==>  (0.5520477294921875, 0.606781005859375)
           st.insert(0.150054931640625, 0.06494140625)
           st.contains((0.6147003173828125, 0.209381103515625))  ==>  false
           st.contains((0.9445343017578125, 0.14105224609375))  ==>  false
           st.range([0.354278564453125, 0.4331817626953125] x [0.2452239990234375, 0.8290252685546875])  ==>  empty
           st.insert(0.7827301025390625, 0.6215362548828125)
           st.range([0.597259521484375, 0.8629608154296875] x [0.1728057861328125, 0.228271484375])  ==>  empty
           st.contains((0.552337646484375, 0.7649993896484375))  ==>  false
           st.insert(0.3484039306640625, 0.125457763671875)
           st.nearest((0.6328125, 0.933685302734375))   ==>  (0.641632080078125, 0.7045440673828125)
           st.contains((0.9517364501953125, 0.2073211669921875))  ==>  false
           st.insert(0.08062744140625, 0.094268798828125)
           st.nearest((0.484710693359375, 0.9921722412109375))   ==>  (0.641632080078125, 0.7045440673828125)
           st.nearest((0.95947265625, 0.0391998291015625))   ==>  (0.7827301025390625, 0.6215362548828125)
           st.range([0.564971923828125, 0.936553955078125] x [0.0497894287109375, 0.103759765625])  ==>  empty
           st.insert(0.391754150390625, 0.26910400390625)
           st.size()  ==>  7
           st.insert(0.1612396240234375, 0.3118133544921875)
           st.contains((0.3069000244140625, 0.1436004638671875))  ==>  false
           st.insert(0.2111968994140625, 0.0216522216796875)
           st.nearest((0.6592254638671875, 0.0704498291015625))   ==>  (0.7827301025390625, 0.6215362548828125)

==> FAILED

Test 9c: check intermixed sequence of calls to insert(), isEmpty(),
         size(), contains(), range(), and nearest() with probabilities
         (p1, p2, p3, p4, p5, p6), respectively
  * 20000 calls with general points in a 1-by-1 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with general points in a 16-by-16 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 22 of 20000
    - student   nearest()  = (0.875, 0.75)
    - reference nearest()  = (0.8125, 0.0)
    - student   distanceSquaredTo() = 0.265625
    - reference distanceSquaredTo() = 0.09765625
    - sequence of operations was:
           st.insert(0.875, 0.75)
           st.nearest((0.75, 0.375))   ==>  (0.875, 0.75)
           st.range([0.0625, 1.0] x [0.1875, 0.6875])  ==>  empty
           st.isEmpty()  ==>  false
           st.insert(0.0, 0.1875)
           st.size()  ==>  2
           st.insert(0.5, 0.8125)
           st.nearest((0.5, 0.875))   ==>  (0.5, 0.8125)
           st.range([0.125, 0.9375] x [0.0625, 0.125])  ==>  empty
           st.range([0.25, 0.4375] x [0.125, 0.5625])  ==>  empty
           st.size()  ==>  3
           st.nearest((0.8125, 1.0))   ==>  (0.875, 0.75)
           st.insert(0.25, 0.5625)
           st.contains((0.5625, 0.0625))  ==>  false
           st.contains((0.5625, 1.0))  ==>  false
           st.range([0.375, 0.9375] x [0.3125, 0.5625])  ==>  empty
           st.nearest((1.0, 0.25))   ==>  (0.875, 0.75)
           st.insert(0.8125, 0.0)
           st.range([0.0625, 0.75] x [0.1875, 0.1875])  ==>  empty
           st.range([0.375, 0.5625] x [0.3125, 0.6875])  ==>  empty
           st.range([0.5, 0.6875] x [0.0, 0.375])  ==>  empty
           st.nearest((1.0, 0.25))   ==>  (0.875, 0.75)

  * 20000 calls with general points in a 128-by-128 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 20 of 20000
    - student   nearest()  = (0.6640625, 0.1328125)
    - reference nearest()  = (0.453125, 0.015625)
    - student   distanceSquaredTo() = 0.074462890625
    - reference distanceSquaredTo() = 0.0528564453125
    - sequence of operations was:
           st.insert(0.859375, 0.6171875)
           st.contains((0.8671875, 0.734375))  ==>  false
           st.insert(0.125, 0.0234375)
           st.contains((0.9921875, 0.0625))  ==>  false
           st.nearest((0.484375, 0.2265625))   ==>  (0.125, 0.0234375)
           st.insert(0.6640625, 0.1328125)
           st.range([0.125, 0.3046875] x [0.4765625, 0.890625])  ==>  empty
           st.nearest((0.1015625, 1.0))   ==>  (0.859375, 0.6171875)
           st.insert(0.09375, 0.5703125)
           st.isEmpty()  ==>  false
           st.range([0.5546875, 0.6875] x [0.46875, 0.4921875])  ==>  empty
           st.insert(0.8203125, 0.6484375)
           st.insert(0.453125, 0.015625)
           st.nearest((0.3125, 0.796875))   ==>  (0.09375, 0.5703125)
           st.nearest((0.234375, 0.609375))   ==>  (0.09375, 0.5703125)
           st.contains((0.046875, 0.4765625))  ==>  false
           st.isEmpty()  ==>  false
           st.insert(0.46875, 0.7578125)
           st.insert(0.6015625, 0.6640625)
           st.nearest((0.4140625, 0.2421875))   ==>  (0.6640625, 0.1328125)

  * 20000 calls with general points in a 1024-by-1024 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 45 of 20000
    - student   nearest()  = (0.7041015625, 0.765625)
    - reference nearest()  = (0.6611328125, 0.9560546875)
    - student   distanceSquaredTo() = 0.054506301879883
    - reference distanceSquaredTo() = 0.014481544494629

  * 20000 calls with general points in a 8192-by-8192 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 66 of 20000
    - student   nearest()  = (0.3065185546875, 0.83935546875)
    - reference nearest()  = (0.2557373046875, 0.85791015625)
    - student   distanceSquaredTo() = 0.011649802327156
    - reference distanceSquaredTo() = 0.010002568364143

  * 20000 calls with general points in a 65536-by-65536 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 72 of 20000
    - student   nearest()  = (0.3217315673828125, 0.26409912109375)
    - reference nearest()  = (0.186767578125, 0.3277435302734375)
    - student   distanceSquaredTo() = 0.052223537582904
    - reference distanceSquaredTo() = 0.017193868756294

==> FAILED

Test 10: insert n random points into two different KdTree objects;
        check that repeated calls to size(), contains(), range(),
        and nearest() with the same arguments yield same results
  * 10 random general points in a 4-by-4 grid
  * 20 random general points in a 8-by-8 grid
  * 100 random general points in a 128-by-128 grid
  * 1000 random general points in a 65536-by-65536 grid
==> passed


Total: 16/27 tests passed!


================================================================
********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of Point2D
*-----------------------------------------------------------
Memory of Point2D object = 32 bytes

================================================================



Analyzing memory of RectHV
*-----------------------------------------------------------
Memory of RectHV object = 48 bytes

================================================================



Analyzing memory of PointSET
*-----------------------------------------------------------
Running 8 total tests.

Memory usage of a PointSET with n points (including Point2D and RectHV objects).
Maximum allowed memory is 96n + 200 bytes.

                 n       student (bytes)    reference (bytes)
--------------------------------------------------------------
=> passed        1          264                264
=> passed        2          360                360
=> passed        5          648                648
=> passed       10         1128               1128
=> passed       25         2568               2568
=> passed      100         9768               9768
=> passed      400        38568              38568
=> passed      800        76968              76968
==> 8/8 tests passed

Total: 8/8 tests passed!

Estimated student   memory (bytes) = 96.00 n + 168.00  (R^2 = 1.000)
Estimated reference memory (bytes) = 96.00 n + 168.00  (R^2 = 1.000)

================================================================



Analyzing memory of KdTree
*-----------------------------------------------------------
Running 8 total tests.

Memory usage of a KdTree with n points (including Point2D and RectHV objects).
Maximum allowed memory is 312n + 192 bytes.

                 n       student (bytes)    reference (bytes)
--------------------------------------------------------------
=> passed        1          152                160
=> passed        2          272                288
=> passed        5          632                672
=> passed       10         1232               1312
=> passed       25         3032               3232
=> passed      100        12032              12832
=> passed      400        48032              51232
=> passed      800        96032             102432
==> 8/8 tests passed

Total: 8/8 tests passed!

Estimated student   memory (bytes) = 120.00 n + 32.00  (R^2 = 1.000)
Estimated reference memory (bytes) = 128.00 n + 32.00  (R^2 = 1.000)

================================================================



********************************************************************************
*  TIMING
********************************************************************************

Timing PointSET
*-----------------------------------------------------------
Running 14 total tests.


Inserting n points into a PointSET

               n      ops per second
----------------------------------------
=> passed   160000     983110         
=> passed   320000     893213         
=> passed   640000     828573         
=> passed  1280000     734319         
==> 4/4 tests passed

Performing contains() queries after inserting n points into a PointSET

               n      ops per second
----------------------------------------
=> passed   160000     877415         
=> passed   320000     593658         
=> passed   640000     609038         
=> passed  1280000     477016         
==> 4/4 tests passed

Performing range() queries after inserting n points into a PointSET

               n      ops per second
----------------------------------------
=> passed    10000       4529         
=> passed    20000       1629         
=> passed    40000        715         
==> 3/3 tests passed

Performing nearest() queries after inserting n points into a PointSET

               n      ops per second
----------------------------------------
=> passed    10000       6313         
=> passed    20000       1634         
=> passed    40000        839         
==> 3/3 tests passed

Total: 14/14 tests passed!


================================================================



Timing KdTree
*-----------------------------------------------------------
Running 28 total tests.


Test 1a-d: Insert n points into a 2d tree. The table gives the average number of calls
           to methods in RectHV and Point per call to insert().

                                                                                                Point2D
               n      ops per second       RectHV()           x()               y()             equals()
----------------------------------------------------------------------------------------------------------------
=> passed   160000    1318464               0.0              23.6              22.6              21.6         
=> passed   320000    1184852               0.0              24.0              23.0              22.0         
=> passed   640000     872495               0.0              25.5              24.5              23.5         
=> passed  1280000     747152               0.0              27.6              26.6              25.6         
==> 4/4 tests passed


Test 2a-h: Perform contains() queries after inserting n points into a 2d tree. The table gives
           the average number of calls to methods in RectHV and Point per call to contains().

                                                                               Point2D
               n      ops per second       x()               y()               equals()
-----------------------------------------------------------------------------------------------
=> passed    10000    1199285              18.5              17.5              18.0         
=> passed    20000    1192839              19.7              18.7              19.2         
=> passed    40000    1034251              21.8              20.8              21.3         
=> passed    80000     810231              22.0              21.0              21.5         
=> passed   160000     666686              23.2              22.2              22.7         
=> passed   320000     638018              25.0              24.0              24.5         
=> passed   640000     594704              25.7              24.7              25.2         
=> passed  1280000     447175              27.2              26.2              26.7         
==> 8/8 tests passed


Test 3a-h: Perform range() queries after inserting n points into a 2d tree. The table gives
           the average number of calls to methods in RectHV and Point per call to range().

               n      ops per second       intersects()      contains()        x()               y()
---------------------------------------------------------------------------------------------------------------
=> passed    10000     258579              62.3              31.1              81.9              42.5         
=> passed    20000     301449              65.1              32.6              85.9              48.8         
=> passed    40000     339021              78.6              39.3             103.2              52.7         
=> passed    80000     329494              81.3              40.7             106.5              55.0         
=> passed   160000     197062              85.0              42.5             113.1              63.2         
=> passed   320000     183385              80.5              40.2             105.7              55.7         
=> passed   640000     220127              86.6              43.3             113.8              62.6         
=> passed  1280000     142909              94.1              47.0             123.0              60.1         
==> 8/8 tests passed


Test 4a-h: Perform nearest() queries after inserting n points into a 2d tree. The table gives
           the average number of calls to methods in RectHV and Point per call to nearest().

                                         Point2D                 RectHV
               n      ops per second     distanceSquaredTo()     distanceSquaredTo()        x()               y()
------------------------------------------------------------------------------------------------------------------------
=> passed    10000   673401                  32.0                   33.0                    87.1              86.0         
=> passed    20000   607611                  35.4                   36.4                    95.9              95.0         
=> passed    40000   462967                  41.4                   42.4                   112.7             110.6         
=> passed    80000   434067                  42.9                   43.9                   114.9             115.1         
=> passed   160000   302013                  46.5                   47.5                   125.6             124.9         
=> passed   320000   282473                  49.1                   50.1                   132.4             131.1         
=> passed   640000   331450                  50.2                   51.2                   134.6             134.1         
=> passed  1280000   244334                  56.6                   57.6                   151.5             150.1         
==> 8/8 tests passed



Total: 28/28 tests passed!


================================================================