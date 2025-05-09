
# Iterator Pattern – Java Example

This project demonstrates the **Iterator** behavioral design pattern in Java. The pattern provides a way to access elements of a collection **sequentially without exposing its underlying structure**.

---

## 📌 Scenario

Imagine you have a collection of names and want to go through each one, but without knowing how that collection is stored internally (array, list, set, etc.). The Iterator pattern lets you do this cleanly and consistently.

---

## 🧠 Key Concepts (based on study questions)

- `List<String> names = new ArrayList<>();`  
  Creates a list of strings using `ArrayList` as the underlying structure.

- `names` is marked `private`  
  This enforces **encapsulation** — preventing direct access and protecting the integrity of the data. Access is only allowed through a method like:
  ```java
  public void addName(String name) {
      names.add(name);
  }
  ```

- The iterator starts at index `0`  
  This means the iteration begins with the **first element in the list**.

- `hasNext()` is **not native** in this case  
  It’s a **custom method** implemented manually, not inherited from Java's `Iterator` interface (though it behaves similarly):
  ```java
  public boolean hasNext() {
      return index < names.size();
  }
  ```

- `next()` returns the current element and advances the index  
  ```java
  public String next() {
      if (hasNext()) {
          return names.get(index++);
      }
      return null;
  }
  ```

---

## 🧱 Class Structure

- `NameRepository`: A simple collection that holds names and provides access via an internal iterator.
- `NameIterator`: A custom iterator class to traverse the names.
- `IteratorExample`: Main class that demonstrates usage.

---

## 🔧 Java Code (English version)

```java
import java.util.ArrayList;
import java.util.List;

class NameRepository {
    private List<String> names = new ArrayList<>();

    public void addName(String name) {
        names.add(name);
    }

    public NameIterator getIterator() {
        return new NameIterator();
    }

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
```

---

## 💡 Output

```
🔹 Alice
🔹 Bob
🔹 Carol
```

---

## ✅ Benefits

- Allows clean iteration over a collection
- Hides internal structure from the client
- Multiple iterators can traverse the same collection independently

---

## ⚠️ Drawbacks

- Can be overkill if the language/framework already provides built-in iteration (as Java does with `List` and `Iterator`)
- Manual iterator implementations may introduce bugs if not well-structured

---

## 📁 File

The entire example is implemented in a single file: `IteratorExample.java`.
