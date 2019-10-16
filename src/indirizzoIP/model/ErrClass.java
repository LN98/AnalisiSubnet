package indirizzoIP.model;

import java.util.ArrayList;
import java.util.List;

public class ErrClass {
	
	 private List<String> msg=new ArrayList<>();
	 
	 public void addMsg(String a) {
		 msg.add(a);
	 }
	 
	 public void clear() {
		 msg.clear();
	 }
	 
	 public List<String> getMsg() {
		return msg;
	}



	public boolean isErr() {
		 return msg.size()!=0;
	 }
	 
	 

}
