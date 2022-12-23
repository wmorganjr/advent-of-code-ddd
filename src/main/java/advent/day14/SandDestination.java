package advent.day14;

interface SandDestination {
    boolean isAbyss();

    SandDestination ABYSS = () -> true;
    SandDestination NONE = () -> false;
}
