# Repetition Free Grouping

### TODO: implement backtracking to make the algorithm exhaustive. `java Group 32 8` should return 10 answers to be exhaustive.

This small utility is inspired by a problem encountered in real life:
> Given _m_ members, we need to divide them into _n_ groups/teams uniformly. To simplify the question, we assume that _m_ is always divisible by _n_.
> The goal is to find the number of assignments (of members to teams) so that any two of the _m_ members only share the same team in one assignment. 

This is a common enough problem and this simple Java program addresses this problem. The output format is properly tuned and the program is extended to support command-line specified _m_ and _n_ values, as long as _m_ is divisible by _n_. 

Typical usages:
```
javac Group.java
java Group 32 8
```
This is an example to find the number of repetition free grouping assignments of grouping 32 members into 8 teams. 

Typical output:
```
Solution 1: 
team1: 1 2 3 4 
team2: 5 6 7 8 
team3: 9 10 11 12 
team4: 13 14 15 16 
team5: 17 18 19 20 
team6: 21 22 23 24 
team7: 25 26 27 28 
team8: 29 30 31 32 
Solution 2: 
team1: 1 5 9 13 
team2: 2 6 10 14 
team3: 3 7 11 15 
team4: 4 8 12 16 
team5: 17 21 25 29 
team6: 18 22 26 30 
team7: 19 23 27 31 
team8: 20 24 28 32 
Solution 3: 
team1: 1 6 11 16 
team2: 2 5 12 15 
team3: 3 8 9 14 
team4: 4 7 10 13 
team5: 17 22 27 32 
team6: 18 21 28 31 
team7: 19 24 25 30 
team8: 20 23 26 29 
Solution 4: 
team1: 1 7 12 14 
team2: 2 8 11 13 
team3: 3 5 10 16 
team4: 4 6 9 15 
team5: 17 23 28 30 
team6: 18 24 27 29 
team7: 19 21 26 32 
team8: 20 22 25 31 
Solution 5: 
team1: 1 8 10 15 
team2: 2 7 9 16 
team3: 3 6 12 13 
team4: 4 5 11 14 
team5: 17 24 26 31 
team6: 18 23 25 32 
team7: 19 22 28 29 
team8: 20 21 27 30 
There are in total 5 assignments available. 
```

It is highly likely that such a problem can be addressed more easily by little languages like CNF or ZIMPL. Still, this is a worthy Java practice.

Note that this solution is not exhaustive. This is problem has already been generalized as a classic math problem known as __social golfer problem__ and has been known as unsolvable in general sense. A discovered solution for dividing 32 people into 8 groups is [A 10 Days Solution to the Social Golfer Problem](http://www.mathpuzzle.com/MAA/54-Golf%20Tournaments/socgolf1.pdf)
