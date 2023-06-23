package com.example.springbootblogapplication.controllers;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.springbootblogapplication.models.BlogPost;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootblogapplication.services.PostService;
import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Description;
import com.rometools.rome.feed.rss.Item;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class RssFeedController {

  @Autowired
  private PostService postService;

  @GetMapping(path = "/rss")
  public Channel rssFeed(HttpServletRequest request) {

    String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
            .replacePath(null)
            .build()
            .toUriString();

    Channel channel = new Channel();
    channel.setFeedType("rss_2.0");
    channel.setTitle("Spring Boot Blog Application");
    channel.setDescription("My Spring Boot Blog Demo App");
    channel.setLink(baseUrl);
    channel.setUri(baseUrl);
    channel.setGenerator("Custom Sauce");

    Date postDate = new Date();
    channel.setPubDate(postDate);
    List<Item> feed = new ArrayList<>();
    List<BlogPost> blogPosts = postService.getAll();
    for(BlogPost blogPost : blogPosts) {
      Item item = new Item();
      item.setAuthor("Foo");
      item.setLink(baseUrl + "/posts/" + blogPost.getId());
      item.setTitle(blogPost.getTitle());
      item.setUri(baseUrl + "/posts/" + blogPost.getId());

      Description descr = new Description();
      descr.setValue(blogPost.getBody());
      item.setDescription(descr);
      item.setPubDate(Date.from(blogPost.getUpdatedAt().atZone(ZoneId.systemDefault()).toInstant()));
  
      //channel.setItems(Collections.singletonList(item));
      feed.add(item);
    }

    channel.setItems(feed);

    return channel;
  }
  
}
