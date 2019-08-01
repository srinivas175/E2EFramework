import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class ProdWindowsAuthrobot {
	static Robot robot;
	public static void main(String args[]) throws IOException, AWTException {
		robot = new Robot();
		robot.delay(10000);
		enterChars ("oupuser");
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		//enterChars("tab");
		enterChars("T343mvvP");		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	public static void enterChars (String windowsusername) throws AWTException {		
		for (int c=0; c<windowsusername.length(); c++) {
				char sd = windowsusername.charAt(c);				
				//doTypeNormalChar(sd);				
				robot.delay(40);
				System.out.println(sd);

			switch (sd) {
				
			        case 'a': 
			        	robot.keyPress(KeyEvent.VK_A);
			    		robot.keyRelease(KeyEvent.VK_A);
						System.out.println("aaaaa");
			    		break;
			    			
			        case 'o': 
		        		robot.keyPress(KeyEvent.VK_O);
		        		robot.keyRelease(KeyEvent.VK_O);
						System.out.println("oooo");
		        		break;
		        			
			        case 'u': 
		    			robot.keyPress(KeyEvent.VK_U);
		    			robot.keyRelease(KeyEvent.VK_U);
		    			break;
		    			
			        case 'p': 
		    			robot.keyPress(KeyEvent.VK_P);
		    			robot.keyRelease(KeyEvent.VK_P);
		    			break;   		
		    			
			        case 'b': 
		    			robot.keyPress(KeyEvent.VK_B);
		    			robot.keyRelease(KeyEvent.VK_B);
		    			break;
		    		
			        case 'e': 
		    			robot.keyPress(KeyEvent.VK_E);
		    			robot.keyRelease(KeyEvent.VK_E);
		    			break;
		    		
			        case 't': 
		    			robot.keyPress(KeyEvent.VK_T);
		    			robot.keyRelease(KeyEvent.VK_T);
		    			break;
		    		
			        case 'T': 
			        	robot.keyPress(KeyEvent.VK_CAPS_LOCK);
			        	robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
		    			robot.keyPress(KeyEvent.VK_T);
		    			robot.keyRelease(KeyEvent.VK_T);
		    			robot.keyPress(KeyEvent.VK_CAPS_LOCK);
			        	robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
		    			break;    	
		    		
			        case 's': 
		    			robot.keyPress(KeyEvent.VK_S);
		    			robot.keyRelease(KeyEvent.VK_S);
		    			break;
		    		
			        case 'r': 
		    			robot.keyPress(KeyEvent.VK_R);
		    			robot.keyRelease(KeyEvent.VK_R);
		    			break;     			
		    			
			        case '2': 
		    			robot.keyPress(KeyEvent.VK_2);
		    			robot.keyRelease(KeyEvent.VK_2);
		    			break;    			
		    			
			        case '3': 
		    			robot.keyPress(KeyEvent.VK_3);
		    			robot.keyRelease(KeyEvent.VK_3);
		    			break;
		    			
			        case '4': 
		    			robot.keyPress(KeyEvent.VK_4);
		    			robot.keyRelease(KeyEvent.VK_4);
		    			break;
		    			
			        case 'm': 
		        		robot.keyPress(KeyEvent.VK_M);
		    			robot.keyRelease(KeyEvent.VK_M);
		    			break;
		    			
			        case 'v': 
		        		robot.keyPress(KeyEvent.VK_V);
		    			robot.keyRelease(KeyEvent.VK_V);
		    			break;
		    		
			        case 'P': 
			        	robot.keyPress(KeyEvent.VK_CAPS_LOCK);
			        	robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
		        		robot.keyPress(KeyEvent.VK_P);
		    			robot.keyRelease(KeyEvent.VK_P);
		    			robot.keyPress(KeyEvent.VK_CAPS_LOCK);
			        	robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
		    			break;
		    			
				}
			
			}
			
			
		}
	}
  