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

    //stack.displayStack();

    return 0;
}