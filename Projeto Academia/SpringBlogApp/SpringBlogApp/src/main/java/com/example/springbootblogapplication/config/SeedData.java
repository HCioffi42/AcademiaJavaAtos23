package com.example.springbootblogapplication.config;

import com.example.springbootblogapplication.models.Account;
import com.example.springbootblogapplication.models.Authority;
import com.example.springbootblogapplication.models.Post;
import com.example.springbootblogapplication.repositories.AuthorityRepository;
import com.example.springbootblogapplication.services.AccountService;
import com.example.springbootblogapplication.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll();

        if (posts.size() == 0) {

            Authority user = new Authority();
            user.setName("ROLE_USER");
            authorityRepository.save(user);

            Authority admin = new Authority();
            admin.setName("ROLE_ADMIN");
            authorityRepository.save(admin);

            Account account1 = new Account();
//            Account account2 = new Account();


            account1.setFirstName("Henrique");
            account1.setLastName("Cioffi");
            account1.setEmail("hcioffi");
            account1.setPassword("Cioffi42");

            Set<Authority> authorities2 = new HashSet<>();
            authorityRepository.findById("ROLE_ADMIN").ifPresent(authorities2::add);
            authorityRepository.findById("ROLE_USER").ifPresent(authorities2::add);
            account1.setAuthorities(authorities2);

            accountService.save(account1);

            Post post1 = new Post();
            post1.setTitle("Heartfelt Appreciation");
            post1.setBody("Dear All,\n" +
                    "\n" +
                    "As I near the end of this course, I want to take a moment to express my deepest gratitude to all of you. Colleagues, teachers, and especially my incredible wife, you have been instrumental in making this journey meaningful and memorable.\n" +
                    "\n" +
                    "To my colleagues, thank you for your unwavering support and camaraderie. Our shared moments of study and knowledge transfer have helped me get through this course with a lot more confidence.\n" +
                    "\n" +
                    "To my teachers, your expertise and passion have ignited a fire within me. You have guided me on this path of knowledge, and I am forever grateful for the wisdom you've imparted.\n" +
                    "\n" +
                    "And to my amazing wife, your love and unwavering belief in me have been my driving force. Your support and patience have meant the world to me.\n" +
                    "\n" +
                    "As I prepare to close this chapter, I carry with me cherished memories and invaluable lessons. Thank you all for being a part of this transformative journey. Your impact will resonate within me always.\n");
            post1.setAccount(account1);

            Post post2 = new Post();
            post2.setTitle("Agathokakological");
            post2.setBody("Adjective\n" +
                    "\n" +
                    "Agathokakological beautifully combines Greek roots to describe something that is simultaneously good and evil.\n" +
                    "This word encapsulates the intricate nature of human existence, where light and darkness coexist within us.\n" +
                    "Agathokakological captures the ecensse of life's duality, reminding us that perfection doesn't exist without imperfection.\n" +
                    "So embrace the complexities, the contradictions and the shades of gray.\n" +
                    "\n" +
                    "Well, there you have it.\n" +
                    "That's Agathokakological.");
            post2.setAccount(account1);

            postService.save(post1);
            postService.save(post2);
        }
    }

}
