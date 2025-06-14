package history;

import java.util.ArrayList;
import java.util.List;

public class HistoryManager {
  private final List<String> history = new ArrayList<>();

  public void add(String entry) {
    history.add(entry);
  }

  public List<String> getHistory() {
    return new ArrayList<>(history);
  }

  public void clear() {
    history.clear();
  }
}
