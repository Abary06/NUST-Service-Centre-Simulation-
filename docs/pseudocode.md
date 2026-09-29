# Pseudocode for the Project

## Queue

enqueue(student):
1. If queue is full, increase array size.
2. Set rear to rear + 1.
3. Store student at that position.
4. Increase size.

dequeue():
1. If queue is empty, return null.
2. Store front element in temp variable.
3. Remove element from front.
4. Move front pointer forward.
5. Decrease size.
6. Return removed student.

## Stack

push(value):
1. If stack is full, expand stack array.
2. Increase top pointer.
3. Place value at top.

pop():
1. If stack is empty, report error.
2. Read value from top.
3. Decrease top pointer.
4. Return value.

postfix evaluation:
1. Read tokens one by one.
2. If token is a number, push it.
3. If token is an operator, pop two operands.
4. Apply the operator.
5. Push the result.
6. Continue until all tokens are processed.
7. Return the final stack value.

## Linked list

insertNode(position, student):
1. Create new node.
2. If position is 0, insert at beginning.
3. Otherwise, move to the node before the target position.
4. Link the new node to the next node.
5. Link the previous node to the new node.

deleteNode(studentNumber):
1. If head matches the target, remove head.
2. Otherwise, walk the list.
3. When the matching record is found, reconnect links.
4. Return success or failure.

searchNode(studentNumber):
1. Start at head.
2. Compare each student number.
3. Return the matching student if found.
4. Return null when no match exists.

traverseList():
1. Start at head.
2. Print each student record.
3. Continue until end of list.

## Sorting

selectionSort(arr):
1. For each position i in the array:
2. Find the smallest value in the unsorted section.
3. Swap the smallest value into position i.
4. Continue until the array is sorted.

insertionSort(arr):
1. For each value from index 1 onward:
2. Save it as key.
3. Shift larger values to the right.
4. Insert key into the correct position.
5. Continue until all values are sorted.

mergeSort(arr):
1. If the array has fewer than two elements, stop.
2. Split the array into left and right halves.
3. Sort each half recursively.
4. Merge both sorted halves into one array.

quickSort(arr):
1. Choose the last element as pivot.
2. Partition the array into values less than or equal to pivot and greater than pivot.
3. Recursively sort both partitions.
4. Return when all partitions are processed.
