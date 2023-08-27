package ru.yandex.practicum.catsgram.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.exception.FilmNotFoundException;
import ru.yandex.practicum.catsgram.exception.UserNotFoundException;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.model.User;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PostService {

    private final UserService userService;
    private final GeneratorId generatorId = new GeneratorId();
    private final List<Post> posts = new ArrayList<>();

    @Autowired
    public PostService(UserService userService) {
        this.userService = userService;
    }

    public List<Post> findAll() {
        log.info("Текущее количество постов: {}", posts.size());
        return posts;
    }

    public Post findPostById(int id) {
        Post post = posts.stream().filter(post1 -> post1.getId() == id).findFirst().orElse(null);
        if (post == null) {
            throw new FilmNotFoundException("Такого поста нет.");
        }
        return post;
    }

    public Post create(Post post) {
        User postAuthor = userService.findUserByEmail(post.getAuthor());
        if (postAuthor == null) {
            throw new UserNotFoundException(String.format(
                    "Пользователь %s не найден",
                    post.getAuthor()));
        }
        post.setId(generatorId.getNextFreeId());
        posts.add(post);
        log.info(post.toString());
        return post;

    }
}
