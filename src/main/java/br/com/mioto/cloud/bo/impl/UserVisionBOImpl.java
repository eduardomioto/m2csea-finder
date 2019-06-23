package br.com.mioto.cloud.bo.impl;

import br.com.mioto.cloud.bo.UserVisionBO;
import br.com.mioto.cloud.dao.MicroserviceDAO;
import br.com.mioto.cloud.dao.UserVisionDAO;
import br.com.mioto.cloud.vo.UserVision;
import com.ecwid.consul.v1.ConsulClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class UserVisionBOImpl implements UserVisionBO {

    @Autowired
    private UserVisionDAO userVisionDAO;

    public List<UserVision> getAllUserVision() throws SQLException {
        return  userVisionDAO.getAllUserVision();
    }

    public void storeUserVision(UserVision userVision) throws SQLException {
        userVisionDAO.storeUserVision(userVision);
    }

    public void updateUserVision(UserVision userVision) throws SQLException {
        userVisionDAO.storeUserVision(userVision);
    }
}
