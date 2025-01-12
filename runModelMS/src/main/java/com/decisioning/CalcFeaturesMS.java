package com.decisioning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;
import java.util.Date;
import java.sql.Timestamp;



public class CalcFeaturesMS {
	
	private static final Logger LOG = LoggerFactory.getLogger(KafkaInstance.class);

	public CalcFeaturesMS() {
		// TODO Auto-generated constructor stub
	}

	//execute rules
	public String execute(String line, String previousState)
	{		                                   		

		 //
		String appid=null;
		Random rand = new Random();		     

		
        //read the id out of the line
        appid = line.split(":")[1].trim().split(",")[0].split("\"")[1];
    	
        Date date = new Date();
		long currentTime = date.getTime();
		Timestamp ts = new Timestamp(currentTime);	
        
        //generate a random number between 1-100, if 50 or greater then mark as Fraudulent transaction
		if (rand.nextInt(100)>49)
			line = "{\"id\":\"" + appid + "\",\"action\": \"Features Calculated\",\"data\": {\"timestamp\": \"" + ts + "\", \"time\": \"472\", \"v1\": \"-3.043540624\", \"v2\": \"-3.157307121\",\"v3\": \"1.08846278\",\"v4\": \"2.288643618\",\"v5\": \"1.35980513\",\"v6\": \"-1.064822523\",\"v7\": \"0.325574266\",\"v8\": \"-0.067793653\",\"v9\": \"-0.270952836\",\"v10\": \"-0.838586565\",\"v11\": \"-0.414575448\",\"v12\": \"-0.50314086\",\"v13\": \"0.676501545\",\"v14\": \"-1.692028933\",\"v15\": \"2.000634839\",\"v16\": \"0.666779696\",\"v17\": \"0.599717414\",\"v18\": \"1.725321007\",\"v19\": \"0.28334483\",\"v20\": \"2.102338793\",\"v21\": \"0.661695925\",\"v22\": \"0.435477209\",\"v23\": \"1.375965743\",\"v24\": \"-0.293803153\",\"v25\": \"0.279798032\",\"v26\": \"-0.145361715\",\"v27\": \"-0.252773123\",\"v28\": \"0.035764225\",\"amount\": \"529\"}}";
		else
			line = "{\"id\":\"" + appid + "\",\"action\": \"Features Calculated\",\"data\": {\"timestamp\": \"" + ts + "\", \"time\": \"7891\", \"v1\": \"-1.585505367\", \"v2\": \"-3.261584548\",\"v3\": \"-4.137421983\",\"v4\": \"2.357096252\",\"v5\": \"-1.405043314\",\"v6\": \"-1.879437193\",\"v7\": \"-3.513686871\",\"v8\": \"1.515606746\",\"v9\": \"-1.207166361\",\"v10\": \"-6.234561332\",\"v11\": \"5.450746067\",\"v12\": \"-7.333714067\",\"v13\": \"1.361193324\",\"v14\": \"-6.608068252\",\"v15\": \"-0.481069425\",\"v16\": \"-2.60247787\",\"v17\": \"-4.835112052\",\"v18\": \"-0.553026089\",\"v19\": \"0.351948943\",\"v20\": \"0.315957259\",\"v21\": \"0.501543149\",\"v22\": \"-0.546868812\",\"v23\": \"-0.076583636\",\"v24\": \"-0.425550367\",\"v25\": \"0.123644186\",\"v26\": \"0.321984539\",\"v27\": \"0.264028161\",\"v28\": \"0.13281672\",\"amount\": \"1\"}}}";						
			
		return line;
	}
}