package advent.day2;

import java.util.Objects;

record Round(Shape myShape, Shape yourShape) {
    static Round ofPart1(final Shape myShape, final Shape yourShape) {
        return new Round(myShape, yourShape);
    }

    static Round ofPart2(final Shape yourShape, final Outcome desiredOutcome) {
        Shape myShape = Objects.requireNonNull(yourShape.shapeLeadingToOutcome(desiredOutcome));
        return new Round(myShape, yourShape);
    }

    int score() {
        return myShape().score() + myOutcome().score();
    }

    Outcome myOutcome() {
        if (myShape.defeats(yourShape)) {
            return Outcome.WIN;
        } else if (yourShape.defeats(myShape)) {
            return Outcome.LOSS;
        } else {
            return Outcome.DRAW;
        }
    }
}
