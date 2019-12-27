package teun.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import teun.demo.domain.Group;
import teun.demo.repository.GroupRepository;

@Component
public class GroupByIdConverter implements Converter<String,Group> {
    private GroupRepository groupRepository;

    @Autowired
    public GroupByIdConverter (GroupRepository repo) {
        this.groupRepository = repo;
    }

    @Override
    public Group convert(String id) {
        Long idLong = Long.parseLong(id);
        return groupRepository.findById(idLong).orElseThrow(RuntimeException::new);
    }
}
