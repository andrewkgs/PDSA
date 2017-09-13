# HW0: Java Programming: read mapping

In HW0, you are expected to learn:
* how to open and read a file?
* how to acquire the file name from command arguments (args[])?
* how to handle strings in Java?
* how to compare strings in Java?
* how to allocate an array (list)?
* how to use for loops for flow control?

## Input file example:
```
3
CACTG
GCCAT
CATGT
AGCTGAGCACTGGAGTGGAGTTTTCCTGTGGAGAGGAGCCATGCCCACTGTAGAG
```
## Notes:
* The term "read" means nucleotide sequences generated during sequencing process.
* "Mapping" refers to the process of aligning short reads to a reference sequence.
* The first row of the file contains a positive integer (k), which indicates the number of reads.
* The following k rows provides nucleotide sequences of the reads.
* Finally, the last row gives the reference sequence to be mapped.

## Output:

Please report how many reads can be mapped to the reference sequence and how many reads can be mapped multiple times. In this example, we can see both "CACTG" and "GCCAT" can be mapped to the reference sequence "AGCTGAGCACTGGAGTGGAGTTTTCCTGTGGAGAGGAGCCATGCCCACTGTAGAG", while "CATGT" cannot be mapped. Thus, the first line of the output is two. And the second line of the output is one because "CACTG" can be mapped two times.

Output example:
```
2
1
```
## File to be submitted to the judge system:

You are requested to design a Java class named Mapping. So, please submitted a file named: Mapping.java
