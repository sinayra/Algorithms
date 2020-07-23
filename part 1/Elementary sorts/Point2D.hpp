#ifndef POINT2D_HPP
#define POINT2D_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>

using namespace std;

class Point2D
{
private:
    double x, y;

public:
    Point2D(double, double);
    static int ccw(Point2D, Point2D, Point2D);
};

Point2D::Point2D(double _x, double _y) : x(_x), y(_y)
{}

int Point2D::ccw(Point2D a, Point2D b, Point2D c)
{
    double area = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);

    if (area < 0){
        return -1; //clockwise
    }
    else if(area > 0){
        return 1; //counter clockwise
    }
    return 0; //colinear
}

#endif