package com.rubanProject.AssignmentProject.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubanProject.AssignmentProject.Constants.AssignmentConstants;
import com.rubanProject.AssignmentProject.Models.MessageModel;
import com.rubanProject.AssignmentProject.Models.UserDetails;
import com.rubanProject.AssignmentProject.Repository.MessageModelRepository;
import com.rubanProject.AssignmentProject.Repository.UserDetailsRepository;

@Service
public class AssignmentService {
	@Autowired
	UserDetailsRepository userRepository;
	
	@Autowired
	MessageModelRepository messageRepository;
	
	int userid = 9;
	int messageIndex = 5;
	public List<UserDetails> addIntialData()
	{
		List<UserDetails> list = new ArrayList<UserDetails>();
		userRepository.save(new UserDetails(1,"Ruban",AssignmentConstants.PASSWORD,AssignmentConstants.GROUP_A));
		userRepository.save(new UserDetails(2,"Moses",AssignmentConstants.PASSWORD,AssignmentConstants.GROUP_A));
		userRepository.save(new UserDetails(3,"George",AssignmentConstants.PASSWORD,AssignmentConstants.GROUP_A));
		userRepository.save(new UserDetails(4,"Sathish",AssignmentConstants.PASSWORD,AssignmentConstants.GROUP_A));
		userRepository.save(new UserDetails(5,"Anil",AssignmentConstants.PASSWORD,AssignmentConstants.GROUP_B));
		userRepository.save(new UserDetails(6,"Sunil",AssignmentConstants.PASSWORD,AssignmentConstants.GROUP_B));
		userRepository.save(new UserDetails(7,"Apple",AssignmentConstants.PASSWORD,AssignmentConstants.GROUP_A));
		userRepository.save(new UserDetails(8,"Rakesh",AssignmentConstants.PASSWORD,AssignmentConstants.GROUP_B));
		messageRepository.save(new MessageModel(1,"Ruban", "Apple", "Hi man!"));
		messageRepository.save(new MessageModel(2,"Apple", "Ruban", "Tell man!"));
		messageRepository.save(new MessageModel(3,"Ruban", "Apple", "HOW IS LIFE GOING??"));
		messageRepository.save(new MessageModel(4,"Apple", "Ruban", "LIFE IS AMAZING"));
		for(UserDetails u: userRepository.findAll())
		{
			list.add(u);
		}
		return list;	
	}
	
	public UserDetails addUsers(UserDetails user)
	{
		user.setId(userid);
		userid++;
		user.setPassword(AssignmentConstants.PASSWORD);
		return userRepository.save(user);
	}
	
	public List<UserDetails> checkUserExist(String name)
	{
		UserDetails user1 = new UserDetails();
		List<UserDetails> list = new ArrayList<UserDetails>();
		for(UserDetails u : userRepository.findAll())
		{
			if(u.getUserName().equals(name))
			{
				user1 = u;
			}
		}
		for(UserDetails u : userRepository.findAll())
		{
			if(u.getGroupid().equals(user1.getGroupid()) && u.getUserName().equals(name)==false)
			{
				list.add(u);
			}
		}
		return list;
	}
	public List<MessageModel> listOfAllSentMessages(String fromName,String toName)
	{
		List<MessageModel> list = new ArrayList<MessageModel>();
		for(MessageModel m: messageRepository.findAll())
		{
			if(m.getFromuser().equals(fromName) && m.getTouser().equals(toName))
			{
				list.add(m);
			}
		}
		return list;
	}
	public List<MessageModel> listOfAllReplyMessages(String fromName,String toName)
	{
		List<MessageModel> list = new ArrayList<MessageModel>();
		for(MessageModel m: messageRepository.findAll())
		{
			if(m.getFromuser().equals(toName) && m.getTouser().equals(fromName))
			{
				list.add(m);
			}
		}
		return list;
	}
	public MessageModel addMessage(MessageModel msg)
	{
		msg.setId(messageIndex);
		messageIndex++;
		return messageRepository.save(msg);
	}
	public List<MessageModel> fetchAllMessages()
	{
		List<MessageModel> list = new ArrayList<MessageModel>();
		for(MessageModel m: messageRepository.findAll())
		{
			list.add(m);
		}
		return list;
	}
	public void deleteTheUser(UserDetails user)
	{
		userRepository.delete(user);
	}
}
