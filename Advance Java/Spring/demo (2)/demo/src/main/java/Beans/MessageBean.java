package Beans;

public class MessageBean
{
	private String Message , sendername;
	private AddressBean ReceiverAddress; // bean object autowire can be done 
	
	public void setReceiverAddress(AddressBean receiverAddress) {
		ReceiverAddress = receiverAddress;
	}
	
	public AddressBean getReceiverAddress() {
		return ReceiverAddress;
	}
	
	
	// default Constructor
	public  MessageBean()
	{
		System.out.println("Constructor of MessageBean "+"\n"+" That means the instance is created");
	}
	
	public MessageBean(String message, String sendername, AddressBean receiverAddress) 
	{
		System.out.println("MessageBean Constructor with 3 parametrs");
		Message = message;
		this.sendername = sendername;
		ReceiverAddress = receiverAddress;
	}

	public MessageBean (AddressBean recAddressBean)
	{
		System.out.println("MessageBean with 1 Parameter is called  . . . ");
		Message="Have a  nice day";
		sendername="Bhim";
		this.ReceiverAddress=recAddressBean;
	}
	
	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
		System.out.println("SetMessage of MessageBean is called ");
	}

	public String getSendername() {
		return sendername;
	}

	public void setSendername(String sendername) {
		System.out.println("Setsendername of MessageBean is called ");
		this.sendername = sendername;
	}
	
	
}
