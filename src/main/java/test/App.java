package test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import entity.Order;
import entity.OrderCustom;
import entity.OrderDetail;
import entity.User;
import mapper.OrderCustomMapper;

public class App {
	SqlSessionFactory ssf;
	public App(){
		try {
			 Reader reader = Resources.getResourceAsReader("config/config.xml");
			
			 ssf = new SqlSessionFactoryBuilder().build(reader);
			 
		} catch (IOException e) {
			System.err.println("读取资源文件出错啦   "+e);
		}
	}
	
    public static void main( String[] args )
    {
    	App a=new App();
//    	a.t1();
//    	a.t2();
    	a.t3();
    }

    
	private void t3() {
		
		SqlSession openSession = ssf.openSession();
		OrderCustomMapper mapper = openSession.getMapper(OrderCustomMapper.class);
		OrderDetail od = mapper.findOrderDetailExt(2);
		System.out.println();
	}

	private void t2() {
		SqlSession openSession = ssf.openSession();
		OrderCustomMapper mapper = openSession.getMapper(OrderCustomMapper.class);
		List<Order> findOrderUserDetail = mapper.findOrderUserDetail();
		for(Order o:findOrderUserDetail){
			System.out.println(o);
		}
	}

	private void t1() {
		SqlSession openSession = ssf.openSession();
		OrderCustomMapper mapper = openSession.getMapper(OrderCustomMapper.class);
		List<User> findOrderUser = mapper.findOrderUser();
		for(User o:findOrderUser){
			System.out.println(o);
		}
		
	}

    
}
