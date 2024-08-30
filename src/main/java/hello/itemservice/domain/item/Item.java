package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Data 는 @Getter @Setter @RequiredArgsConstructor @ToString 모두 만들어주기 때문에
 * 사용하지 않는 게 좋음
 * @Getter @Setter 정도만 사용하기
 */
@Getter
@Setter
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item(Long id, String itemName, Integer price, Integer quantity) {

    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
