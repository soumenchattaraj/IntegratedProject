package sparkTest;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

public class SparkTextFile {

	public static void main(String[] args) {
		
		
		SparkConf  sparkConf = new SparkConf()
											.setAppName("wordCount")
											.setMaster("master");
		
		JavaSparkContext sc = new JavaSparkContext(sparkConf);
		
		
		JavaRDD<String> mainFileRDD = sc.textFile("D:/output/*");
		JavaRDD<String> errorFileRDD = mainFileRDD.filter(new Function<String,Boolean>() 
			{
			
				@Override
				public Boolean call(String arg0) throws Exception {
					// TODO Auto-generated method stub
					return arg0.contains("error");
			}
		});
		
		System.out.println("counting total lines:::"+errorFileRDD.count());
		
		for(String errors : errorFileRDD.take(10))
		{
			System.out.println(errors);
		
		}
		
		
		JavaRDD<String> warningFileRDD = mainFileRDD.filter(new Function<String, Boolean>() 
			{
			
				@Override
				public Boolean call(String arg0) throws Exception {
					// TODO Auto-generated method stub
					return arg0.contains("warnings");
			}
		});
		
		
		
		
	}

}
