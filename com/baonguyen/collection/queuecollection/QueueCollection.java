package com.baonguyen.collection.queuecollection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueCollection {
  public static void main(String[] args) {
    /**
     * Queue means "waiting line". which is very similar to queues in real life: a queue of people
     * standing in an airpot's check-in gate; a queue of cars waiting for green light in a road in
     * the city; a queue of customers waiting to be served in a bank's counter, etc.
     *
     * <p>In programming, queue is a data structure that holds elements prior to processing,
     * similar(tương tự) to queues in real-life scenarios. Let's consider a queue holds a list of
     * waiting customers in a bank's counter. Each customer is served one after another, follow the
     * order they appear or registered. The first customer comes is served first, and after him is
     * the 2nd, 3rd, and so on. WHen serving a customer is don't, he or she lefts the counter (
     * removed from the queue), and the next customer is picked to be served next. Other customers
     * come later are added to the end of the queue. This processing is called First In First Our or
     * FIFO
     *
     * <p>During the processing, the queue can be dynamically changed, i.e processed elements are
     * removed from the queue, and new elements are added to the queue.
     *
     * <p>In the Java Collections Framework, Queue is the main interface, and there are four sub
     * interfaces: Deque, BlockingDeQue, BlockingQueue and TransferQueue.
     *
     * <p>Expect the Deque interface which is in the java.util package, all others are organized in
     * the java.util.concurrent package, which is designed for multi-threading or concurrent
     * programming.
     *
     * <p>2. Characteristics of Queue Basically, a queue has a head and a tail. New elements are
     * added to the tail, and to-be-processed elements are picked from the head.
     *
     * <p>Elements in the queue are maintained by their insertion order. The Queue interface
     * abstracts this kind of queue.
     *
     * <p>Another kind of queue is double ended queue, or deque. A deque has two heads, allowing
     * elements to be added or removed from both ends.
     *
     * <p>The queue interface abstracts this kind of queue, and it is a sub interface of the Queue
     * interface. And the LinkedList class is a well-known(nổi tiếng) implementation
     *
     * <p>Some implementations accept null elements, some do not.
     *
     * <p>Queue dose allow duplicate elements, because the primary characteristic of queue is
     * maintaining elements by their insertion order. Duplicate elements dựa trên phương thức equals
     * được coi là khác nhau trong queue vì không có 2 elements having same ordering.
     *
     * <p>Additionally, the Java Collection Framework provides the BlockingQueue interface that
     * abstracts queues which can be used in concurrent (multi-threading) context.
     *
     * <p>A blocking queue waits for the queue to become non-empty when retrieving an element, and
     * waits for space become available in the queue when storing an element.
     *
     * <p>Similarly, the BlockingDequeue interface is blocking queue for double ended queues.
     *
     * <p>3. Behaviros of QUeue
     *
     * <p>Due to Queue's nature(tính chất), các cách phân biệt Queue với các collections khác là lấy
     * ra và kiểm tra phần đầu của queue.
     *
     * <p>For deques, the extraction and inspection(kiểm tra) can be processed on both ends.
     *
     * <p>And because the Queue interface extends the Collection interface, all Queue
     * implementations provide core operations of a collection like add(), contains(), remove(),
     * clear(), isEmpty(), ..
     *
     * <p>With queues, operations on the head are fastest (e.g. offer() and remove()), whereas(trong
     * khi) operations on middle elements are slow (e.g. contains(e) and remove(e))
     *
     * <p>Queue's Interfaces Queue is super interface of the queue branch in the Java Collection
     * Framework.
     *
     * <p>Sub interfaces:
     *
     * <p>Deque: abstracts a queue that has two heads. A dequa allows adding or removing elements at
     * both ands.
     *
     * <p>BlockingQueue: abstracts a type of queues that waits for the queue to be non-empty when
     * retrieving an element, and waits for space to become available in the queue when storing an
     * element
     *
     * <p>BLockingDeQue: is similar to BlockingQueue, but for double ended queues. It is sub
     * interface of the BlockingQueue. And since Java 7, the BlockingQueue interface has a new sub
     * interface called TransferQueue, which is a specialized BlockingQueue, which waits for another
     * thread to retrieve an element in the queue.
     *
     * <p>5. Major Queue's Implementations: The Java Collection framework provides many
     * implementations, mostly for the BlockingQueue interface. Below I name few which are used
     * commonly. Queue implementations are grouped into two groups: general-purpose and concurrent
     * implementations.
     *
     * <p>General-purpose Queue implementations:
     *
     * <p>+LinkedList: this class implements both List and Deque interface, thus having hybrid(lai)
     * characteristics and behaviors of list and queue. Consider using a LinkedList when you want
     * fast adding and fast removing elements at both ends, plus accessing elements by index.
     *
     * <p>+PriorityQueue: this queue orders elements according to their natural ordering, or by a
     * Comparator privided at construction time. Consider using a PriorityQueue when you want to
     * take advantages of natural ordering and fast
     *
     * <p>+ ArrayDeque: a simple implementation of the Deque interface. Consider using an ArrayDeque
     * when you want to utilize features of a double ended queue without list-based ones (simpler
     * than a LinkedList).
     *
     * <p>- Concurrent Queue implementations: + ArrayBlockingQueue: this is a blocking queue backed
     * by an array. Consider using an ArrayBlockingQueue when you want to use a simple blocking
     * queue that has limited capacity (bounded).
     *
     * <p>+ PriorityBlockingQueue: Use this class when you want to take advantages of both
     * PriorityQueue and BlockingQueue.
     *
     * <p>+ DelayQueue: a time-based scheduling blocking queue. Elements added to this queue must
     * implement the Delayed interface. That means an element can only be taken from the head of the
     * queue when its delay has expired.
     *
     * <p>Because the Queue interface extends the Collection interface, all Queue implementations
     * have basic operations of a collection:
     *
     * <p>Single operations: add(e),contains(e), iterator(), clear(), isEmpty(), size() and
     * toArray().
     *
     * <p>Bulk operations: addAll(), containsAll(), removeAll() and retainAll().
     *
     * <p>Basically, Queue provides three primary types of operations which differentiate a queue
     * from others:
     *
     * <p>insert: adds an elements to the tail of the queue remove: removed the element at the head
     * of the queue Examine: returns, but does not remove, the element at the head of the queue.
     *
     * <p>And for each type of operation, there are two versions:
     *
     * <p>- First version throws an exception if the operations fails, e.g could not add element
     * when the queue is full
     *
     * <p>-THe second version returns a special value (either null or false, depending on the
     * operation)
     *
     * <p>insert : add(e) , offer(e)
     *
     * <p>remove: remove(), poll()
     *
     * <p>examine: element(), peek();
     *
     * <p>The Deque interface abstracts a double ended queue with two ends (first and last), so its
     * API is structured around this characteristic
     *
     * <p>A Deque implementation provides the xxxFirst() methods that operate on the first element,
     * and the xxxLast() methods that operate on the last element.
     *
     * Insert: addFirst(e) & offerFirst(e) , addLast(e) && offerLast(e).
     *
     * Remove: removeFirst() & poolFirst(), removeLast() && poolLast()
     *
     * Examine: getFirst() && peekFirst(), getLast() && peekLast().
     *
     * ===============BlockingQueue==================================
     * A blocking queue
     */

    Queue<String> namesQueue = new LinkedList<>();
    Deque<Integer> numbersDeque = new ArrayDeque<>();
    BlockingQueue<String> waitingCustomers = new ArrayBlockingQueue<>(100);
  }
}
