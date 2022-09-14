package ticketInformer.user.domain;

import lombok.Getter;
import ticketInformer.basket.domain.Basket;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Basket> basketList = new ArrayList<>();

}
