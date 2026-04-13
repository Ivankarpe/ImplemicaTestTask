This is my take on completeng test tasks.

For first task i decided to generate all posible combinations of valid sequences and count them. I added memoization to reduce computational load from recursion

For second task i gather information from user and using dijkastra find minimal path. I thought about computing once for all pairs of cities, but for 15 cities number of pairs is greater than nuber of tests. Aditionaly memoization can be added to costly dijkastra algorithm.

For third task i used BigInteger to store value of factorial. and for fonding sum of numbers transformed it into string and then iterating on it.