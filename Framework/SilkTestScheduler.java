package tests;

import java.io.File;


import com.borland.silktest.jtf.BrowserBaseState;
import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.common.types.Point;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomTextField;
import com.borland.silktest.jtf.common.types.Point;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.java.GeneralLibrary;

public class SilkTestScheduler extends GeneralLibrary {
	public Desktop desktop = new Desktop();
	
	File f=new File(System.getProperty("user.dir")+"/../src/silk4j.settings");
	BrowserBaseState baseState = new BrowserBaseState(f);
	//BrowserBaseState ffBase = new BrowserBaseState(BrowserType.Firefox,"http://localhost:9090/InsuranceWebExtJS/");
	
	
	public void test_login() {
		try{
			System.out.println("the user director is---"+System.getProperty("user.dir"));
		baseState.execute(desktop);
		desktop.<DomTextField>find("//INPUT[@id='Username']").typeKeys("silktest1<Tab>");
		desktop.<DomTextField>find("//INPUT[@id='Password']").typeKeys("silktest@1");
		desktop.<DomListBox>find("//SELECT[@id='userType']").select("Maxis ID");
		desktop.<DomListBox>find("//SELECT[@id='userType']").select("MEPS");
		desktop.<DomLink>find("//A[@id='csm_login']").click();
		desktop.<DomElement>find("//IMG[1]").click();
		desktop.<DomLink>find("//A[@textContents='Logout']").click();
		//pass("User is able to login");
	
		return;
		}
		catch(Exception e)
		{
			fail("Exception occured while performing login"+e.getMessage());
			return;
		}
	}
	
	public void test_navigation()
	{
		try{
		baseState.execute(desktop);
		desktop.<DomTextField>find("/BrowserApplication//BrowserWindow//INPUT[@id='Username']").typeKeys("silktest1<Tab>");
		desktop.<DomTextField>find("/BrowserApplication//BrowserWindow//INPUT[@id='Passw']").typeKeys("silktest@1");
		desktop.<DomListBox>find("/BrowserApplication//BrowserWindow//SELECT[@id='userType']").select("Maxis ID");
		desktop.<DomListBox>find("/BrowserApplication//BrowserWindow//SELECT[@id='userType']").select("MEPS");
		desktop.<DomLink>find("/BrowserApplication//BrowserWindow//A[@id='csm_login']").click(1, new Point(40, 15));
		//MCP Navigation
		desktop.<DomElement>find("/BrowserApplication//BrowserWindow//IMG[@title='ECP Services']").click(1, new Point(138, 138));
		desktop.<DomListBox>find("/BrowserApplication//BrowserWindow//SELECT").select("MCP Services");
		desktop.<DomLink>find("//A[@textContents='Logout']").click();
		}
		catch(Exception e)
		{
			fail(e.getMessage());
			return;
		}
	}


}
