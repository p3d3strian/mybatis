package mapper;

import java.util.List;

import entity.Order;
import entity.User;

public interface OrderCustomMapper {
	
	//查询订单与对应的用户的信息
	List<User> findOrderUser();
	
	List<Order> findOrderUserDetail();
	
	List<User> findOrderUserDetailExt();
}
