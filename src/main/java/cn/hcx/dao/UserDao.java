package cn.hcx.dao;

import cn.hcx.bean.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user) throws Exception;//新增一条记录
    public int findCount() throws Exception;//查询表记录数量
    public User findUserById(int uid) throws Exception;//根据id查询数据
    public User findByIdOrName(User user) throws Exception;//使用动态sql根据条件进行查询数据
    public void update(User user) throws Exception;//更新一条数据
    public void updateIf(User user) throws Exception;//使用动态sql根据条件更新数据，即字段不为空时更新
    public void delete(int id) throws Exception;//根据id删除一条数据
//    public void delete(<List>)
}
