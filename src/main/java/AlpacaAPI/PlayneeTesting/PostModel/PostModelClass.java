package AlpacaAPI.PlayneeTesting.PostModel;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;


@Entity
@Table(name = "PostDB")
public class PostModelClass extends RepresentationModel<PostModelClass> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPostagemAlpaca;

    @Column(name = "id", nullable = false, unique = true)
    private BigDecimal postId;

    @Column(name = "post_id", nullable = false, unique = true)
    private String post_id;

    // Getters and Setters
    public UUID getIdPostagemAlpaca() {
        return idPostagemAlpaca;
    }

    public void setIdPostagemAlpaca(UUID idPostagemAlpaca) {
        this.idPostagemAlpaca = idPostagemAlpaca;
    }

    public BigDecimal getPostId() {
        return postId;
    }

    public void setPostId(BigDecimal postId) {
        this.postId = postId;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }
}
