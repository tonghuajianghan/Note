/*-------------------------------------------------------------------------
* 版权所有：北京光宇在线科技有限责任公司
* 作者：guohai
* 联系方式：guohai@gyyx.cn
* 创建时间： 2014年9月1日
* 版本号：v1.0
* 本类主要用途描述：
* xxxxxxxxxxxxxxxxxxxxxx
-------------------------------------------------------------------------*/
package cn.gyyx.test.guohai.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.gyyx.test.guohai.beans.UserInfo;

public class UserDAO {

	private SqlSessionFactory sqlSessionFactory;
	
	public UserDAO() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
	
	/**
	 * 获取用户信息
	 * @param account 账号名
	 * @return 账号实体
	 */
	public UserInfo getUserInfo(String account) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper userDao = session.getMapper(UserMapper.class);
			return userDao.selectByAccount(account);
		} finally {
			session.close();
		}
	}
	
	public UserInfo getUserInfo(int code){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserInfo user = (UserInfo) session.selectOne("User.selectByAccount", code);
			return user;
		} finally {
			session.close();
		}
	}
	
	public List<UserInfo> getUserInfo(List<String> listAccount){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper userDao = session.getMapper(UserMapper.class);
			return userDao.selectByAccounts(listAccount);
		} finally {
			session.close();
		}
	}
}