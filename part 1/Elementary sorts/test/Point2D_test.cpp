#include <iostream>
#include <vector>
#include <cassert>
#include "../Point2D.hpp"

using namespace std;

void test_ccw(){
    Point2D p1(0, 0);
    Point2D p2(4, 4);
    Point2D p3(1, 2);
    Point2D p4(1, 1);

    assert(Point2D::ccw(p1, p2, p3) == 1);
    assert(Point2D::ccw(p3, p2, p1) == -1);
    assert(Point2D::ccw(p1, p2, p4) == 0);
    assert(Point2D::ccw(p4, p2, p1) == 0);
}


int main(){

    test_ccw();

    return 0;
}