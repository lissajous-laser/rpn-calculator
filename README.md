# Reverse Polish Notation Calculator
## Background
[Reverse Polish notation](https://en.wikipedia.org/wiki/Reverse_Polish_notation) (RPN) is a notation for math expressions where the operator is placed after the numbers. Such calculators have notably been make by Hewlett-Packard.

Calculators that use this notation are convenient for calculating nested expressions. e.g. an expression $(1 + 2) / ((3 + 4) - (5 + 6))$ can be calculated using the basic math operators and the Enter function, without needing a dedicated memory function for storing numbers in memory. Numbers automatically get pushed onto a stack when entered in, and popped when an operation is called.

## Implementation
- This implementation has a text-based interface, and prints the stack after each operation.
- The stack has 4 levels, with all numbers initialised to zero.
- Numbers are internally represented in single-precision floating point but division by zero has been disallowed.
- Only add subtract, divide, multiply and divide operations are included.

