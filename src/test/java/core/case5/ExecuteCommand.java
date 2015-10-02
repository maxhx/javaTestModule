package core.case5;

import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExecuteCommand extends ExecCommand {
	private static final Log log = LogFactory.getLog(ExecuteCommand.class);
	
	@Override
	protected void lineHandler(String lineStr) {
		try {
			log.info(new String(lineStr.getBytes(),"GBK"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
