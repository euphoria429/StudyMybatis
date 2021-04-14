package cn.hcx;

import cn.hcx.bean.User;
import cn.hcx.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestUser {
    @Test
    public void TestFindUserById() throws Exception {
        String resource="Mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        UserDao userDao=session.getMapper(UserDao.class);
        User user=userDao.findUserById(3);
        System.out.println(user.toString());

        session.commit();
        session.close();
    }
    @Test
    public void TestAdd()throws Exception{
        String resource="Mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        UserDao userDao=session.getMapper(UserDao.class);
        int num=userDao.findCount();//flag

        User user=new User(5,"zzy",22,"female",2);
        userDao.addUser(user);

        int num2=userDao.findCount();//flag

        if(num<num2){System.out.println("新增数据成功");}
        else {
            System.out.println("新增数据失败");
        }


        session.commit();
        session.close();
    }
    @Test
    public void TestCount()throws Exception{
        String resource="Mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        UserDao userDao=session.getMapper(UserDao.class);
        int num=userDao.findCount();
        System.out.println(num);

        session.commit();
        session.close();
    }
    @Test
    public void TestIdOrName()throws Exception{
        String resource="Mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        UserDao userDao=session.getMapper(UserDao.class);
        User user=new User("zzy");
        User user1=new User(2);
        List<User> users=session.selectList("findByIdOrName",user1);
        for(User user2:users){
            System.out.println(user2.toString());
        }

        session.commit();
        session.close();
    }
    @Test
    public void TestUpdate()throws Exception{
        String resource="Mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        UserDao userDao=session.getMapper(UserDao.class);

        User user=new User(3,"ly");
        userDao.update(user);

        List<User> users=session.selectList("findByIdOrName",user);
        for(User user1:users){
            System.out.println(user1.toString());
        }

        session.commit();
        session.close();
    }

    @Test
    public void TestUpdateIf()throws Exception{
        String resource="Mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        UserDao userDao=session.getMapper(UserDao.class);

        User user=new User(3,30);
        userDao.updateIf(user);

        List<User> users=session.selectList("findByIdOrName",user);
        for(User user1:users){
            System.out.println(user1.toString());
        }

        session.commit();
        session.close();
    }

    @Test
    public void TestDelete()throws Exception{
        String resource="Mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        UserDao userDao=session.getMapper(UserDao.class);
        int num=userDao.findCount();//flag

        userDao.delete(5);

        int num2=userDao.findCount();//flag

        if(num>num2){System.out.println("删除成功");}
        else {
            System.out.println("删除失败");
        }


        session.commit();
        session.close();
    }

    @Test
    public void TestDeleteByIds()throws Exception{
        String resource="Mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        UserDao userDao=session.getMapper(UserDao.class);
        int num=userDao.findCount();//flag

        List<Integer> ids=new ArrayList<Integer>();
        ids.add(5);
        ids.add(6);
        session.selectList("deleteByIds",ids);

        int num2=userDao.findCount();//flag

        int num3=num-num2;
        if(num>num2){System.out.println("成功删除"+num3+"条数据");}
        else {
            System.out.println("删除失败");
        }


        session.commit();
        session.close();
    }
}
