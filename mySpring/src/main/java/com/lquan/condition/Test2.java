package com.lquan.condition;/**
 * Created by 01370602 on 2020/5/2.
 */

import com.lquan.condition.model.User;
import com.lquan.condition.util.UtilCOmmmon;

/**
 * ClassName Test2
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
public class Test2 {

	public static void main(String[] args) {

		User user = new User("Mac","系统是Mac可以这册到容器");
		System.out.println(user);

		UtilCOmmmon.change(user,"LQuan");


		System.out.println(user);
	}

}
