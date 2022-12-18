package advent.day11;

record MonkeyTest(Condition condition, String trueMonkey, String falseMonkey) {
    Monkey destMonkey(final MonkeyGroup monkeyGroup, final long worryLevel) {
        if (condition.matches(worryLevel)) {
            return monkeyGroup.findById(trueMonkey);
        } else {
            return monkeyGroup.findById(falseMonkey);
        }
    }

    Monkey destMonkey(final MonkeyGroup monkeyGroup, final ModularCongruenceSet worryLevel) {
        if (worryLevel.isDivisibleBy(condition.modulus())) {
            return monkeyGroup.findById(trueMonkey);
        } else {
            return monkeyGroup.findById(falseMonkey);
        }
    }
}
