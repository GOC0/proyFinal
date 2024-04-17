import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UnionFind {
	 private Map<Character, Character> parent;

	    public UnionFind(Set<Character> vertices) {
	        parent = new HashMap<>();
	        for (char vertice : vertices) {
	            parent.put(vertice, vertice);
	        }
	    }

	    public char find(char v) {
	        if (parent.get(v) == v) {
	            return v;
	        }
	        return find(parent.get(v));
	    }

	    public void union(char a, char b) {
	        char rootA = find(a);
	        char rootB = find(b);
	        parent.put(rootA, rootB);
	    }

	    public boolean isConnected(char a, char b) {
	        return find(a) == find(b);
	    }

}
