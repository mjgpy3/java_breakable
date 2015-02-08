# What do I want to accomplish?

Ease of use programming language, that is nerdy beyond compare

# Goals
 - Easy to type
 - Naturally DSL fantastic
 - Typing is heavily inferred, far less ritual
 - Language is opinionated but not heavily...
 -- Not really sure what this means in practice
 - JVM-compliant (because it's everywhere and it's not C/C++)
 - Heavy LISP, Ruby, Python, SML/Haskell influences
 - Carry standard tooling over! Why re-re-re-re-invent the wheel?

```
cond {
  equal? 0 (mod x 3), "Fizz",
  equal? 0 (mod x 5), "Buzz",
  equal? 0 (mod x 15), "FizzBuzz"
}
```
So,
 - Lists in curlies
 - Items are comma separated
 - Very LISP-like (i.e. no operator prec)
 - Space to apply functions
 - `equal?` rather than ==

```
map [value, + 1 value] {1, 2, 3}
```

So,
 - Lambdas are in []s
 - params are spaced before comma

```
add = [a b, + a b]
```

So,
 - Again, spaced
 - add is bound to the lambda that accepts 2 values
