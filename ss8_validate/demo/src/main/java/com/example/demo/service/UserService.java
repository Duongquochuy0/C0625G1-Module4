    package com.example.demo.service;

    import com.example.demo.entity.User;
    import com.example.demo.repository.IUserRepository;
    import org.springframework.stereotype.Service;

    @Service
    public class UserService implements IUserService{
        private final IUserRepository userRepository;

        public UserService(IUserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @Override
        public void addUser(User user) {
           userRepository.save(user);
        }
    }
