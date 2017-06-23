
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class TestZookeeper extends BaseZookeeper{
	/**
	* Logger for this class
	*/
	public ZooKeeper startZk() throws IOException{
		
		return new ZooKeeper(CONNECTSTRING,TIMEOUT,null);
	}
	
	public void stopZk(ZooKeeper zk) throws InterruptedException{
		if(zk!=null){
			zk.close();
		}
	}
	
	public String createNode(ZooKeeper zk,String path,String nodeValue) throws KeeperException, InterruptedException{
		String create = zk.create(path, nodeValue.getBytes(),Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		return create;
	}
	
	public String getNode(ZooKeeper zk,String path) throws KeeperException, InterruptedException{
		
		byte[] data = zk.getData(path, false, new Stat());
		return data.toString();
	}
	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		TestZookeeper test=new TestZookeeper();
		
		ZooKeeper startZk = test.startZk();
		
		if(startZk==null){
			String createNode = test.createNode(startZk,PATH, "youaremytest");
			logger.info("======"+createNode);
			String node = test.getNode(startZk, PATH);
			
		}else{
			logger.info("=======i already have this");
		}
	}
}
