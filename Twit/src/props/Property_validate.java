package props;

import props.Access_property;


import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class Property_validate {

	public static void initialize(String conffile) throws Exception {
		
		File file = new File(conffile);
		FileInputStream fileInput = new FileInputStream(file);

        Properties props = new Properties();
        props.load(fileInput);


        for (Object key : props.keySet()) {
           props.getProperty((String) key);
       }

        
        Access_property.initialize(props);

        
//        if (Access_property.getProperty(Properties_assign.FACEBOOK_API_BASE_URL) == null) {
//			throw new Exception("Facebook api base url can not be empty!!!");
//		}
        
//        if(Integer.parseInt(Access_property.getProperty(Properties_assign.FACEBOOK_FAMILY_MAX_FETCH_LIMIT)) < 0 ) {
//        	throw new Exception(Properties_assign.FACEBOOK_FAMILY_MAX_FETCH_LIMIT + " property can not be smaller than 0.");
//        } 
        
//        if(Integer.parseInt(Access_property.getProperty(Properties_assign.FACEBOOK_LIKES_MAX_FETCH_LIMIT)) < 0 ) {
//        	throw new Exception(Properties_assign.FACEBOOK_LIKES_MAX_FETCH_LIMIT + " property can not be smaller than 0.");
//        }
        
//        if(Integer.parseInt(Access_property.getProperty(PropertyDefinitions.FACEBOOK_FRIENDS_MAX_FETCH_LIMIT)) < 0 ) {
//        	throw new Exception(Properties_assign.FACEBOOK_FRIENDS_MAX_FETCH_LIMIT + " property can not be smaller than 0.");
//        } 
        
//        if(Integer.parseInt(Access_property.getProperty(PropertyDefinitions.FACEBOOK_STATUSES_MAX_FETCH_LIMIT)) < 0 ) {
//        	throw new Exception(Properties_assign.FACEBOOK_STATUSES_MAX_FETCH_LIMIT + " property can not be smaller than 0.");
//        } 
        
//        if(Access_property.getProperty(Properties_assign.SOCIALCALL_WS_ENDPOINT) == null) {
//			throw new Exception(Properties_assign.SOCIALCALL_WS_ENDPOINT + " property can not be empty");
//        }
        
//        if(Access_property.getProperty(Properties_assign.ING_FACEBOOK_ACCESS_TOKEN_ENDPOINT) == null) {
//			throw new Exception(Properties_assign.ING_FACEBOOK_ACCESS_TOKEN_ENDPOINT + " property can not be empty");
//        }
        
        // workerCount
//        logger.info("Application configurations loaded successfully");
    }

}
	
	
	

