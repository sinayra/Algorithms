#include <iostream>
#include <string>
#include "Stack.hpp"
#include "StackException.hpp"

using namespace std;
int main()
{
    int N;
    Stack<string> *stack = new Stack<string>();

    cin >> N;

    for (int i = 0; i < N; i++)
    {
        string s;
        cin >> s;

        try
        {
            if (s.compare("-") == 0)
            {
               cout << stack->pop() << " ";
            }
            else{
                stack->push(s);
            }
        }
        catch (StackException &e)
        {
            cout << "Error: " << e.what() << endl;
        }
    }
    cout << endl;
    
    //this range-based 'for' statement requires a suitable "begin" function and none was found
    /*for(string s : stack){
        cout << s << " ";
    }*/

    return 0;
}