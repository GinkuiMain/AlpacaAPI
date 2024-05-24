package AlpacaAPI.PlayneeTesting.repositories;
import AlpacaAPI.PlayneeTesting.PostModel.PostModelClass;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;


@Repository
public interface PostRepository extends JpaRepository<PostModelClass, UUID> {
}
