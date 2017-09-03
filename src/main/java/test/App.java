package test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.UserDao;
import entity.User;

public class App {
	SqlSessionFactory ssf;
	public App(){
		try {
			 Reader reader = Resources.getResourceAsReader("config/config.xml");
			
//			 Properties prop=new Properties();
//			 prop.setProperty("driver", "com.mysql.jdbc.Driver");
//			 prop.setProperty("url", "jdbc:mysql://localhost:3306/shiro");
//			 prop.setProperty("username", "root");
//			 prop.setProperty("password", "root");
			 
//			 ssf = new SqlSessionFactoryBuilder().build(reader,prop);
			 ssf = new SqlSessionFactoryBuilder().build(reader);
			 
		} catch (IOException e) {
			System.err.println("读取资源文件出错啦   "+e);
		}
	}
	
    public static void main( String[] args )
    {
        App app = new App();
//        app.findUser();
        app.insertUser();
    }

	private void insertUser() {
		SqlSession ss1=ssf.openSession();
		UserDao mapper1 = ss1.getMapper(UserDao.class);
		User user = new User();
		user.setUserName("lemon");
		user.setPassword("123");
		user.setPassword_salt("l");
		int id = mapper1.insertUser(user);
		System.out.println(id);
		ss1.commit();
	}

	private void findUser() {
		SqlSession ss1=ssf.openSession();
		UserDao mapper1 = ss1.getMapper(UserDao.class);
		mapper1.findUser();
//		ss.commit();
//		mapper1.findUser();
		ss1.close();
		
		//开启一个新的session，由于每个session不共享一级缓存，所以该session没有缓存
		SqlSession ss2=ssf.openSession();
		UserDao mapper2 = ss2.getMapper(UserDao.class);
		mapper2.findUser();
		
	}
    
}
