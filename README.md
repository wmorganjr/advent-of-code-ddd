# Advent of Code 2022
## Domain-Driven Design

These are my [Advent of Code](https://adventofcode.com/) solutions for 2022.

This year, I'm putting an emphasis on *domain-driven design*. This means that
I'm trying to write code in the language and structure of the problem domain.
So, in concrete terms, if the problem describes doing something with elves,
then we should have an `Elf` class. If the description talks about lines of
sight  over trees in a forest, then the program should have a class for the
`Tree`, the `Forest`, and the `LineOfSight`, and responsibilities should be
assigned to the classes based on their role in the problem statement.

### Why Domain-Driven Design?

Advent of Code problems are interesting to me in part because they tell a
story: according to the problem statement, we aren't merely finding the
greatest sum among a list of lists of numbers -- we're finding out which
elf to ask for snacks, in case we get hungry. In domain-driven design,
the isomorphism between the software and the real-world doesn't only exist
in the programmer's mind: it's written into program's language and structure.
The result (we hope!) is software that has high comprehensibility -- comparing
to the concept of readability: the software is _readable_ when you understand
_how_ it works, but the software is _comprehensible_ when you understand _why_
it works.

### Rules

These are some additional rules I'm setting for myself in these solutions:

* My solutions will be in Java, and they will be "professional-grade" --
  basically, to my standards for what I would write for work, with two
  exceptions called out below.
* My solutions must solve both part 1 and part 2 at the same time. No
  copy-pasting. Within reason, my solutions will solve parts 1 and 2 in
  the same pass over the input data.
* Within reason, I'll try to make all my changes backward compatible, and
  I will not be deleting working code. This means that sometimes you'll see
  `SomeClass` and `SomeClass2` which do the same thing in different ways,
  or methods which exist only for the sake of symmetry. That's intentional.
* Confusing code or tricky optimizations must be explained with an
  implementation comment.
* I'll use data structures appropriate to the use case. Where the right one
  doesn't exist, I'll write one.
* This is hard to commit to without knowing all the problems in advance,
  but I expect that all my solutions will be pretty fast; ideally each day
  will run in less than 1 second on my laptop.

And two compromises because this is a solo project, and just for fun:

* Documentation comments (javadocs) are optional. I believe the domain-driven
  approach produces code which is easier to write great docs for, but I'll
  probably skip it for these problems.
* Unit tests are optional, except for the solvers themselves. Again,
  I believe that domain-driven classes are easier to write good unit tests
  for, but I'll be skipping these as well.

### Running the code

```bash
mvn test
```

### Questions or Feedback?

Reach out on the issues page. Merry Christmas!
