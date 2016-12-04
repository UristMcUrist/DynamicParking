package researchproject;

import java.util.ArrayList;
import java.util.HashMap;

public class Mailbox
{
	// Local variables declaration
	private HashMap<Message,Boolean> inMailbox;
	private ArrayList<Message> outMailbox;
	/**
	 * Custom constructor
	 */
	public Mailbox()
	{
		this.inMailbox = new HashMap<>();
		this.outMailbox = new ArrayList<>();
	}
	/**
	 * Receive a message, put it in the received mailbox and mark it unread
	 * @param m - message to receive
	 */
	public void recieveMessage(Message m) { this.inMailbox.put(m, false); }
	/**
	 * Send message to a given mailbox, put it in the sent mailbox
	 * @param receiverMailbox - message box to send the message to
	 * @param m - a message to send
	 */
	public void sendMessage(Mailbox receiverMailbox, Message m)
	{
		this.outMailbox.add(m);
		receiverMailbox.recieveMessage(m);
	}
	/**
	 * Read the first unread message in the received mailbox, and mark it as read
	 */
	public void readMessage()
	{
		for(Message m : inMailbox.keySet())
		{
			if(!inMailbox.get(m))
			{
				//TODO Read the message
				
				// ...
				
				//
				inMailbox.put(m, true);
			}
			
			return;
		}
	}
	/**
	 * Read all unread messages in the received mailbox, and mark them as read
	 */
	public void readAllUnreadMessages()
	{
		for(Message m : inMailbox.keySet())
		{
			if(!inMailbox.get(m))
			{
				//TODO Read the message
				
				// ...
				
				//
				inMailbox.put(m, true);
			}
		}
	}
	/**
	 * Read all messages in the received mailbox, and mark them as read
	 */
	public void readAllMessages()
	{
		for (Message m : inMailbox.keySet())
		{
			//TODO Read the message
			
			// ...
			
			//
			inMailbox.put(m, true);
		}
	}
	/**
	 * Read the first unread message in the received mailbox, and delete it
	 */
	public void readDeleteMessage()
	{
		for(Message m : inMailbox.keySet())
		{
			if(!inMailbox.get(m))
			{
				//TODO Read the message
				
				// ...
				
				//
				inMailbox.remove(m);
			}
			
			return;
		}
	}
	/**
	 * Read all unread message in the received mailbox, and delete them
	 */
	public void readDeleteAllMessages()
	{
		for(Message m : inMailbox.keySet())
		{
			if(!inMailbox.get(m))
			{
				//TODO Read the message
				
				// ...
				
				//
				inMailbox.remove(m);
			}
		}
	}
}
