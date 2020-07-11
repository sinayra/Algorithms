#include <iostream>
#include <string>
#include "Queue.hpp"
#include "QueueException.hpp"

using namespace std;
int main()
{
    int N;
    Queue<string> *queue = new Queue<string>(10);

    cin >> N;

    for (int i = 0; i < N; i++)
    {
        string s;
        cin >> s;

        try
        {
            if (s.compare("-") == 0)
            {
               cout << queue->dequeue() << " ";
            }
            else{
                queue->enqueue(s);
            }
        }
        catch (QueueException &e)
        {
            cout << "Error: " << e.what() << endl;
        }
    }
    cout << endl;
    queue->displayQueue();

    return 0;
}