package advent;

import java.util.Objects;

public final class Solution {
    private final long answer1;
    private final long answer2;
    private final String answer1String;
    private final String answer2String;

    public Solution(long answer1, long answer2) {
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer1String = "";
        this.answer2String = "";
    }

    public Solution(String answer1String, String answer2String) {
        this.answer1 = 0;
        this.answer2 = 0;
        this.answer1String = answer1String;
        this.answer2String = answer2String;
    }

    public long answer1() {
        return answer1;
    }

    public long answer2() {
        return answer2;
    }

    public String answer1String() {
        return answer1String;
    }

    public String answer2String() {
        return answer2String;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return answer1 == solution.answer1 && answer2 == solution.answer2 && Objects.equals(answer1String, solution.answer1String) && Objects.equals(answer2String, solution.answer2String);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer1, answer2, answer1String, answer2String);
    }

    @Override
    public String toString() {
        return "Solution{" +
                "answer1=" + answer1 +
                ", answer2=" + answer2 +
                ", answer1String='" + answer1String + '\'' +
                ", answer2String='" + answer2String + '\'' +
                '}';
    }
}
