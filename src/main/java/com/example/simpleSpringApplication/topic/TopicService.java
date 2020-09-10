package com.example.simpleSpringApplication.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

//    private List<Course> topics = new ArrayList<>(Arrays.asList(
//            new Course("spring", "Spring Framework", "Spring Framework Description"),
//            new Course("java", "Core Java", "Core Java Description"),
//            new Course("javascript", "JavaScript", "JavaScript Description")
//    )); //version without database

    public List<Topic> getAllTopics() {
        //return topics; //version without database
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().
                forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id)
    {
        //return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get(); //version without database
        return topicRepository.findById(id).get();
    }

    public void addTopic(Topic topic) {
        //topics.add(topic); //version without database
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
//        for(int i=0; i<topics.size(); i++)
//        {
//            Course t = topics.get(i);
//            if(t.getId().equals(id))
//            {
//                topics.set(i, topic);
//                return;
//            }
//        } //version without database
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
//        topics.removeIf(topic -> topic.getId().equals(id)); //version without database
        topicRepository.deleteById(id);

    }
}
