package com.psouza.springmongodbdemo.config;

import com.psouza.springmongodbdemo.dto.AuthorDTO;
import com.psouza.springmongodbdemo.dto.CommentDTO;
import com.psouza.springmongodbdemo.entities.Post;
import com.psouza.springmongodbdemo.entities.User;
import com.psouza.springmongodbdemo.repositories.PostRepository;
import com.psouza.springmongodbdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com", "maria123");
        User alex = new User(null, "Alex Green", "alex@gmail.com", "alex123");
        User bob = new User(null, "Bob Grey", "bob@gmail.com", "bob123");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post p1 = new Post(null, sdf.parse("21/03/2018"), "Vacation incoming", "Going to Madrid tomorrow!", new AuthorDTO(maria));
        Post p2 = new Post(null, sdf.parse("23/03/2018"), "Good morning", "Woke up very happy today!", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Have a nice trip!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Enjoy your trip!", sdf.parse("22/03/2018"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Wish you a good day!", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        p1.getComments().addAll(Arrays.asList(c1, c2));
        p2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(p1, p2));

        maria.getPosts().addAll(Arrays.asList(p1, p2));

        userRepository.save(maria);
    }
}
