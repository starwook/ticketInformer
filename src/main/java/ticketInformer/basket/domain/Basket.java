package ticketInformer.basket.domain;

import lombok.Getter;
import ticketInformer.Item.domain.Item;
import ticketInformer.user.domain.Member;

import javax.persistence.*;

@Entity
@Getter
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name ="member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name ="item_id")
    private Item item;


}
