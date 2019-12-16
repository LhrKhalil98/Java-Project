package Data;


import java.util.List ;

import presentation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ruun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection cx =  (Connection) SingleConnection.getConnection(); 
		stock  s = new StockMnp () ; 
		new Home(); 
		System.out.println(s.getAllProduct());

	}

}
