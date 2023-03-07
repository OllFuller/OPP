package GeoTree;

public class Node {
    private Person p1;
    private Relationship re;
    private Person p2;

    public Node(Person person, Relationship re, Person relative) {
        if (person == null || relative == null) return;
        this.p1 = person;
        this.re = re;
        this.p2 = relative;
    }

    public Person getP1() {
        return p1;
    }

    public Person getP2() {
        return p2;
    }

    public Relationship getRe() {
        return re;
    }

    @Override
    public String toString() {
        return String.format("<%s %s %s>", p1, re, p2);
    }

    public void setP2(Person person) {
        this.p2 = person;
    }
}
