package ru.yandex.practicum.catsgram.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.service.PostService;

import java.util.List;

@Slf4j
@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> findAll() {
        log.info("Запрос всех постов!");
        return postService.findAll();
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public Post findPostById(@PathVariable int id) {
        log.info("Запрос поста по Id");
        return postService.findPostById(id);
    }

    @PostMapping(value = "/post")
    public Post create(@RequestBody Post post) {
        log.info("Добавление нового поста.");
        return postService.create(post);
    }
}