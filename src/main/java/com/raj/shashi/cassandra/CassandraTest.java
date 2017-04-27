package com.raj.shashi.cassandra;


import java.util.List;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

/**
 * @author shashi
 *
 */
public class CassandraTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		Session session = cluster.connect();

		/*String query = "CREATE KEYSPACE test WITH replication "
				+ "= {'class':'SimpleStrategy', 'replication_factor':1};";
		session.execute(query);
		session.execute("USE test");
		System.out.println("Keyspace created.");*/
		session.execute("USE test");
		/*String query = "CREATE TABLE emp(emp_id int PRIMARY KEY, "
				   + "emp_name text, "
				   + "emp_city text, "
				   + "emp_sal varint, "
				   + "emp_phone varint );";
				session.execute(query);
				
				System.out.println("table created.");*/
		
		/* String query= "INSERT INTO emp (emp_id, emp_name, emp_city, emp_phone,  emp_sal)"
					
         + " VALUES(1,'ram', 'Hyderabad', 9848022338, 50000);" ;
		 session.execute(query);
		 System.out.println("data inserted.");*/
		
		String query="select * from emp";
		com.datastax.driver.core.ResultSet result=session.execute(query);
		List<Row> list=(result.all());
		list.stream().forEach(row->{
			System.out.println(row);
		});
		 

	}

}
