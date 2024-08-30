package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository  // ComponentScan의 대상이 됨
public class ItemRepository {
    /**
     * Spring Context 안에서 사용하면 어차피 싱글톤이기 때문에 static을 쓰지 않아도 되지만,
     * 따로 new 해서 쓰게되면 객체 생성한만큼 따로 생성이 될테니 static 사용
     *
     * 동시에 접근할 때는, HashMap 이 아닌 ConcurrentHashMap을 사용해야함
     * sequence 도 그냥 long 이 아닌 AtomicLong 을 사용해야함
     */
    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
