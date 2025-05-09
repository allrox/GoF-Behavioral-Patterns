package iterator;

import java.util.ArrayList;
import java.util.List;

// Iterable collection
class NameRepository {
    private List<String> names = new ArrayList<>();

    public void addName(String name) {
        names.add(name);
    }

    public NameIterator getIterator() {
        return new NameIterator();
    }

    // Inner Iterator class
    public class NameIterator {
        private int index = 0;

        public boolean hasNext() {
            return index < names.size();
        }

        public String next() {
            if (hasNext()) {
                return names.get(index++);
            }
            return null;
        }
    }
}

// Main
public class IteratorExample {
    public static void main(String[] args) {
        NameRepository repository = new NameRepository();
        repository.addName("Alice");
        repository.addName("Bob");
        repository.addName("Carol");

        NameRepository.NameIterator iterator = repository.getIterator();

        while (iterator.hasNext()) {
            System.out.println("🔹 " + iterator.next());
        }
    }
}
