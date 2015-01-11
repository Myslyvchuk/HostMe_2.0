package com.softserve.edu.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.softserve.edu.dto.ConversationDto;
import com.softserve.edu.model.Conversation;
import com.softserve.edu.model.Group;
import com.softserve.edu.service.ConversationService;
import com.softserve.edu.service.GroupService;

@Controller
public class GroupController {
    
    @Autowired
    private GroupService groupService;
    
    @Autowired
    private ConversationService conversationService;
    
    @RequestMapping(value= "/groups", method = RequestMethod.GET)
    public String groupCreationShow(Model model) {
        Set<Group> groups = groupService.findAll();
        System.out.println(groups.size());
        model.addAttribute("groups", groups);
        return "groups";
    }
    
    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public String showGroups(@RequestParam("id") long id, Model model) {
	Group group = groupService.findOne(id);
        model.addAttribute("group", group);
        addLatestConversationsByGroupId(model, id);
        return "group";
    }
    
    private void addLatestConversationsByGroupId(Model model, Long id) {
	List<ConversationDto> conversations = conversationService.findLatestConversationsDtoByGroupId(id);
	Long conversationsSize = conversationService.countByGroupId(id);
	model.addAttribute("conversationDtos", conversations);
	model.addAttribute("conversationsSize", conversationsSize);
    }
}
