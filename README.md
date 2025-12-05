# Cypher Tool - Java Homework Assignment
A simple command-line tool to encrypt and decrypt messages using classic cipher algorithms.

Two Versions
This project contains two implementations:

1. SimpleCypherTool.java ⭐ (Recommended for beginners)
Simpler and lighter version for first-grade Java students
~120 lines of code (easy to read and understand)
Supports 2 ciphers: ROT13 and Atbash
Easy-to-follow logic flow
Perfect for weekend homework presentation
2. CypherTool.java (Advanced version)
Professional implementation with 3 ciphers (ROT13, Atbash, Caesar)
Advanced error handling and input validation
Inner class structure (InputData class)
~270 lines of code
Quick Start (SimpleCypherTool)
Compile
javac SimpleCypherTool.java
Run
java SimpleCypherTool
Example Session
=== Welcome to Simple Cypher Tool ===

What would you like to do?
1. Encrypt
2. Decrypt
3. Exit
Choose (1-3): 1

Choose cipher:
1. ROT13
2. Atbash
Choose (1-2): 1

Enter your message: Hello World!

--- Result ---
Cipher: ROT13
Encrypted message: Uryyb Jbeyq!
Understanding the Code
File Structure
Cypher GRUPIT1/
├── SimpleCypherTool.java    <- START HERE (beginner version)
├── CypherTool.java          <- Advanced version with more features
└── README.md                <- This file
Main Method Flow
The main() method controls the entire program:

1. Display welcome message
2. Loop forever:
   a. Ask user: Encrypt, Decrypt, or Exit?
   b. If Exit → quit program
   c. Ask which cipher to use
   d. Ask for message input
   e. Validate input
   f. Process message (encrypt or decrypt)
   g. Display result
   h. Go back to step 2
Key Concept: The loop allows users to process multiple messages without restarting the program.

Two Cipher Algorithms Explained
1. ROT13 (Rotate by 13)
What it does: Shifts each letter 13 positions forward in the alphabet.

Visual Example:

Original:  A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
ROT13:     N O P Q R S T U V W X Y Z A B C D E F G H I J K L M

H e l l o  →  U r y y b
(shift 13)
Why ROT13 is special: Applying ROT13 twice gives you the original message back!

"Hello" → ROT13 → "Uryyb" → ROT13 → "Hello"
Code Logic:

(c - 'A' + 13) % 26
c - 'A' = position in alphabet (0-25)
+ 13 = shift by 13
% 26 = wrap around using modulo (when we go past Z, wrap to A)
Example: H (position 7) → (7 + 13) % 26 = 20 → U

2. Atbash Cipher
What it does: Mirrors the alphabet (A becomes Z, B becomes Y, etc.)

Visual Example:

Original:  A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
Atbash:    Z Y X W V U T S R Q P O N M L K J I H G F E D C B A

H e l l o  →  S v o o l
(mirror)
Why it's called "mirror": The alphabet is reversed!

Code Logic:

'Z' - (c - 'A')
c - 'A' = position in alphabet (0-25)
'Z' - position = mirrored position
Result: A(0) → Z(25), B(1) → Y(24), etc.
Example: H (position 7) → Z - 7 = S

Key Programming Concepts Used
1. String to Character Loop
for (char c : message.toCharArray())
Converts string into array of characters
Loops through each character one by one
2. Character Type Checking
if (c >= 'A' && c <= 'Z')  // Is it uppercase?
if (c >= 'a' && c <= 'z')  // Is it lowercase?
Check if character is a letter
Non-letters (numbers, punctuation) remain unchanged
3. StringBuilder for Efficiency
StringBuilder result = new StringBuilder();
result.append(c);
Used to build the encrypted/decrypted string
More efficient than concatenation with +
4. Modulo Operator (%)
(position + shift) % 26
Wraps around: if position goes past 25, it wraps to 0
Essential for both ROT13 and alphabet wrapping
5. Input Validation
if (message.isEmpty()) {
    System.out.println("Message cannot be empty!");
    continue;  // Skip this iteration, ask again
}
Ensures user input is valid before processing
continue keyword skips rest of loop and restarts
Strategy: Keeping It Simple for Homework
Why SimpleCypherTool is Better for Beginners
✅ Fewer lines (120 vs 270) - easier to explain
✅ One main method - no separate helper methods creating confusion
✅ Direct logic flow - easy to follow with print statements
✅ Only 2 ciphers - ROT13 and Atbash are the most fundamental
✅ Clear variable names - message, result, choice are self-explanatory
✅ Inline comments - explains what each section does

Presentation Tips for Homework
Start with the concept: "This tool encrypts messages using two classical algorithms"

Show the flow: Draw a simple diagram:

User Input → Validation → Cipher Algorithm → Display Result
Demonstrate with examples:

Show "Hello" becoming "Uryyb" with ROT13
Show "Hello" becoming "Svool" with Atbash
Explain the math:

ROT13: "Shift each letter by 13 positions"
Atbash: "Mirror the alphabet"
Highlight key concepts:

Loop: keeps program running for multiple messages
Character checking: distinguishes letters from other characters
StringBuilder: builds the encrypted string character by character
How Non-Alphabetic Characters Are Handled
Important: Numbers, spaces, and punctuation are NOT encrypted - they pass through unchanged.

Example:

Input:  "Hello, World! 123"
ROT13:  "Uryyb, Jbeyq! 123"
        ↑ Comma, space, exclamation, numbers stay the same
Why? Classical ciphers only transform letters. This makes the encrypted message more readable.

Testing the Program
Test Case 1: Basic ROT13 Encryption
Input: Hello
Output: Uryyb
Test Case 2: ROT13 with Special Characters
Input: Hello, World!
Output: Uryyb, Jbeyq!
Test Case 3: Atbash Encryption
Input: Hello
Output: Svool
Test Case 4: Empty Message (Should Reject)
Input: (empty line)
Output: Message cannot be empty!
Test Case 5: ROT13 Applied Twice (Should Return Original)
"Hello" → ROT13 → "Uryyb" → ROT13 → "Hello"
Common Questions & Answers
Q: Why use ROT13 if it only shifts by 13? A: ROT13 is famous because it's simple to understand and because applying it twice gives the original message (mathematically symmetric). It's not meant for real security, just learning.

Q: What's the difference between ROT13 and Atbash? A: ROT13 shifts forward, Atbash mirrors. ROT13 is sequential, Atbash is symmetric.

Q: Why not encrypt numbers and punctuation? A: Classical ciphers work only on letters. Modern ciphers handle all characters, but that's more complex.

Q: What does % 26 do? A: Modulo operator gives the remainder. (25 + 1) % 26 = 0, so when we go past Z, we wrap to A.

Q: Why use StringBuilder instead of + for concatenation? A: Each + creates a new string object (inefficient in loops). StringBuilder reuses memory, making it faster.

How to Present This as Homework
Structure Your Presentation
Introduction (30 seconds)

"This is a message encryption tool"
"It uses two classic cipher algorithms"
Algorithm Explanation (1-2 minutes)

Explain ROT13 with example
Explain Atbash with example
Code Walkthrough (2-3 minutes)

Show main method structure
Explain how the loop works
Show rot13() and atbash() functions
Live Demo (1 minute)

Compile: javac SimpleCypherTool.java
Run: java SimpleCypherTool
Encrypt "Hello" with ROT13
Encrypt "Hello" with Atbash
Q&A

Be ready to explain the % operator
Be ready to explain why loop is important
File Summary
SimpleCypherTool.java
Component	Purpose	Complexity
main()	Controls program flow, gets input from user	Easy
rot13()	Encrypts/Decrypts using ROT13 algorithm	Medium
atbash()	Encrypts/Decrypts using Atbash algorithm	Medium
StringBuilder	Builds encrypted string efficiently	Easy
Total lines of code: ~120 Estimated learning time: 30-45 minutes

Learning Outcomes
After completing this homework, you should understand:

✅ How loops control program flow
✅ How to validate user input
✅ How character encoding works in Java
✅ How classical cipher algorithms work
✅ How to convert strings to character arrays
✅ What % (modulo) operator does
✅ How to use StringBuilder for string manipulation
✅ Basic input/output operations

Additional Resources
Cipher Explanation Links
ROT13: Simple letter shift, used in newsgroups to hide spoilers
Atbash: Ancient Hebrew cipher, one of the oldest known ciphers
Java Concepts
for-each loop: for (char c : array)
Character arithmetic: 'A' + offset calculates new character
Modulo: x % 26 wraps numbers around
Version History
v1.0 (SimpleCypherTool): Beginner-friendly version with 2 ciphers
v2.0 (CypherTool): Advanced version with Caesar cipher and advanced error handling
Good luck with your homework! 🎓
