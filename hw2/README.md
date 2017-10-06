# HW2: Using stacks

In this homework, you are requested to implement a class named: Calculator
This class must contain a public function with the following API:
```
public Double ans (String e) {
// please replace the following null to the answer you calculate.
return null;
}
```
Input to the function 'ans':
```
1 + 6 / 2 * ( 1 + 2 ) - 4 * ( 5 - 3 )
```
Output of the function 'ans':
```
2
```

## Note:

1. The judging system will construct an object by initializing an instance of Calculator
Calculator cct = new Calculator();
2. We will not execute your main function in the Calculator.java you submit.
3. You do not need to worry about the format of printing the Double value.
4. All the numbers, operators, and brackets are seperated by 'single space', so you don't have to spend much time on parsing string.
5. You only need to handle with the four operators (+, -, *, /) and the round brackets ( ). No square brackets[ ], curly brackets{ }, or other operators will be used.
6. Make sure you calculate in order of operations.( brackets -> multiplication and division -> addition and subtraction )

## File to be submitted to the judge system:

You are requested to design a Java class named Calculator. So, please submit a file named: Calculator.java
