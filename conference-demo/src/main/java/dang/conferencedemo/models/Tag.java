package dang.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity(name = "tags")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@NoArgsConstructor
public class Tag {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tag_id;
    private String description;

    @OneToMany(mappedBy = "tag")
    @JsonIgnore
    private Set<Session> session;

}