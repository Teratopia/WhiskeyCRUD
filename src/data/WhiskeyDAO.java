package data;

import java.util.List;

public interface WhiskeyDAO {
	public List<Dram> getDrams();
	public void setWhiskeys(List<Dram> whiskeys);
	public List<Dram> getWhiskeys();
	public List<Contact> getContacts();
	public void setContacts(List<Contact> contacts);
}
