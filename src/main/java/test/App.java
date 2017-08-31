package test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.UserDao;
import entity.User;

public class App {
	SqlSession ss;
	public App(){
		try {
			 Reader reader = Resources.getResourceAsReader("config/config.xml");
			
			 SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
			 
			 ss=ssf.openSession();
		} catch (IOException e) {
			System.err.println("读取资源文件出错啦   "+e);
		}
	}
	
    public static void main( String[] args )
    {
        App app = new App();
        app.findUser();
    }

	private void findUser() {
		UserDao Usermapper = ss.getMapper(UserDao.class);
		User findUser = Usermapper.findUser();
		System.out.println(findUser);
	}
    
}
