package LoginSystem;
import java.util.LinkedHashMap;
import java.util.Map;

public class ActionRegistry{
    private final Map<Integer, MenuAction> actions = new LinkedHashMap<>();

    public void register(int key, MenuAction action){
        actions.put(key, action);
    }

    public MenuAction getAction (int key){
        return actions.get(key);
    }

    public Map<Integer, String> getItems(){
        Map<Integer, String> menuItem = new LinkedHashMap<>();
        actions.forEach((k,v) -> menuItem.put(k, v.name()));
        return menuItem;
    }
}
