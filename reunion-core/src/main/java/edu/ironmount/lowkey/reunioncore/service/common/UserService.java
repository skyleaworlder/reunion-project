package edu.ironmount.lowkey.reunioncore.service.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.ironmount.lowkey.reunioncore.exception.ResourceNotFoundException;
import edu.ironmount.lowkey.reunioncore.model.common.User;
import edu.ironmount.lowkey.reunioncore.model.request.UserDetail;
import edu.ironmount.lowkey.reunioncore.repository.common.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void createUser(UserDetail detail) {
        User user = new User();
        user.setName(detail.username());
        user.setNickName(detail.nickName());
        user.setPwd(detail.password());
        user.setRecentResidence(detail.recentResidence());
        user.setWorkplace(detail.workplace());
        user.setTimeDurations(null);
        userRepository.save(user);
    }

    public List<User> getUserBySortPage(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<User> pagedResult = userRepository.findAll(paging);
        return pagedResult.getContent();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(String.format("User %d not found", id)));
    }

    public void updateUser(Long id, UserDetail detail) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(String.format("User %d not found", id)));
        user.setName(detail.username());
        user.setNickName(detail.nickName());
        user.setPwd(detail.password());
        user.setRecentResidence(detail.recentResidence());
        user.setWorkplace(detail.workplace());
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
