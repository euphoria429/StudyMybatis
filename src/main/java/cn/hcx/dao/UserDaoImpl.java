//package cn.hcx.dao;
//
//import cn.hcx.bean.User;
//import org.apache.ibatis.session.SqlSession;
//import org.mybatis.spring.support.SqlSessionDaoSupport;
//
//public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
//    @Override
//    public void findUserById(int uid) {
//        SqlSession sqlSession=this.getSqlSession();
//        User user=sqlSession.selectOne("findUserById",uid);
//    }
//}
