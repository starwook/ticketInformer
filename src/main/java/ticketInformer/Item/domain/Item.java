package ticketInformer.Item.domain;

import lombok.Getter;
import ticketInformer.basket.domain.Basket;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private Long date;
    private Long name;

    @Enumerated(EnumType.STRING)
    private ItemSource itemSource;


    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Basket> basketList = new ArrayList<>();
}
