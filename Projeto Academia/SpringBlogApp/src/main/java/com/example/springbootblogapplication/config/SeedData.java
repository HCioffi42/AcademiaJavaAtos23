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

//            Account account1 = new Account();
            Account account2 = new Account();

//            account1.setFirstName("user_first");
//            account1.setLastName("user_last");
//            account1.setEmail("user.user@domain.com");
//            account1.setPassword("password");
//            Set<Authority> authorities1 = new HashSet<>();
//            authorityRepository.findById("ROLE_USER").ifPresent(authorities1::add);
//            account1.setAuthorities(authorities1);


            account2.setFirstName("Henrique");
            account2.setLastName("Cioffi");
            account2.setEmail("hcioffi");
            account2.setPassword("Cioffi42");

            Set<Authority> authorities2 = new HashSet<>();
            authorityRepository.findById("ROLE_ADMIN").ifPresent(authorities2::add);
            authorityRepository.findById("ROLE_USER").ifPresent(authorities2::add);
            account2.setAuthorities(authorities2);

//            accountService.save(account1);
            accountService.save(account2);

            Post post1 = new Post();
            post1.setTitle("Agathokakological");
            post1.setBody("Adjective\n" +
                    "\n" +
                    "Agathokakological beautifully combines Greek roots to describe something that is simultaneously good and evil.\n" +
                    "This word encapsulates the intricate nature of human existence, where light and darkness coexist within us.\n" +
                    "Agathokakological captures the ecensse of life's duality, reminding us that perfection doesn't exist without imperfection.\n" +
                    "So embrace the complexities, the contradictions and the shades of gray.\n" +
                    "\n" +
                    "Well, there you have it.\n" +
                    "That's Agathokakological.");
            post1.setAccount(account2);

            Post post2 = new Post();
            post2.setTitle("Something else Ipsum");
            post2.setBody("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Magna eget est lorem ipsum dolor sit amet consectetur adipiscing. Tempus quam pellentesque nec nam aliquam sem et tortor. Pellentesque sit amet porttitor eget. Sed augue lacus viverra vitae congue eu consequat. Ultrices vitae auctor eu augue. Mattis rhoncus urna neque viverra. Consectetur lorem donec massa sapien faucibus et molestie ac feugiat. Sociis natoque penatibus et magnis dis parturient montes nascetur. Cursus turpis massa tincidunt dui ut ornare lectus. Odio pellentesque diam volutpat commodo sed egestas egestas fringilla. Id cursus metus aliquam eleifend mi. Nibh nisl condimentum id venenatis a condimentum.");
            post2.setAccount(account2);
//
            postService.save(post1);
            postService.save(post2);
        }
    }

}
