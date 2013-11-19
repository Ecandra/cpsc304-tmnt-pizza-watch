package pizzawatch.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import pizzawatch.sql.sqlreader.ResultSetParser;
import pizzawatch.sql.sqlreader.SqlScriptReader;

public class LoginSecurity {
	@SuppressWarnings("serial")
	private static Map<String, String> usersPasswords = new HashMap<String, String>();

	public void initializePasswords()
	{
			usersPasswords.put("Leonardo","watern4tur3");
			usersPasswords.put("Raphael","red");
			usersPasswords.put("Michaelangelo","purple");
			usersPasswords.put("Donatello", "kawabanga");
			usersPasswords.put("Master Splinter","p3aceinm1nd");
	}
	/**
	 * @param userID
	 * @param userPass
	 * @return password of String userID in hashTable if userPass == the corresponding user's
	 * password in Tables 
	 * -1 otherwise
	 */
	public String loginUser(String userID, String userPass)
	{
		if(usersPasswords.get(userID).equals(userPass))
		{
			return usersPasswords.get(userID);
		}
		
		return null;
	}
	
	/**
	 * check if user admin
	 * @param userID
	 * @return true when an admin user
	 */
	public boolean checkAdmin(String userID)
	{
		SqlScriptReader sqlreader = new SqlScriptReader();
		
		ArrayList<LinkedList<String>> users = ResultSetParser.parseResultSetIntoArray(sqlreader.query("SQL_Scripts/checkAdmin.sql"), "name");
		
		if(users.equals(null)){return false;}
		else
		{
			for(int i=0;i<users.get(0).size();i++)
			{
				String values = (String) users.get(0).get(i);
				if(values.equals(null))
				{
					return false;
				}else if(values.equals(userID))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * hash secure pass
	 * @param userID
	 * @param userPass	
	 */
	public void hashPassword(String userID, String userPass)
	{
		if(!usersPasswords.containsKey(userID))
		{
			usersPasswords.put(userID, userPass);
		}
	}
	
}
