package dang.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "workshops")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workshop_id;
    private String workshop_name;
    private String description;
    private String requirements;
    private String room;
    private Long capacity;

    @ManyToMany(mappedBy = "workshop")
    @JsonIgnore
    private List<Speaker> speaker;

}
