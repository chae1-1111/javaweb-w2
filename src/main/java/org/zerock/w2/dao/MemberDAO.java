package org.zerock.w2.dao;

import lombok.Cleanup;
import org.zerock.w2.domain.MemberVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

    public MemberVO getWithPassword (String userid, String userpw) throws Exception {
        String sql = "select * from tbl_member where userid = ? and userpw = ?;";

        MemberVO memberVO = null;

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, userid);
        preparedStatement.setString(2, userpw);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        memberVO = MemberVO.builder()
                .userid(resultSet.getString("userid"))
                .userpw(resultSet.getString("userpw"))
                .username(resultSet.getString("username"))
                .build();

        return memberVO;
    }

    public void updateUuid(String userid, String uuid) throws Exception {

        String sql = "update tbl_member set uuid = ? where userid = ?;";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,uuid);
        preparedStatement.setString(2,userid);

        preparedStatement.executeUpdate();
    }

    public MemberVO selectUUID(String uuid) throws Exception {
        String sql = "select * from tbl_member where uuid = ?;";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, uuid);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        MemberVO memberVO = MemberVO.builder()
                .userid(resultSet.getString("userid"))
                .userpw(resultSet.getString("userpw"))
                .username(resultSet.getString("username"))
                .uuid(resultSet.getString("uuid"))
                .build();

        return memberVO;
    }
}
