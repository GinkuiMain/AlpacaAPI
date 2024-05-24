package AlpacaAPI.PlayneeTesting.services;

import AlpacaAPI.PlayneeTesting.PostModel.PostModelClass;
import AlpacaAPI.PlayneeTesting.repositories.PostRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public PostModelClass savePost(String postId, String post_id) {
        PostModelClass post = new PostModelClass();
        // Convertendo postId para BigDecimal, assumindo que é um número
        BigDecimal postIdDecimal = new BigDecimal(postId);
        post.setPostId(postIdDecimal);
        post.setPost_id(post_id);
        return postRepository.save(post);
    }


}
