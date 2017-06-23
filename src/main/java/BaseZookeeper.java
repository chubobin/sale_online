import org.apache.log4j.Logger;

public abstract class BaseZookeeper {
	
	protected static final Logger logger = Logger.getLogger(TestZookeeper.class);
	
	protected static final String PATH="/newNode";
	
	protected static final String CONNECTSTRING ="192.168.137.128:2181";
	
	protected static final int TIMEOUT=50*1000;
}
