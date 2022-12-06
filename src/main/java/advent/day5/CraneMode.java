package advent.day5;

enum CraneMode {
    ONE_AT_A_TIME,
    MULTIPLE_CRATES_AT_ONCE;

    void moveCrates(int count, Stack source, Stack destination) {
        switch (this) {
            case ONE_AT_A_TIME -> {
                for (int i = 0; i < count; i++) {
                    destination.addToTop(source.pickUpTopCrate());
                }
            }
            case MULTIPLE_CRATES_AT_ONCE -> {
                destination.addAllToTop(source.pickUpTopCrates(count));
            }
        }
    }
}
