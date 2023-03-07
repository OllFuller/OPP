package GeoTree;

import java.util.ArrayList;
import java.util.HashSet;


public class Reserch {
    ArrayList<String> result = new ArrayList<>();
    ArrayList<Node> tree;

    public Reserch(GeoTree geoTree) {
        tree = geoTree.getTree();
    }

    public ArrayList<String> spend(Person person, Relationship rel) {
        for (Node t : tree) {
            if (t.getP1().getFullName().equals(person.getFullName()) && t.getRe() == rel) {
                result.add(t.getP2().getFullName());
            }
        }
        return result;
    }

    public ArrayList<String> getParents(Person person) {
        return spend(person, Relationship.children);
    }

    public ArrayList<String> getChildren(Person person) {
        return spend(person, Relationship.parent);
    }

    public ArrayList<String> getBrotherSister(Person person) {
        ArrayList<Node> parents = new ArrayList<>();
        for (Node parent : this.tree) {
            if (parent.getRe() == Relationship.parent && parent.getP2().equals(person)) {
                parents.add(parent);
                if (parents.size() > 1) break;
            }
        }
        HashSet<Person> brother_sister = new HashSet<>();
        for (Node parent : parents) {// находим всех братьев и сестер
            for (Node t : this.tree) {
                if (parent.getP1().equals(t.getP1()) &&
                        t.getRe() == Relationship.parent && //если отношение -> родитель
                        !t.getP2().equals(person)) {//кроме самого person
                    brother_sister.add(t.getP2());
                }
            }
        }
        for (Person p : brother_sister) {
            result.add(p.getFullName());
        }
        return result;
    }

    public ArrayList<String> getPartners(Person person) {
        return spend(person, Relationship.partner);
    }
}

