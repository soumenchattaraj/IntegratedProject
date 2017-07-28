package sparkTest;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

public class SparkStream {

	public static void main(String[] args) throws InterruptedException {
		
		
		SparkConf sparkConf = new SparkConf().setMaster("local[*]").setAppName("Spark Streaming");
		JavaStreamingContext ssc = new JavaStreamingContext(sparkConf,new Duration(10));
		
		JavaDStream<String> mainFileRDD = ssc.textFileStream("D/output/");
	
	    JavaDStream<String> jss = mainFileRDD.filter(new Function<String, Boolean>() 
	    {
			
			public Boolean call(String v1) throws Exception
			{
				return v1.contains("errors");
			}
		});
				
	    jss.print();
				
		ssc.start();
		ssc.awaitTerminationOrTimeout(10000);
		ssc.stop();
	}

}
