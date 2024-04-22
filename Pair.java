package AlgoDat.HA1;

import java.util.Objects;


public class Pair {
    private int a = 0;
    private String b = "";

    public int getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public Pair(int a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return a == pair.a && Objects.equals(b, pair.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return a  +  b;
    }
}
